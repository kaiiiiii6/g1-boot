package com.example.demo;

import org.springframework.stereotype.Service;

@Service("EnGreeting")
public class EnGreeting implements Greeting {
    @Override
    public String hello() {
        return "hi";
    }
}
