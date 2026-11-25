package com.example.demo;

import jakarta.validation.constraints.NotBlank;

public class GreetRequest {

    @NotBlank(message = "name不能为空")
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
