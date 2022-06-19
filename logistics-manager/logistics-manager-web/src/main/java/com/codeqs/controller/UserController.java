package com.codeqs.controller;

import com.codeqs.pojo.Role;
import com.codeqs.pojo.User;
import com.codeqs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("/query")
    public String query(User user, Model model) throws Exception{
        List<User> list = service.query(user);
        model.addAttribute("list",list);
        return "user/user";
    }

}
