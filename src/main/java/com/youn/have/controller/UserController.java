package com.youn.have.controller;

import com.youn.have.annotation.DataGroup;
import com.youn.have.dto.UserDTO;
import com.youn.have.entity.Employee;
import com.youn.have.entity.Phone;
import com.youn.have.entity.User;
import com.youn.have.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("addUser")
    public void addUser(){
        Phone phone = new Phone();
        phone.setPrice(2000F);
        phone.setVender("小米");

        Phone iPhone = new Phone();
        iPhone.setPrice(7000F);
        iPhone.setVender("苹果");

        Set<Phone> phoneSet = new HashSet<>();
        phoneSet.add(phone);
        phoneSet.add(iPhone);

        User user = new User();
        user.setAge(11);
        user.setName("杨建雄");
        user.setPhoneSet(phoneSet);

        userService.addUser(user);
    }

    @GetMapping("deleteUser")
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }

    @GetMapping("/getUserById")
    public UserDTO getUserById(Integer id) {
        UserDTO userDTO = new UserDTO();
        User user = userService.getUserById(id);
        BeanUtils.copyProperties(user, userDTO, "phoneSet");
        return userDTO;
    }

    @GetMapping("/getUserByGreaterAge")
    public List<User> getUserByGreaterAge(Integer smallAge, Integer bigAge) {
        return userService.getUserByGreaterAge(smallAge, bigAge);
    }

    @GetMapping("/getUserIncludePhone")
    public User getUserIncludePhone(User user){
        return userService.getUserIncludePhone(user);
    }

    @GetMapping("/getPhoneById")
    public Specification<Phone> getPhoneById(Integer id) {
        return userService.getPhoneById(id);
    }

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(Integer id) {
        return userService.getEmployeeById(id);
    }

    @GetMapping("/getDataGroupTest")
    public void getDataGroupTest() {
        gg("kk", null);
    }

    @DataGroup
    private void gg(String kk, String[] arr) {
        System.out.println("=============:" + kk);
        System.err.println("+++++++ +++++++++" + arr.length);

        Arrays.stream(arr).forEach(System.out::println);
    }

}
