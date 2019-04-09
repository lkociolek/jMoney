package dev.kociolek.jmoney.service;

import dev.kociolek.jmoney.JMoneyApplication;
import dev.kociolek.jmoney.domain.Role;
import dev.kociolek.jmoney.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JMoneyApplication.class})
@SpringBootTest
public class UserServiceTest {

    private UserService service;
    private User user;
    private User userAfterUpdate;
    private Set<Role> authorities;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @Before
    public void setUp() {
        authorities = new HashSet<>(Arrays.asList(Role.values()));
        user = new User("jkowalski", "jkowalski@company.com", "password", true, authorities);
    }

    @Test
    public void shouldCreateUser() {
        assertNotNull(service.create(user));
    }

    @Test
    public void shouldUpdateUser() {
        user = service.create(user);
        userAfterUpdate = new User("pnowak", "pnowak@company.com", "qwerty", true, authorities);
        userAfterUpdate.setId(user.getId());
        userAfterUpdate = service.create(userAfterUpdate);
        userAfterUpdate = service.update(userAfterUpdate);
        assertEquals(user.getId(), userAfterUpdate.getId());
    }

    @Test
    public void shouldDeleteUser() {
        service.delete(user);
        assertEquals(Optional.empty(), service.findById(user.getId()));
    }

    @Test
    public void shouldFindUserById() {
        user = service.create(user);
        Optional<User> byId = service.findById(user.getId());
        assertTrue(byId.isPresent());
    }
}