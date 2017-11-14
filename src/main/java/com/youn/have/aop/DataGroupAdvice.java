package com.youn.have.aop;

import com.youn.have.annotation.DataGroup;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

//import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//@Aspect
@Component
public class DataGroupAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    private static final String[] dataArr = {"java", "python", "scala"};

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("--------------");
        if(method.isAnnotationPresent(DataGroup.class)) {
            if (null != args && args.length > 0) {
                args[args.length - 1] = dataArr;
            }
            if(null == args || args.length <= 0){
                args = new Object[1];
                args[0] = dataArr;
            }
        }
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

    }

}
