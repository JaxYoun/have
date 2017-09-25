package com.youn.have.controller;

import com.youn.have.entity.MyConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/foo")
public class MyController {

    @Value("${thread.pool.size}")
    private int threadPoolSize;

    @RequestMapping(value = "/bar")
    public int bar(){
        MyConfig myConfig = new MyConfig();
        myConfig.getId();
        return threadPoolSize;
    }

}
