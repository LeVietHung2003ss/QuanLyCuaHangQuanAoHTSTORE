package org.example.web_shop_quan_ao.Controller.Home;

import org.example.web_shop_quan_ao.Model.*;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.example.web_shop_quan_ao.Seviece.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("userdto")
@RequestMapping(value = "/home")
public class GioHangController {
    @Autowired
    public TaiKhoanService taiKhoanService;
    @Autowired
    public SanPhamSeviece sanPhamSeviece;
    @Autowired
    public GioHangService gioHangService;
    @Autowired
    public DbConnect dbConnect;

    @ModelAttribute("userdto")
    public TaiKhoan taiKhoan(){
        return new TaiKhoan();
    }
    @PostMapping("/themgiohang")
    public String add(@ModelAttribute("userdto") TaiKhoan taiKhoan,@RequestParam("sanPhamId")Integer sanPhamId
            ,@RequestParam(value = "soLuong",required = false,defaultValue = "1")int soLuong){
        SanPham sanPham=sanPhamSeviece.findChiTietSanPhamById(sanPhamId); // lấy về sản phẩm
        TaiKhoan taiKhoan1=taiKhoanService.findByTaiKhoanId(taiKhoan.getTaiKhoanId());
        GioHang gioHang=gioHangService.checkSanPhamByGioHang(sanPham,taiKhoan1);
        if(gioHang!=null){
            gioHang.setSoLuong(gioHang.getSoLuong() + soLuong);
            gioHang.setThanhTien(sanPham.getGiaSanPham()*gioHang.getSoLuong());
            gioHangService.themGioHang(gioHang);
        }else{
            gioHang=new GioHang();
            gioHang.setSanPhamId(sanPham.getSanPhamId());
            gioHang.setSoLuong(soLuong);
            gioHang.setTaiKhoanId(taiKhoan.getTaiKhoanId());
            gioHang.setThanhTien(sanPham.getGiaSanPham() * soLuong);
            gioHangService.themGioHang(gioHang);
        }
        return "redirect:/home/trangchu";
    }

    @PostMapping("/xoagiohang")
    public String remove(@ModelAttribute("userdto") TaiKhoan taiKhoan,@RequestParam("sanPhamId")Integer sanPhamId){
        SanPham sanPham=sanPhamSeviece.findChiTietSanPhamById(sanPhamId); // lấy về sản phẩm
        TaiKhoan taiKhoan1=taiKhoanService.findByTaiKhoanId(taiKhoan.getTaiKhoanId());
        GioHang gioHang=gioHangService.checkSanPhamByGioHang(sanPham,taiKhoan1);
        if(gioHang!=null){
            gioHangService.xoaGioHang(gioHang);
        }
        return "redirect:/home/trangchu/giohang";
    }
    @PostMapping("/suagiohang")
    public String update(@ModelAttribute("userdto") TaiKhoan taiKhoan,@RequestParam("sanPhamId")Integer sanPhamId
            ,@RequestParam(value = "soLuong",required = false,defaultValue = "1")int soLuong){
        SanPham sanPham=sanPhamSeviece.findChiTietSanPhamById(sanPhamId); // lấy về sản phẩm
        TaiKhoan taiKhoan1=taiKhoanService.findByTaiKhoanId(taiKhoan.getTaiKhoanId());
        GioHang gioHang=gioHangService.checkSanPhamByGioHang(sanPham,taiKhoan1);
        if(gioHang!=null){
            gioHang.setSoLuong(soLuong);
            gioHang.setThanhTien(sanPham.getGiaSanPham()*gioHang.getSoLuong());
            gioHangService.themGioHang(gioHang);
        }
        return "redirect:/home/trangchu/giohang";
    }

}
