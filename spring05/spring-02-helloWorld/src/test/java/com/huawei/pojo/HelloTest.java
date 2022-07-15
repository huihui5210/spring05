package com.huawei.pojo;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class HelloTest {
    @Test
    public void shuoldPrintH(){
        Hello hello = new Hello();
        String name =hello.getStr();
        Assert.assertEquals(name,"你好华子");
    }

}