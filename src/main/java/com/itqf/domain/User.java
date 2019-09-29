package com.itqf.domain;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Author 贾振乾
 * Date 2019/9/25
 * Time 11:05
 */
@Entity
@Table(name = "user")
@Data
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;
        
        private String password;

        private int age;

        private int power;

        private String country;
}
