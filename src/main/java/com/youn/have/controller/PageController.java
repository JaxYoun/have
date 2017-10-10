package com.youn.have.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping ("/toIndex")
    public String toIndex(){
        System.out.println("------");
        return "page/index";
    }

    @RequestMapping ("/go")
    public String go(){
        System.out.println("++++++++");
        return "welcome";
    }

    @RequestMapping ("/wel")
    public ModelAndView wel(ModelAndView modelAndView){
        modelAndView.setViewName("welcome");
        modelAndView.getModelMap().put("hello", "Hi");
        logger.warn("welcome");
        System.out.println("===========");
        return modelAndView;
    }

    @RequestMapping ("/getUser")
    public void getUser() {
        System.out.println(jdbcTemplate.queryForList("SELECT * FROM t_user").size());
    }

}
