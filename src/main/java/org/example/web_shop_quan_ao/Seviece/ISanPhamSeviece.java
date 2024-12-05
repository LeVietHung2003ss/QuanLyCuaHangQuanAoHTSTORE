package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ISanPhamSeviece {
    public List<SanPham> DsSanPham();
    Optional<SanPham>findSanPhamById(int id);
    List<SanPham>findSanPhamByLoaiSanPhamId(String tenLoai);
    SanPham findChiTietSanPhamById(int id);
    public SanPham ThemSanPham(SanPham sanPham);
    public SanPham SuaSanPham(SanPham sanPhamSua);
    public SanPham XoaSanPham(int idXoa);
    public List<SanPham> TimKiemSanPhamByTen(String tenSanPham);
    Page<SanPham>DsSanPham(Integer pageNo);
    Page<SanPham> TimKiemSanPhamByTen(String tenSanPham,Integer pageNo);
    long DemSoLuongSanPham();

}
