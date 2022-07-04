package com.huawei.demo03;

import com.huawei.demo2.UserService;
import com.huawei.demo2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //创建房东对象
        UserServiceImpl userService = new UserServiceImpl();
        //创建动态代理对象，也就是中介
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //放入需要代理的对象，也就是房东
        proxyInvocationHandler.setTarget(userService);
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();
        proxy.add();
    }
}
