package org.example.web_shop_quan_ao.Controller.Admin;

import org.example.web_shop_quan_ao.Model.NhaCungCap;
import org.example.web_shop_quan_ao.Seviece.NhaCungCapSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class NhaCungCapController {
    @Autowired
    public NhaCungCapSevice nhaCungCapSevice;
    @GetMapping(value = "/nhacungcap")
    public String nhaCungCap(Model model,@RequestParam(value = "search",required = false)String search){
        List<NhaCungCap> list;
        if(search!=null && !search.isEmpty()){
            list=nhaCungCapSevice.TimKiemNhaCungCap(search);
        }else{
            list=nhaCungCapSevice.DsNhaCungCap();
        }
        model.addAttribute("search",search);
        model.addAttribute("DsNhaCungCap",list);
        return "admin/nhacungcap";
    }
    @GetMapping(value = "/nhacungcap/themnhacungcap")
    public String themNhaCungCap(Model model){
        NhaCungCap nhaCungCap=new NhaCungCap();
        model.addAttribute("themNhaCungCap",nhaCungCap);
        return "admin/nhacungcap/themnhacungcap";
    }
    @PostMapping(value ="/nhacungcap/themnhacungcap")
    public String add(@ModelAttribute("themNhaCungCap")NhaCungCap nhaCungCap){
        if (nhaCungCap.getTenNhaCungCap() == null || nhaCungCap.getTenNhaCungCap().isEmpty()) {
            return "redirect:/admin/nhacungcap/themnhacungcap?tenNhaCungCap";
        }
        nhaCungCapSevice.ThemNhaCungCap(nhaCungCap);
        return "redirect:/admin/nhacungcap";
    }
    @GetMapping(value = "/nhacungcap/suanhacungcap/{id}")
    public String suaNhaCungCap(Model model,@PathVariable("id")Integer id){
        Optional<NhaCungCap>nhaCungCap=nhaCungCapSevice.findNhaCungCapById(id);
        model.addAttribute("suaNhaCungCap",nhaCungCap.get());
        return "admin/nhacungcap/suanhacungcap";
    }
    @PostMapping(value ="/nhacungcap/suanhacungcap")
    public String edit(@ModelAttribute("suaNhaCungCap") NhaCungCap nhaCungCap){
        nhaCungCapSevice.SuaNhaCungCap(nhaCungCap);
        return "redirect:/admin/nhacungcap";
    }
    @GetMapping(value = "/nhacungcap/xoanhacungcap/{id}")
    public String xoaNhaCungCap(@PathVariable("id")Integer id){
        nhaCungCapSevice.XoaNhaCungCap(id);
        return "redirect:/admin/nhacungcap";
    }
}
