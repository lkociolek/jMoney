package dev.kociolek.jmoney;

import dev.kociolek.jmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserService service;

    @Autowired
    public DataLoader(UserService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Set<Role> roles = new HashSet<>(Arrays.asList(Role.ROLE_ADMIN));
//        User user = new User("admin",
//                "admin@company.com",
//                "password",
//                true,
//                roles);
//        service.create(user);
//
//        roles = new HashSet<>(Arrays.asList(Role.ROLE_USER));
//        user = new User("enabled",
//                "user@company.com",
//                "password",
//                true,
//                roles);
//        service.create(user);
//
//        roles = new HashSet<>(Arrays.asList(Role.ROLE_USER));
//        user = new User("disabled",
//                "jkowalski@company.com",
//                "password",
//                false,
//                roles);
//        service.create(user);
//        Optional<List<User>> byEmail = service.findByEmail("jkowalski@company.com");
//        if(byEmail.isPresent()) {
//            List<User> users = byEmail.get();
//            users.forEach(u -> service.delete(u));
//        }
    }
}
