package com.itqf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name = "tb_sys_user")
@AllArgsConstructor
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userid;

    @Column(name = "login_name")
    private String loginName;

    private String password;

    private Byte state;

    @Column(name = "create_time")
    private Date createTime;

    private String realname;


    public SysUser() {

    }
}