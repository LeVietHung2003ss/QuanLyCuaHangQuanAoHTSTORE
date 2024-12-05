package org.example.web_shop_quan_ao.Controller.Admin;

import org.example.web_shop_quan_ao.Model.KhachHang;
import org.example.web_shop_quan_ao.Model.NhaCungCap;
import org.example.web_shop_quan_ao.Seviece.KhachHangSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class KhachHangController {
    @Autowired
    public KhachHangSevice khachHangSevice;
    @GetMapping(value = "/khachhang")
    public String khachHang(Model model, @RequestParam(value = "search",required = false)String search){
        List<KhachHang>list;
        if(search!=null && !search.isEmpty()){
            list=khachHangSevice.TimKiemKhachHang(search);
        }else{
            list=khachHangSevice.DsKhachHang();
        }
        model.addAttribute("search",search);
        model.addAttribute("DsKhachHang",list);
        return "admin/khachhang";
    }
    @GetMapping(value = "/khachhang/themkhachhang")
    public String themKhachHang(Model model){
        KhachHang khachHang=new KhachHang();
        model.addAttribute("themKhachHang",khachHang);
        return "admin/khachhang/themkhachhang";
    }
    @PostMapping(value ="/khachhang/themkhachhang")
    public String add(@ModelAttribute("themNhaCungCap")KhachHang khachHang){
        khachHangSevice.ThemKhachHang(khachHang);
        return "redirect:/admin/khachhang";
    }
    @GetMapping(value = "/khachhang/suakhachhang/{id}")
    public String suaKhachHang(Model model,@PathVariable("id")Integer id){
        Optional<KhachHang>khachHang=khachHangSevice.findKhachHangById(id);
        model.addAttribute("suaKhachHang",khachHang.get());
        return "admin/khachhang/suakhachhang";
    }
    @PostMapping(value ="/khachhang/suakhachhang")
    public String edit(@ModelAttribute("suaKhachHang") KhachHang khachHang){
        khachHangSevice.SuaKhachHang(khachHang);
        return "redirect:/admin/khachhang";
    }
    @GetMapping(value = "/khachhang/xoakhachhang/{id}")
    public String xoaNhaCungCap(@PathVariable("id")Integer id){
       khachHangSevice.XoaKhachHang(id);
        return "redirect:/admin/khachhang";
    }
}
