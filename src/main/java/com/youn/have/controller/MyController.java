package com.youn.have.controller;

import com.youn.have.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/foo")
public class MyController {

    @Value("${thread.pool.size}")
    private int threadPoolSize;

    @RequestMapping(value = "/bar")
    public int bar() {
        User myConfig = new User();
        myConfig.getId();
        return threadPoolSize;
    }

}
