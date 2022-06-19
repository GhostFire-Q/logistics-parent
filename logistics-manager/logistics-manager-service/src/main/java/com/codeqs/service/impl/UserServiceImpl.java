package com.codeqs.service.impl;

import com.codeqs.mapper.UserMapper;
import com.codeqs.pojo.User;
import com.codeqs.pojo.UserExample;
import com.codeqs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> query(User user) throws Exception {
        UserExample example = new UserExample();

        return mapper.selectByExample(example);
    }

    @Override
    public Integer addUser(User user) throws Exception {
        return mapper.insertSelective(user);
    }

    @Override
    public Integer updateUser(User user) throws Exception {
        /*Selective有选择性的,会判断是否为空在进行更新*/
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer deleteUserById(Integer id) throws Exception {
        return mapper.deleteByPrimaryKey(id);
    }

}
