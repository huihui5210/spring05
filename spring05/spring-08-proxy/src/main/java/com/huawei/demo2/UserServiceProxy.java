package com.huawei.demo2;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userService ;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("add");
        userService.add();
    }

    public void update() {
        log("add");
        userService.add();
    }

    public void select() {
        log("add");
        userService.add();
    }

    private void log(String msg){
        System.out.println("[debug] 使用了" + msg + "方法");
    }

}
