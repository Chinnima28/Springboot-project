package com.chinmayie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse greet() {
        return new GreetResponse(
                "Hello, welcome!",
                List.of("Java", "Python", "SQL"),
                new Person("Chinmayie")
        );
    }

    record Person(String name) {}
    record GreetResponse(
            String message,
            List<String> favProgrammingLangs,
            Person person
    ) {}
}
