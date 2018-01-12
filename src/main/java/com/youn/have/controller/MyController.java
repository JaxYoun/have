package com.youn.have.controller;

import com.youn.have.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/foo")
public class MyController {

    /**
     * 读取配置属性测试
     */
    @Value("${thread.pool.size}")
    private int threadPoolSize;

    /**
     * 自定义配置类测试
     *
     * @return
     */
    @RequestMapping(value = "/bar")
    public int bar() {
        User myConfig = new User();
        myConfig.getId();
        return threadPoolSize;
    }

    /**
     * spring-boot热部署组件测试
     *
     * @return
     */
    @PostMapping("/devtoolTest")
    public String devtoolTest() {
        return "111";
    }

}
