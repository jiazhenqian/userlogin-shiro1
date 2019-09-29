package com.itqf.service.impl;

import com.itqf.Response.ResponseUser;
import com.itqf.dao.SysUserRepository;
import com.itqf.domain.SysUser;
import com.itqf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author 贾振乾
 * Date 2019/9/25
 * Time 11:14
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public ResponseUser findAll(Integer page,Integer size) {
        PageRequest pages=PageRequest.of(page-1,size);
        Page<SysUser> all=sysUserRepository.findAll(pages);

        ResponseUser responseUser=new ResponseUser();
        responseUser.setList(all.getContent());
        responseUser.setTotal(all.getTotalElements());

        return responseUser;
    }

    @Override
    public void regist(SysUser sysUser) {
        sysUserRepository.save(sysUser);
    }

    @Override
    public String deleteUser(int id) {
        sysUserRepository.deleteById(id);
        return "success";
    }

    @Override
    public SysUser selectById(Integer id) {
        Optional<SysUser> sysUser=sysUserRepository.findById(id);
        if(sysUser.isPresent()){
            return sysUser.get();
        }
        return null;
    }

    @Override
    public String updateUser(SysUser sysUser) {
        sysUserRepository.save(sysUser);
        return "success";
    }

//    @Override
//    public String  dealLogin(User user) {
//       User user1=userRepository.findByNameAndPassword(user.getName(),user.getPassword());
//       if(user1!=null){
//           return "登录成功";
//       }
//       System.out.println(user1);
//
//        return "登录失败";
//    }

}
