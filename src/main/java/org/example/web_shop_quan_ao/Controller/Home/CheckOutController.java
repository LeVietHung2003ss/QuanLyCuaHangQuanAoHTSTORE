package org.example.web_shop_quan_ao.Controller.Home;

import org.example.web_shop_quan_ao.Model.*;
import org.example.web_shop_quan_ao.Seviece.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@SessionAttributes("userdto")
@RequestMapping(value = "/home")
public class CheckOutController {
    @Autowired
    public SanPhamSeviece sanPhamSeviece;
    @Autowired
    public TaiKhoanService taiKhoanService;
    @Autowired
    public GioHangService gioHangService;
    @Autowired
    public DonDatHangService donDatHangService;
    @Autowired
    public KhachHangSevice khachHangSevice;
    @GetMapping("/trangchu/checkout")
    public String checkout(Model model, @ModelAttribute("userdto")TaiKhoan taiKhoan){
        List<GioHang>gioHang=gioHangService.DsSanPhamByTaiKhoanId(taiKhoan.getTaiKhoanId());
        double tongTien=0;
        for(GioHang item:gioHang){

            tongTien+=item.getThanhTien();
        }
        model.addAttribute("gioHang",gioHang);
        model.addAttribute("donhang",new DonDatHang());
        model.addAttribute("tongTien",tongTien);
        return "home/checkout";
    }
    @PostMapping ( value = "/trangchu/checkout")
    public String addcheckout(@ModelAttribute("donhang") DonDatHang donDatHang,@ModelAttribute("userdto") TaiKhoan taiKhoan){
        KhachHang khachHang=donDatHang.getKhachHang();
        khachHangSevice.ThemKhachHang(khachHang);
        List<GioHang>gioHang=gioHangService.DsSanPhamByTaiKhoanId(taiKhoan.getTaiKhoanId());
        double tongTien=0;
        for(GioHang item:gioHang) {
            tongTien += item.getThanhTien();
            DonDatHang donDatHang1 = new DonDatHang();
            donDatHang1.setGioHangId(item.getGioHangId());
            donDatHang1.setKhachHangId(khachHang.getKhachHangId());
            donDatHang1.setTaiKhoanId(taiKhoan.getTaiKhoanId());
            donDatHang1.setNgayDatHang(donDatHang.getNgayDatHang());
            donDatHang1.setTongGiaTriDonHang(tongTien);
            donDatHangService.themDonHang(donDatHang1);
        }
        gioHangService.xoaGioHangByTaiKhoanId(taiKhoan().getTaiKhoanId());
        return "redirect:/home/trangchu";
    }

    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }

}
