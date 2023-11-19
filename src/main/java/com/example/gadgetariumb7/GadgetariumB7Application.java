package com.example.gadgetariumb7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class GadgetariumB7Application {

    public static void main(String[] args) {
        SpringApplication.run(GadgetariumB7Application.class, args);
        System.out.println("Gadgetarium проектиси");
    }

    @GetMapping("/")
    public String greetings() {
        return "introduction";
    }
}