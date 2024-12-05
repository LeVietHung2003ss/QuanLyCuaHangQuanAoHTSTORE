package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.GioHang;
import org.example.web_shop_quan_ao.Model.SanPham;
import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IGioHangService {
    public List<GioHang> DsGioHangByUser(SanPham sanPham,TaiKhoan taiKhoan,int soLuong);
    public List<GioHang> DsSanPhamByTaiKhoanId(int taiKhoanId);

    long DemSoLuongSanPhamByGioHang(int taiKhoanId);
    GioHang themGioHang(GioHang gioHang );
    GioHang suaGioHang(GioHang gioHangSua);
    GioHang xoaGioHang(GioHang xoaGioHang);
    void xoaGioHangByTaiKhoanId(int taiKhoanId);
}
