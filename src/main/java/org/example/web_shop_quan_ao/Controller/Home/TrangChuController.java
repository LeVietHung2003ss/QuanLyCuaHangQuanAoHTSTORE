package org.example.web_shop_quan_ao.Controller.Home;
import jakarta.servlet.http.HttpSession;
import org.example.web_shop_quan_ao.Model.*;
import org.example.web_shop_quan_ao.Seviece.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("userdto")
@RequestMapping(value = "/home")
public class TrangChuController {
    @Autowired
    public SanPhamSeviece sanPhamSeviece;
    @Autowired
    public TaiKhoanService taiKhoanService;
    @Autowired
    public GioHangService gioHangService;
    @GetMapping
    public String home(Model model){
        List<SanPham>list=sanPhamSeviece.DsSanPham();
        model.addAttribute("DsSanPham",list);
        return "home/index";
    }
    @GetMapping("/quan")
    public String homeQuan(Model model) {
        List<SanPham> list = sanPhamSeviece.findSanPhamByLoaiSanPhamId("QUẦN");
        model.addAttribute("DsSanPham", list);
        return "home/index";
    }

    @GetMapping("/ao")
    public String homeAo(Model model) {
        List<SanPham> list = sanPhamSeviece.findSanPhamByLoaiSanPhamId("ÁO");
        model.addAttribute("DsSanPham", list);
        return "home/index";
    }
    @GetMapping(value = "/trangchu")
    public String trangchu(Model model){
        List<SanPham>list=sanPhamSeviece.DsSanPham();
        model.addAttribute("DsSanPham",list);
        return "home/TrangChu";
    }

    @GetMapping("/trangchu/quan")
    public String trangchuQuan(Model model) {
        List<SanPham> list = sanPhamSeviece.findSanPhamByLoaiSanPhamId("QUẦN");
        model.addAttribute("DsSanPham", list);
        return "home/TrangChu";
    }

    @GetMapping("/trangchu/ao")
    public String trangchuAo(Model model) {
        List<SanPham> list = sanPhamSeviece.findSanPhamByLoaiSanPhamId("ÁO");
        model.addAttribute("DsSanPham", list);
        return "home/TrangChu";
    }
    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }

    @GetMapping("/chitietsanpham/{id}")
    public String chitietsanpham(@PathVariable("id")Integer id,Model model){
        SanPham sanPham=sanPhamSeviece.findChiTietSanPhamById(id);
        model.addAttribute("ctsp",sanPham);
        return "home/chitietsanpham";
    }
    @GetMapping("/trangchu/giohang")
    public String giohang(Model model,@ModelAttribute("userdto")TaiKhoan taiKhoan,@RequestParam(name = "soLuong", required = false,defaultValue = "0") int soLuong){
        List<GioHang> gioHang=gioHangService.DsSanPhamByTaiKhoanId(taiKhoan.getTaiKhoanId());
        model.addAttribute("gioHang",gioHang);
        double tongTien=0;
        for(GioHang item:gioHang){
            tongTien+=item.getThanhTien();
        }
        model.addAttribute("tongTien",tongTien);
        return "home/giohang";
    }


}

