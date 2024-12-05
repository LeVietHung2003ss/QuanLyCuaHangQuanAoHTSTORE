package org.example.web_shop_quan_ao.Controller.Admin;

import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.example.web_shop_quan_ao.Seviece.KhachHangSevice;
import org.example.web_shop_quan_ao.Seviece.SanPhamSeviece;
import org.example.web_shop_quan_ao.Seviece.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("userdto")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    public SanPhamSeviece sanPhamSeviece;
    @Autowired
    public KhachHangSevice khachHangSevice;
    @Autowired
    public TaiKhoanService taiKhoanService;
    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }

    @GetMapping
    private String admin(Model model){
        long soLuongSanPham= sanPhamSeviece.DemSoLuongSanPham();
        long soLuongKhachHang=khachHangSevice.DemSoLuongKhachHang();
        model.addAttribute("demSoLuongSanPham",soLuongSanPham);
        model.addAttribute("demSoLuongKhachHang",soLuongKhachHang);
        return "admin/admin";
    }
    @GetMapping("/login")
    public  String login(){
        return "admin/login";
    }
    @PostMapping
    public String trangchu(Model model, @ModelAttribute("userdto") TaiKhoan taiKhoan){
        TaiKhoan taiKhoan1=taiKhoanService.getUserbyEmail(taiKhoan.getUserName());
        if (taiKhoan.getUserName() == null || taiKhoan.getUserName().isEmpty()) {
            return "redirect:/admin?emailwrong";
        }
        if (taiKhoan.getPassWord() == null || taiKhoan.getPassWord().isEmpty()) {
            return "redirect:/admin?passwordwrong";
        }

//        if (!taiKhoanService.checkUserbyEmail(taiKhoan.getUserName())) {
//            return "redirect:/home/userlogin?emailwrong";
//        }
//        if (!taiKhoanService.checkUserbyPassword(taiKhoan.getPassWord())) {
//            return "redirect:/home/userlogin?passwordwrong";
//        }
        if(!taiKhoanService.checkUserbyEmailAndPassword(taiKhoan.getUserName(),taiKhoan.getPassWord())){
            return "redirect:/admin?emailwrong";
        }
        if(taiKhoanService.checkUserbyEmailAndPassword(taiKhoan.getUserName(),taiKhoan.getPassWord()) && taiKhoan1.getVaitro().equals("ADMIN")){
            long soLuongSanPham= sanPhamSeviece.DemSoLuongSanPham();
            long soLuongKhachHang=khachHangSevice.DemSoLuongKhachHang();
            model.addAttribute("demSoLuongSanPham",soLuongSanPham);
            model.addAttribute("demSoLuongKhachHang",soLuongKhachHang);
            return "admin/admin";
        }else {
            return "redirect:/admin?passwordwrong";
        }
    }

}
