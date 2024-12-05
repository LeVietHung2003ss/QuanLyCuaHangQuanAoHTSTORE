//package org.example.web_shop_quan_ao.Seviece;
//
//import org.example.web_shop_quan_ao.Model.KichThuocSanPham;
//import org.example.web_shop_quan_ao.Model.MauSacSanPham;
//import org.example.web_shop_quan_ao.Repository.DbConnect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class KichThuocSanPhamService {
//    @Autowired
//    public DbConnect dbConnect;
//    public List<KichThuocSanPham>DsKichThuocSanPham(){
//        return dbConnect.kichThuocSanPhamRepo.findAll();
//    }
//    public List<MauSacSanPham>DsMauSacSanPham(){
//        return dbConnect.mauSacSanPhamRepo.findAll();
//    }
//    public KichThuocSanPham findKichThuocById(int id){
//        return  dbConnect.kichThuocSanPhamRepo.findById(id).orElse(null);
//    }
//    public MauSacSanPham findMauSacById(int id){
//        return dbConnect.mauSacSanPhamRepo.findById(id).orElse(null);
//    }
//}
