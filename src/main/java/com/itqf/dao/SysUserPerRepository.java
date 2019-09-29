package com.itqf.dao;

import com.itqf.domain.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author 贾振乾
 * Date 2019/9/28
 * Time 17:14
 */
public interface SysUserPerRepository extends JpaRepository<SysPermission,Integer> {

    @Query(value = "select sp.* from tb_sys_user u,tb_sys_role r,tb_sys_permission sp, tb_user_role tr,tb_role_permission tp\n" +
            "        where u.userid = tr.user_id\n" +
            "        and tr.role_id = r.role_id\n" +
            "        and r.role_id = tp.role_id\n" +
            "        and tp.permission_id = sp.permission_id\n" +
            "        and u.login_name =:username", nativeQuery = true)
    List<SysPermission> findPermissionByLoginName(String username);


}
