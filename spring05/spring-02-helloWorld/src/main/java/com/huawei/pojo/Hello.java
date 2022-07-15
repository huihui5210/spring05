package com.huawei.pojo;

public class Hello {
    private String str;
    public void show(){
        System.out.println("你好华子");
    }
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Hello() {
    }

    public Hello(String str) {
        this.str = str;
    }
}
