package com.example.demo;

import org.springframework.stereotype.Service;

@Service("ZhGreeting")
public class ZhGreeting implements Greeting {
    @Override
    public String hello() {
        return "你好";
    }
}
