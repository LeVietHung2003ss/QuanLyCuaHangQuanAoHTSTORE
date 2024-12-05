package org.example.web_shop_quan_ao.Controller.Home;

import lombok.AllArgsConstructor;
import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.example.web_shop_quan_ao.Seviece.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
@RequestMapping(value = "/home")
public class UserLoginController {
    @Autowired
    public TaiKhoanService taiKhoanService;
    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }

    @GetMapping(value = "/userlogin")
    public String login(){
        return "home/userlogin";
    }
    @PostMapping
    public String userlogin(Model model, @ModelAttribute("userdto") TaiKhoan taiKhoan) {
        if (taiKhoan.getUserName() == null || taiKhoan.getUserName().isEmpty()) {
            return "redirect:/home/userlogin?emailwrong";
        }
        if (taiKhoan.getPassWord() == null || taiKhoan.getPassWord().isEmpty()) {
            return "redirect:/home/userlogin?passwordwrong";
        }

//        if (!taiKhoanService.checkUserbyEmail(taiKhoan.getUserName())) {
//            return "redirect:/home/userlogin?emailwrong";
//        }
//        if (!taiKhoanService.checkUserbyPassword(taiKhoan.getPassWord())) {
//            return "redirect:/home/userlogin?passwordwrong";
//        }
        if(!taiKhoanService.checkUserbyEmailAndPassword(taiKhoan.getUserName(),taiKhoan.getPassWord())){
            return "redirect:/home/userlogin?emailwrong";
        }
        TaiKhoan taiKhoan1=taiKhoanService.findByUsername(taiKhoan.getUserName());

        model.addAttribute("userdto",taiKhoan1);
        return "redirect:/home/trangchu";
    }

}
