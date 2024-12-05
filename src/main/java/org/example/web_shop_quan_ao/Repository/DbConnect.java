package org.example.web_shop_quan_ao.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbConnect {
    @Autowired
    public SanPhamRepo sanPhamRepo;
    @Autowired
    public NhaCungCapRepo nhaCungCapRepo;
//    @Autowired
//    public MauSacSanPhamRepo mauSacSanPhamRepo;
    @Autowired
    public LoaiSanPhamRepo loaiSanPhamRepo;
//    @Autowired
//    public KichThuocSanPhamRepo kichThuocSanPhamRepo;
    @Autowired
    public KhachHangRepo khachHangRepo;
    @Autowired
    public GioHangRepo gioHangRepo;
    @Autowired
    public DonDatHangRepo donDatHangRepo;
    @Autowired
    public TaiKhoanRepo taiKhoanRepo;
//    @Autowired
//    public ChiTietSanPhamRepo chiTietSanPhamRepo;
}
