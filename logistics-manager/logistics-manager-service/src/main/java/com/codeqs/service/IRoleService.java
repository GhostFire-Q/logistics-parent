package com.codeqs.service;

import com.codeqs.pojo.Role;

import java.util.List;

/**
 * 角色信息
 */
public interface IRoleService {

    /**
     * 根据条件查询角色信息
     * @param role
     * @return
     */
    List<Role> query(Role role) throws Exception;

    /**
     * 根据ID查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    Role queryById(Integer id) throws Exception;

    /**
     * 根据角色名称查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    Role queryByName(String roleName) throws Exception;

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    Integer addRole(Role role) throws Exception;

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    Integer updateRole(Role role) throws Exception;

    /**
     * 根据ID编号删除角色
     */
    Integer deleteRoleById(Integer id) throws Exception;

}
