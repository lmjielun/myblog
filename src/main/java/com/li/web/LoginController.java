package com.li.web;

import com.li.entity.User;
import com.li.service.ILoginService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /** 跳转到登录页面,如果什么都不写，你输入admin后直接会找login页面*/
    @GetMapping
    public String loginPage()
    {
        return "/admin/login";
    }

    /** 登录方法*/
    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          RedirectAttributes attributes)
    {
        User user = loginService.checkUser(username, password);
        if(user == null){
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }else{
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }
    }

    /** 注销方法*/
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
