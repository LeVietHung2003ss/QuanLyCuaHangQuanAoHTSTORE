//package org.example.web_shop_quan_ao.Seviece;
//
//import org.example.web_shop_quan_ao.Model.ChiTietSanPham;
//import org.example.web_shop_quan_ao.Model.SanPham;
//import org.example.web_shop_quan_ao.Model.TaiKhoan;
//import org.example.web_shop_quan_ao.Repository.DbConnect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ChiTietSanPhamService implements IChiTietSanPhamService {
//    @Autowired
//    public DbConnect dbConnect;
//    @Override
//    public List<ChiTietSanPham> DsCTSP() {
//        return dbConnect.chiTietSanPhamRepo.findAll();
//    }
//
//    @Override
//    public ChiTietSanPham kiemtraSanPham(SanPham sanPham, TaiKhoan taiKhoan) {
//        for(ChiTietSanPham item:DsCTSP()){
//            if(item.getSanPhamId()==sanPham.getSanPhamId() && item.getTaiKhoanId()==taiKhoan.getTaiKhoanId())
//                return item;
//        }
//        return null;
//    }
//
//    @Override
//    public ChiTietSanPham themChiTietSanPham(SanPham sanPham, TaiKhoan taiKhoan, int soLuong) {
//        ChiTietSanPham item=kiemtraSanPham(sanPham,taiKhoan);
//        if(item!=null){
//            item.setSoLuong(item.getSoLuong()+soLuong);
//        }else{
//            item=new ChiTietSanPham(sanPham,taiKhoan);
//            item.setSoLuong(soLuong);
//            return dbConnect.chiTietSanPhamRepo.save(item);
//        }
//        return null;
//    }
//
//    @Override
//    public ChiTietSanPham suaChiTietSanPhamById(SanPham sanPham, TaiKhoan taiKhoan, int soLuong) {
//        ChiTietSanPham item=kiemtraSanPham(sanPham,taiKhoan);
//        if(item!=null){
//            item.setSoLuong(soLuong);
//            dbConnect.chiTietSanPhamRepo.save(item);
//            return item;
//        }
//        return null;
//    }
//
//    @Override
//    public long DemSoLuongSanPhamByGioHang(int id) {
//        return dbConnect.chiTietSanPhamRepo.soLuongHienThiByGioHang(id);
//    }
//
//    @Override
//    public ChiTietSanPham xoaSanPhamById(int id) {
//        return null;
//    }
//}
