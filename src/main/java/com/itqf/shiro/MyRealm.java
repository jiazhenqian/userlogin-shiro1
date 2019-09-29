package com.itqf.shiro;

import com.itqf.dao.SysUserPerRepository;
import com.itqf.dao.SysUserRepository;
import com.itqf.dao.UserRepository;
import com.itqf.domain.SysPermission;
import com.itqf.domain.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Author 贾振乾
 * Date 2019/9/28
 * Time 11:09
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserPerRepository sysUserPerRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username=(String)principals.getPrimaryPrincipal();

        List<SysPermission> sysPermissions=sysUserPerRepository.findPermissionByLoginName(username);

        Collection permissions=new HashSet<>();

        for(SysPermission permission:sysPermissions){
                permissions.add(permission.getPerName());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName=(String)token.getPrincipal();

        SysUser sysUser =sysUserRepository.findByLoginName(loginName);
//        System.out.println("=====>"+sysUser.getPassword());

        SimpleAuthenticationInfo simpleAuthenticationInfo=
                new SimpleAuthenticationInfo(loginName,sysUser.getPassword(),getName());

        return simpleAuthenticationInfo;
    }
}
