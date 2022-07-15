package com.huawei.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }
    public void seeHouse(){
        System.out.println("中介看房子");
    }
    public void payRent(){
        System.out.println("中介收房租");
    }

    public void rent() {
        seeHouse();
        host.rent();
        payRent();
    }

}
