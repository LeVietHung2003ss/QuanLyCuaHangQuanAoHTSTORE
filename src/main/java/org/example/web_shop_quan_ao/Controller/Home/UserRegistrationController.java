package org.example.web_shop_quan_ao.Controller.Home;

import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.example.web_shop_quan_ao.Seviece.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class UserRegistrationController {
    @Autowired
    public TaiKhoanService taiKhoanService;
    @ModelAttribute("userdto")
    public TaiKhoan userResgistration(){
        return new TaiKhoan();
    }
    @GetMapping(value = "/registration")
    public String fromLoginRegistration(){
        return "home/registration";
    }
    @PostMapping(value = "/registration")
    public String loginRegistration(@ModelAttribute("userdto") TaiKhoan taiKhoan){
        if (taiKhoan.getFullName()== null || taiKhoan.getFullName().isEmpty()) {
            return "redirect:/home/registration?fullname";
        }
        if (taiKhoan.getUserName() == null || taiKhoan.getUserName().isEmpty()) {
            return "redirect:/home/registration?emailwrong";
        }
        if (taiKhoan.getPassWord() == null || taiKhoan.getPassWord().isEmpty()) {
            return "redirect:/home/registration?passwordwrong";
        }
        if (taiKhoan.getAddress() == null || taiKhoan.getAddress().isEmpty()) {
            return "redirect:/home/registration?address";
        }
        if (taiKhoan.getEmail() == null || taiKhoan.getEmail().isEmpty()) {
            return "redirect:/home/registration?email";
        }
        if (taiKhoan.getTelephone() == null || taiKhoan.getTelephone().isEmpty()) {
            return "redirect:/home/registration?telephone";
        }
        taiKhoanService.themTaiKhoan(taiKhoan);

        return "redirect:/home/userlogin";
    }
}
