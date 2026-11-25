package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class HelloService {
    public String greet(){
        return "hello from Service";
    }

    @PostConstruct
    public void init(){
        System.out.println("HelloService is created");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("HelloService is destroyed");
    }
}
