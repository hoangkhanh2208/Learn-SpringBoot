package vn.techmaster.shopingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import vn.techmaster.shopingcart.model.Customer;

import vn.techmaster.shopingcart.service.MailService;

@RestController
public class MailController {
    
    @Autowired
    private MailService mailService;

    @PostMapping("/confirm")
    public String confirmEmail() {
        return "index";
    }

    @ResponseBody
    @PostMapping("/sendEmail")
    public void sendEmail(@ModelAttribute("customer") Customer customer, HttpSession session) {
        mailService.sendMail(customer, session);
    }
}
