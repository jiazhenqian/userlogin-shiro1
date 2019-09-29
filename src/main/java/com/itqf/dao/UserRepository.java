package com.itqf.dao;

import com.itqf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Author 贾振乾
 * Date 2019/9/25
 * Time 11:12
 */

public interface UserRepository  extends JpaRepository<User,Integer> {
    User findByNameAndPassword(String name,String password);
}
