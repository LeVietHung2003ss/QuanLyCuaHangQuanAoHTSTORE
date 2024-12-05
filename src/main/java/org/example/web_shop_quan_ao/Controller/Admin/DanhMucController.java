package org.example.web_shop_quan_ao.Controller.Admin;

import org.example.web_shop_quan_ao.Model.LoaiSanPham;
import org.example.web_shop_quan_ao.Seviece.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class DanhMucController {
    @Autowired
    public LoaiSanPhamService loaiSanPhamService;
    @GetMapping("/danhmuc")
    public String danhmuc(Model model){
        List<LoaiSanPham>list=loaiSanPhamService.DsLoaiSanPham();
//        if(search!=null && !search.isEmpty()){
//            list=loaiSanPhamService.TimKiemDanhMuc(search);
//        }else {
//            list=loaiSanPhamService.DsLoaiSanPham();
//        }
//        list=loaiSanPhamService.DsLoaiSanPham();
        model.addAttribute("DsDanhMuc",list);
        return "admin/danhmuc";
    }
    @GetMapping(value = "/danhmuc/themdanhmuc")
    public String themdanhmuc(Model model){
        LoaiSanPham loaiSanPham=new LoaiSanPham();
        model.addAttribute("themDanhMuc",loaiSanPham);
        return "admin/danhmuc/themdanhmuc";
    }
    @PostMapping(value = "/danhmuc/themdanhmuc")
    public String add(@ModelAttribute("themDanhMuc") LoaiSanPham loaiSanPham){
        if (loaiSanPham.getTenLoai() == null || loaiSanPham.getTenLoai().isEmpty()) {
            return "redirect:/admin/danhmuc/themdanhmuc?tenLoai";
        }
        loaiSanPhamService.ThemLoaiSanPham(loaiSanPham);
        return "redirect:/admin/danhmuc";

    }
    @GetMapping(value = "/danhmuc/suadanhmuc/{id}")
    public String suadanhmuc(Model model, @PathVariable("id")Integer id){
        Optional<LoaiSanPham>loaiSanPham=loaiSanPhamService.findLoaiSanPhamById(id);
        model.addAttribute("suaDanhMuc",loaiSanPham.get());
         return "admin/danhmuc/suadanhmuc";
    }
    @PostMapping(value = "/danhmuc/suadanhmuc")
    public String editdanhmuc(@ModelAttribute("suaDanhMuc") LoaiSanPham loaiSanPham){
        loaiSanPhamService.SuaLoaiSanPham(loaiSanPham);
        return "redirect:/admin/danhmuc";
    }
    @GetMapping(value = "/danhmuc/xoadanhmuc/{id}")
    public String xoadanhmuc(@PathVariable("id")Integer id){
        loaiSanPhamService.XoaLoaiSanPham(id);
        return "redirect:/admin/danhmuc";
    }

}
