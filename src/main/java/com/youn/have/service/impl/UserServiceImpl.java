package com.youn.have.service.impl;

import com.youn.have.entity.Employee;
import com.youn.have.entity.Phone;
import com.youn.have.entity.User;
import com.youn.have.repository.EmployeeRepository;
import com.youn.have.repository.UserRepository;
import com.youn.have.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private PhoneRepository phoneRepository;

    @Override
    public User getUserIncludePhone(User user) {
        //创建匹配器，即如何使用查询条件
//        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
//                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
//                .withIgnorePaths("age");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//        Example<User> example = Example.of(user, matcher);
//        return userRepository.findOne(example);
        return userRepository.findOne(user.getId());
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
//        Department department = new Department();
//        department.setId(1);
        return employeeRepository.findEmployeeById(id);  //, 1);
    }

    @Override
    public Specification<Phone> getPhoneById(Integer id) {
        Phone phone = new Phone();
        phone.setVender("小");
        phone.setId(id);

        return new Specification<Phone>(){
            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<Phone> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate venderPredicate = criteriaBuilder.like(root.get("vender").as(String.class), "%" + phone.getVender() + "%");
                Predicate idPredicate = criteriaBuilder.equal(root.get("id").as(Integer.class), id);

                criteriaQuery.where(venderPredicate, idPredicate);
                return criteriaQuery.getRestriction();
            }
        };
    }

    @Override
    public List<User> getUserByGreaterAge(Integer smallAge, Integer bigAge) {
        return userRepository.findUserByGreaterAge(smallAge, bigAge);
    }
}
