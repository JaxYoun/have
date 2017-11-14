package com.youn.have.service;

import com.youn.have.entity.Employee;
import com.youn.have.entity.Phone;
import com.youn.have.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IUserService {

    void addUser(User user);

    void deleteUser(User user);

    User getUserById(Integer id);

    List<User> getUserByGreaterAge(Integer samllAge, Integer bigAge);

    User getUserIncludePhone(User user);

    Employee getEmployeeById(Integer id);

    Specification<Phone> getPhoneById(Integer id);

}
