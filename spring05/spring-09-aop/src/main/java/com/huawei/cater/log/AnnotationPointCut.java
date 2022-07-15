package com.huawei.cater.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut  {
    @Before("execution(* com.huawei.cater.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("===执行方法前===");
    }
    @After("execution(* com.huawei.cater.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("===执行方法后===");
    }

}
