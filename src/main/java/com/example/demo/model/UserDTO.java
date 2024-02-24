package com.example.demo.model;

public class UserDTO {

    private String name;
    private String id;

    public UserDTO(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Integer.parseInt(id);
    }

}
