package com.codeqs.service.impl;

import com.codeqs.mapper.RoleMapper;
import com.codeqs.pojo.Role;
import com.codeqs.pojo.RoleExample;
import com.codeqs.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public List<Role> query(Role role) throws Exception {
        RoleExample example = new RoleExample();
        return mapper.selectByExample(example);
    }

    @Override
    public Role queryById(Integer id) throws Exception {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if(id != null){
            criteria.andRoleIdEqualTo(id);
            return mapper.selectByExample(example).get(0);
        }
        return null;
    }

    @Override
    public Role queryByName(String roleName) throws Exception {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if(roleName != null){
            criteria.andRoleNameEqualTo(roleName);
            List<Role> roles = mapper.selectByExample(example);
            if(roles != null && roles.size() > 0){
                return mapper.selectByExample(example).get(0);
            }
        }
        return null;
    }

    @Override
    public Integer addRole(Role role) throws Exception {
        return mapper.insertSelective(role);
    }

    @Override
    public Integer updateRole(Role role) throws Exception {
        return mapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Integer deleteRoleById(Integer id) throws Exception {
        return mapper.deleteByPrimaryKey(id);
    }

}
