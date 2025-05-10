package com.example.bcsd.controller.dto.resopnse;

public class JsonResponse {
    private int age;
    private String name;

    public JsonResponse(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
