package org.example.web_shop_quan_ao.Controller.Home;

import org.example.web_shop_quan_ao.Model.GioHang;
import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.example.web_shop_quan_ao.Seviece.GioHangService;
import org.example.web_shop_quan_ao.Seviece.SanPhamSeviece;
import org.example.web_shop_quan_ao.Seviece.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("userdto")
@RequestMapping(value = "/home")
public class OderItemController {
    @Autowired
    public SanPhamSeviece sanPhamSeviece;
    @Autowired
    public TaiKhoanService taiKhoanService;
    @Autowired
    public GioHangService gioHangService;
    @GetMapping("/trangchu/donhang")
    public String donhang(Model model, @ModelAttribute("userdto") TaiKhoan taiKhoan){
//        List<GioHang> gioHang=gioHangService.DsSanPhamByTaiKhoanId(taiKhoan.getTaiKhoanId());
//        model.addAttribute("gioHang",gioHang);
//        double tongTien=0;
//        for(GioHang item:gioHang){
//            tongTien+=item.getThanhTien();
//        }
//        model.addAttribute("tongTien",tongTien);
        return "home/donhang";
    }
    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }
}
