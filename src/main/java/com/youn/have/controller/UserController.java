package com.youn.have.controller;

import com.youn.have.annotation.DataGroup;
import com.youn.have.dto.PhoneDTO;
import com.youn.have.dto.UserDTO;
import com.youn.have.entity.Employee;
import com.youn.have.entity.Phone;
import com.youn.have.entity.User;
import com.youn.have.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Slf4j
@Validated
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

    /**
     *
     * @param date
     */
    @PostMapping(value = "/getDateFromFront", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void getDateFromFront(
            @RequestParam(name = "time", required = true, defaultValue = "2017-11-3 8:59:11")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {

        System.out.println(date);
    }

    /**
     *
     * @param age
     * @param userDTO
     * @param phoneDTO
     */
    @PostMapping("/validTest")
    public void validTest(
            @Range(min = 1, max = 9, message = "年龄只能在1-9岁") int age,
            @NotBlank(message = "不能为空") @RequestBody UserDTO userDTO,
            @ModelAttribute @Valid PhoneDTO phoneDTO
            ) {
        System.out.println(age);
    }

    @PostMapping("/transImageToBase64")
    public String transImageToBase64(@RequestParam("multipartFile") MultipartFile multipartFile) {
        InputStream inputStream = null;
        byte[] byteArr = null;

        if(multipartFile != null) {
            System.out.println(multipartFile.getSize());
            if((multipartFile.getSize() / 1024) > 3) {
            }
        }

        try {
            inputStream = multipartFile.getInputStream();
            byteArr = new byte[inputStream.available()];
            inputStream.read(byteArr);
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return new String(Base64.encode(byteArr));
    }
}
