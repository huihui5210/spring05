package com.huawei.pojo;

public class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println(this.name);
    }
}
