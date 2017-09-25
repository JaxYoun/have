package com.youn.have.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping ("/toIndex")
    public String toIndex(){
        System.out.println("------");
        return "page/index";
    }

    @RequestMapping ("/go")
    public String go(){
        System.out.println("++++++++");
        return "index";
    }

    @RequestMapping ("/wel")
    public String wel(){
        System.out.println("===========");
        return "welcome";
    }

}
