package com.youn.have.repository;

import com.youn.have.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor {

    User findUserById(Integer id);

    @Query("select user from User user where user.age > ?1 and user.age < ?2")
    List<User> findUserByGreaterAge(Integer samllAge, Integer bigAge);

}
