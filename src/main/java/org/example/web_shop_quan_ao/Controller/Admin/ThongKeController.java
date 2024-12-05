package org.example.web_shop_quan_ao.Controller.Admin;

import lombok.Data;
import org.example.web_shop_quan_ao.Model.DonDatHang;
import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.example.web_shop_quan_ao.Seviece.DonDatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("userdto")
@RequestMapping("/admin")
public class ThongKeController {
    @Autowired
    public DonDatHangService donDatHangService;
    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }
//    @GetMapping("/thongke")
//    public String thongke(Model model){
//        List<DonDatHang> list=donDatHangService.DsDonHang();
//        model.addAttribute("DsDonHang",list);
//        return "admin/thongke";
//    }
    @GetMapping("/thongke")
    public String thongke(Model model,@RequestParam(value = "fromDate",required = false)String fromDate,@RequestParam(value = "toDate",required = false)String toDate){
//        List<DonDatHang> list=donDatHangService.DsDonHang();
//
//        model.addAttribute("DsDonHang",list);
        List<DonDatHang>list;
        if(fromDate!=null && toDate!=null) {
            list = donDatHangService.findDonHangByDateRange(fromDate, toDate);
        }else {
            list=donDatHangService.DsDonHang();
        }
        model.addAttribute("fromDate",fromDate);
        model.addAttribute("toDate",toDate);
        model.addAttribute("DsDonHang",list);
        return "admin/thongke";
    }

//    @PostMapping("/thongke/filter")
//    public String thongkeFilter(@RequestParam("fromDate")String fromDate,
//                                @RequestParam("toDate") String toDate,
//                                Model model) {
//        List<DonDatHang> list = donDatHangService.findDonHangByDateRange(fromDate, toDate);
//        model.addAttribute("DsDonHang", list);
//        return "redirect:/admin/thongke";
//    }
}
