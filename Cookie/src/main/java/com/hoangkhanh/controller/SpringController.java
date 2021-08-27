package com.hoangkhanh.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoangkhanh.util.CookieUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringController {
    
    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/blog")
    public String getBlog() {
        return "blog";
    }

    @GetMapping("/settingform")
    public String getSetting() {
        return "setting";
    }

    @PostMapping("/setting")
    public String getSetting(
            @RequestParam(required = false) String backgcolor,
            @RequestParam(required = false) String fontcolor,
            @RequestParam(required = false) String fontsize,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ) {
        if (backgcolor != null) {
            Cookie bgColor = CookieUtil.createCookie(
                    "bgcolor", // Key
                    backgcolor, // Value
                    30, // Số giây cho đến khi hết hạn
                    true, // isSecured, yêu cầu cookie gửi lên bằng HTTPS
                    false, // HttpOnly, nếu bằng true thì javascript phía client sẽ không đọc được, chỉ server đọc
                    "/", // cookie này có hiệu lực từ đường dẫn nào
                    request.getServerName()); // server nào
            response.addCookie(bgColor);
        }
        if (fontcolor != null) {
            Cookie fcolor = CookieUtil.createCookie(
                    "fcolor", 
                    fontcolor, 
                    30, 
                    true, 
                    false,
                    "/", 
                    request.getServerName());
            response.addCookie(fcolor);
        }
        if (fontsize != null) {
            Cookie fsize = CookieUtil.createCookie(
                    "fsize",
                    fontsize,
                    30, 
                    true, 
                    false,
                    "/",
                    request.getServerName()); 
                    response.addCookie(fsize);
        }
        return "setting";
    }


}
