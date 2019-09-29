package com.itqf.service;

import com.itqf.Response.ResponseUser;
import com.itqf.domain.SysUser;
import com.itqf.domain.User;

import java.util.List;

/**
 * Author 贾振乾
 * Date 2019/9/25
 * Time 11:13
 */
public interface SysUserService {

    ResponseUser findAll(Integer page, Integer size);

    void regist(SysUser sysUser);

    String deleteUser(int id);

    SysUser selectById(Integer id);

    String updateUser(SysUser sysUser);

//    String  dealLogin(User user);
}
