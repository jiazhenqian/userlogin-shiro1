package com.itqf.controller;

import com.itqf.Response.ResponseUser;
import com.itqf.domain.SysUser;
import com.itqf.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author 贾振乾
 * Date 2019/9/25
 * Time 11:16
 */
@RestController
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/findAll/{page}/{size}")
    public ResponseUser findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

        return sysUserService.findAll(page,size);
    }

    @RequestMapping("/regist")
    public String insert(@RequestBody SysUser sysUser){
//        注意null和''和无的区别
        System.out.println("user==>"+sysUser);
        System.out.println("username==>"+sysUser.getLoginName());
        System.out.println("password==>"+sysUser.getPassword());
        if(sysUser.getLoginName()!=""&&sysUser.getPassword()!=""){
//            System.out.println("判断成功");

            sysUserService.regist(sysUser);
            return "注册成功";
        }else {
            return "注册失败";
        }
    }

    @RequiresPermissions(value={"user_edit"})
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestBody SysUser sysUser){
        System.out.println(sysUser);
        return sysUserService.deleteUser(sysUser.getUserid());
    }

    @RequestMapping("/selectById")
    public SysUser selectById(@RequestBody SysUser sysUser){

       return sysUserService.selectById(sysUser.getUserid());
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody SysUser sysUser){
        return sysUserService.updateUser(sysUser);
    }


    @RequestMapping("/sysuserLogin")
    public String sysuserLogin(@RequestBody SysUser sysUser){
        System.out.println(sysUser);

        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(sysUser.getLoginName(),sysUser.getPassword());
        try{
            subject.login(token);
            if(subject.isAuthenticated()){


                return "登录成功";
            }else{
                return "登录失败";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "登录失败";
    }

    @RequestMapping("/unauth")
    public String unauth(){
        return "unauth";
    }



}
