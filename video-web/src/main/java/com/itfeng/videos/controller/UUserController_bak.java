package com.itfeng.videos.controller;

import com.itfeng.videos.pojo.User;
import com.itfeng.videos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user_bak")
public class UUserController_bak {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(User user, HttpServletRequest request) {
        user = userService.selectUserByEmailAndPassword(user);
        if (null != user) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", user.getEmail());
            return "success";
        }
        return "failed";
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");
        return "success";
    }

    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail(String email) {
        User user = userService.selectUserByEmail(email);
        if (null != user) {
            return "hasUser";
        }
        return "success";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user, HttpServletRequest request) {
        user.setCreateTime(new Date());
        if (userService.insertUser(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount",user.getEmail());
            return "success";
        }
        throw new RuntimeException("用户注册失败");
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "/before/forget_password";
    }



    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String email, String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionEmail= (String) session.getAttribute("email");
        String sessionCode = (String) session.getAttribute("code");
        if (sessionEmail.equals(email)&&sessionCode.equals(code)) {
            return "/before/reset_password";
        }
        return "redirect:/user/forgetpassword";
    }

    @RequestMapping("/resetPassword")
    public String requestPassword(String email, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("email");
        return "redirect:/";
    }





}
