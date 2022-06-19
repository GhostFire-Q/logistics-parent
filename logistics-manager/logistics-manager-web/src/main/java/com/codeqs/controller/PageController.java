package com.codeqs.controller;

import com.codeqs.pojo.Role;
import com.codeqs.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 页面跳转的控制器
 */
@Controller
public class PageController {

    @RequestMapping(value={"/","/main"})
    public String showMain(){
        return "main";
    }

    /**
     * Restful 风格处理
     * @return
     */
    @RequestMapping("/{path}")
    public String showPage(@PathVariable String path){
        return path;
    }

    @Autowired
    private IRoleService service;

    /**
     * 添加角色页面跳转
     * @return
     */
    @RequestMapping("/role/roleDispatch")
    public String handlePageDispatch(Integer id, Model model) throws Exception{
        if(id != null){
            // 更新数据
            Role role = service.queryById(id);
            model.addAttribute("role",role);
        }
        return "/role/updateRole";
    }

}
