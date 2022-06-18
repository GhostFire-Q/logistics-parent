package com.codeqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
