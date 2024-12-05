package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.KhachHang;
import org.example.web_shop_quan_ao.Model.LoaiSanPham;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IKhachHangSevice {
    public List<KhachHang> DsKhachHang();
    Optional<KhachHang> findKhachHangById(int id);
    public KhachHang ThemKhachHang(KhachHang khachHang);
    public KhachHang SuaKhachHang(KhachHang khachHangSua);
    public KhachHang XoaKhachHang(int idXoa);
    public List<KhachHang> TimKiemKhachHang(String tenKhachHang);
    long DemSoLuongKhachHang();
}
