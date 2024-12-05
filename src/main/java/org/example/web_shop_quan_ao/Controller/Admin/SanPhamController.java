package org.example.web_shop_quan_ao.Controller.Admin;

import org.example.web_shop_quan_ao.Model.LoaiSanPham;
import org.example.web_shop_quan_ao.Model.NhaCungCap;
import org.example.web_shop_quan_ao.Model.SanPham;
import org.example.web_shop_quan_ao.Seviece.LoaiSanPhamService;
import org.example.web_shop_quan_ao.Seviece.NhaCungCapSevice;
import org.example.web_shop_quan_ao.Seviece.SanPhamSeviece;
import org.example.web_shop_quan_ao.Seviece.SystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class SanPhamController {
    @Autowired
    public SanPhamSeviece sanPhamSeviece;
    @Autowired
    public LoaiSanPhamService loaiSanPhamService;
    @Autowired
    public SystemStorageService systemStorageService;
    @Autowired
    public NhaCungCapSevice nhaCungCapSevice;
    @GetMapping(value = "/sanpham")
    public String search(@RequestParam(value = "search",required = false)String search,Model model,@RequestParam(name = "pageNo",defaultValue = "1")Integer pageNo ){
        Page<SanPham>list=sanPhamSeviece.DsSanPham(pageNo);
        if(search!=null && !search.isEmpty()){
            list=sanPhamSeviece.TimKiemSanPhamByTen(search,pageNo);
        }
        model.addAttribute("totalPage",list.getTotalPages());
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("DsSanPham",list);
        model.addAttribute("search",search);
        List<LoaiSanPham>loaiSanPhams=loaiSanPhamService.DsLoaiSanPham();
        model.addAttribute("DsDanhMuc",loaiSanPhams);

        List<NhaCungCap>nhaCungCaps=nhaCungCapSevice.DsNhaCungCap();
        model.addAttribute("DsNhaCungCap",nhaCungCaps);
        return "admin/sanpham";
    }
    @GetMapping(value = "/sanpham/themsp")
    public String themsanpham(Model model){
        SanPham sanPham=new SanPham();
        model.addAttribute("themSP",sanPham);

        List<LoaiSanPham>list=loaiSanPhamService.DsLoaiSanPham();
        model.addAttribute("DsDanhMuc",list);

        List<NhaCungCap>nhaCungCaps=nhaCungCapSevice.DsNhaCungCap();
        model.addAttribute("DsNhaCungCap",nhaCungCaps);
        return "admin/sanpham/themsp";
    }

    @PostMapping ( value = "/sanpham/themsp")
    public String add(@ModelAttribute("themSP") SanPham sanPham,@RequestParam("fileImage") MultipartFile file){

        // upload file
        systemStorageService.store(file);
        String fileName=file.getOriginalFilename();
        sanPham.setHinhAnh(fileName);
        sanPhamSeviece.ThemSanPham(sanPham);
        return "redirect:/admin/sanpham";
    }
    @GetMapping(value = "/sanpham/suasp/{id}")
    public String suasanpham(Model model,@PathVariable("id")Integer id){
        Optional<SanPham> suaSP=sanPhamSeviece.findSanPhamById(id);
        model.addAttribute("suaSP",suaSP.get());
        List<LoaiSanPham>list=loaiSanPhamService.DsLoaiSanPham();
        model.addAttribute("DsDanhMuc",list);
        List<NhaCungCap>nhaCungCaps=nhaCungCapSevice.DsNhaCungCap();
        model.addAttribute("DsNhaCungCap",nhaCungCaps);
        return "admin/sanpham/suasp";
    }
    @PostMapping (value = "/sanpham/suasp")
    public String edit(@ModelAttribute("suaSP") SanPham sanPham,@RequestParam("fileImage") MultipartFile file){
        if(!file.isEmpty()) {
            systemStorageService.store(file);
            String fileName = file.getOriginalFilename();
            sanPham.setHinhAnh(fileName);
        }else{
            SanPham existingSanPham = sanPhamSeviece.findSanPhamById(sanPham.getSanPhamId()).get();
            sanPham.setHinhAnh(existingSanPham.getHinhAnh());
        }
        sanPhamSeviece.SuaSanPham(sanPham);
        return "redirect:/admin/sanpham";
    }
    @GetMapping(value = "/sanpham/xoasp/{id}")
    public String xoasanpham(@PathVariable("id") Integer id){
        sanPhamSeviece.XoaSanPham(id);
        return "redirect:/admin/sanpham";
    }

}
