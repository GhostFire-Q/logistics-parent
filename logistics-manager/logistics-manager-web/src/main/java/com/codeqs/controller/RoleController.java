package com.codeqs.controller;

import com.codeqs.pojo.Role;
import com.codeqs.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService service;

    @RequestMapping("/query")
    public String query(Role role, Model model) throws Exception{
        List<Role> list = service.query(role);
        model.addAttribute("list",list);
        return "role/role";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role,Model model) throws Exception{
        if(role.getRoleId() != null && role.getRoleId() > 0){
            service.updateRole(role);
        }else{
            if(service.queryByName(role.getRoleName()) == null){
                service.addRole(role);
                return "redirect:/role/query";
            }else{
                model.addAttribute("errorMessage","该角色已存在！！！");
                model.addAttribute("role",role);
                return "/role/updateRole";
            }
        }
        return "redirect:/role/query";
    }

    @RequestMapping("/deleteRole")
    public String deleteRole(Integer id) throws Exception {
        service.deleteRoleById(id);
        return "redirect:/role/query";
    }

}
