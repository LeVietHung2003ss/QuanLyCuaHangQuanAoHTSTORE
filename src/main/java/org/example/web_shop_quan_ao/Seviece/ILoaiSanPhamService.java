package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.LoaiSanPham;
import org.example.web_shop_quan_ao.Model.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ILoaiSanPhamService {
    public List<LoaiSanPham> DsLoaiSanPham();
    Optional<LoaiSanPham> findLoaiSanPhamById(int id);
    public LoaiSanPham ThemLoaiSanPham(LoaiSanPham loaiSanPham);
    public LoaiSanPham SuaLoaiSanPham(LoaiSanPham loaiSanPhamSua);
    public LoaiSanPham XoaLoaiSanPham(int idXoa);
    public List<LoaiSanPham> TimKiemDanhMuc(String tenLoai);

}
