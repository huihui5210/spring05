package com.huawei.demo01;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Client {
    public static void main(String[] args) {
        Host host= new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
