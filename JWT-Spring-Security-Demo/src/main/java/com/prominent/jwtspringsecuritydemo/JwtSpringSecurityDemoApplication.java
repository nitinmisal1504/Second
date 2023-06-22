package com.prominent.jwtspringsecuritydemo;

import com.prominent.jwtspringsecuritydemo.model.User;
import com.prominent.jwtspringsecuritydemo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtSpringSecurityDemoApplication {
    @Autowired
    private UserRepository repository;
    @PostConstruct
    public void initUsers(){
        List<User> users= Stream.of(
                new User(101,"Nitin","12345","misalnitin.beit@gmail.com" )
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtSpringSecurityDemoApplication.class, args);
    }

}
