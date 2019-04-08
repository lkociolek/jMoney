package dev.kociolek.jmoney;

import dev.kociolek.jmoney.domain.Role;
import dev.kociolek.jmoney.domain.User;
import dev.kociolek.jmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    private UserService service;

    @Autowired
    public DataLoader(UserService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Set<Role> roles = new HashSet<>(Arrays.asList(Role.values()));
//        User user = new User("user",
//                "jkowalski@company.com",
//                "$2y$12$AXdhfEBvZhnPZbwJ9/MBh.Im/ETCq2hx8m9Ly1qdyTgE7lTnfS4wS",
//                roles);
//        service.create(user);

//        Optional<List<User>> byEmail = service.findByEmail("jkowalski@company.com");
//        if(byEmail.isPresent()) {
//            List<User> users = byEmail.get();
//            users.forEach(u -> service.delete(u));
//        }
    }
}
