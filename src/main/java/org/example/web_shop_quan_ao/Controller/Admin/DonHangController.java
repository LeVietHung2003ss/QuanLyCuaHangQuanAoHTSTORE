package org.example.web_shop_quan_ao.Controller.Admin;

import org.example.web_shop_quan_ao.Model.*;
import org.example.web_shop_quan_ao.Seviece.DonDatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("userdto")
@RequestMapping("/admin")
public class DonHangController {
    @Autowired
    public DonDatHangService donDatHangService;
    @GetMapping("/donhang")
    public String donhang(Model model){
        List<DonDatHang>list=donDatHangService.DsDonHang();
        model.addAttribute("DsDonHang",list);
        return "admin/donhang";
    }
    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }
    @GetMapping(value = "/donhang/suadh/{id}")
    public String suadonhang(Model model,@PathVariable("id")Integer id){
        Optional<DonDatHang> donDatHangs=donDatHangService.findDonHangById(id);
        model.addAttribute("suaDH",donDatHangs.get());
        return "admin/donhang/suadh";
    }
    @PostMapping (value = "/donhang/suadh")
    public String updateDonHang(@ModelAttribute("suaDH")DonDatHang donDatHang){
       donDatHangService.suaDonHang(donDatHang);
        return "redirect:/admin/donhang";
    }


}
