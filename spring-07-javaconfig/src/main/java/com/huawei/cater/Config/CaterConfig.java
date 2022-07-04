package com.huawei.cater.Config;

import com.huawei.cater.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaterConfig {
    @Bean
    public User getUser(){
        return new User();
    }
}
