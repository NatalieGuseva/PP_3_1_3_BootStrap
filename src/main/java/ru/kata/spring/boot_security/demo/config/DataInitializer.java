package ru.kata.spring.boot_security.demo.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repo.RoleRepo;
import ru.kata.spring.boot_security.demo.repo.UserRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        return args -> {

            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepo.save(adminRole);

            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepo.save(userRole);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEmail("admin@gmail.com");
            admin.setRoles(new HashSet<>(Arrays.asList(adminRole, userRole)));
            userRepo.save(admin);

            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setEmail("user@mail.ru");
            user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
            userRepo.save(user);
        };
    }
}