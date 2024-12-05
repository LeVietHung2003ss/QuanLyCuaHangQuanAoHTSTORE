package org.example.web_shop_quan_ao.Seviece;

import jakarta.servlet.http.HttpSession;
import org.example.web_shop_quan_ao.Model.GioHang;
import org.example.web_shop_quan_ao.Model.SanPham;
import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
public class GioHangService implements IGioHangService{
    @Autowired
    public DbConnect dbConnect;
    public List<GioHang> items(){
        return  dbConnect.gioHangRepo.findAll();
    }
    @Override
    public List<GioHang> DsGioHangByUser(SanPham sanPham,TaiKhoan taiKhoan,int soLuong) {
        return dbConnect.gioHangRepo.findAll();
    }

    @Override
    public List<GioHang> DsSanPhamByTaiKhoanId(int taiKhoanId) {
        return dbConnect.gioHangRepo.DsGioHangByTaiKhoanId(taiKhoanId);
    }
    @Override
    public long DemSoLuongSanPhamByGioHang(int taiKhoanId) {
        return dbConnect.gioHangRepo.countGioHangbyUser(taiKhoanId);
    }
    public GioHang checkSanPhamByGioHang(SanPham sanPham, TaiKhoan taiKhoan){
        for(GioHang item:items()){
            if(item.getSanPham().getSanPhamId()==sanPham.getSanPhamId() && item.getTaiKhoan().getTaiKhoanId()==taiKhoan.getTaiKhoanId()){
                return item;
            }
        }
        return null;
    }
    @Override
    public GioHang themGioHang(GioHang gioHang) {
        return dbConnect.gioHangRepo.save(gioHang);
    }

    @Override
    public GioHang suaGioHang(GioHang gioHangSua) {
        Optional<GioHang> gioHang=dbConnect.gioHangRepo.findById(gioHangSua.getGioHangId());
        if(gioHang.isEmpty()){
            return null;
        }
        GioHang gioHang1=gioHang.get();
        gioHang1.setSoLuong(gioHangSua.getSoLuong());
        dbConnect.gioHangRepo.save(gioHang1);
        return gioHang1;
    }

    @Override
    public GioHang xoaGioHang(GioHang xoaGioHang) {
        Optional<GioHang> gioHang=dbConnect.gioHangRepo.findById(xoaGioHang.getGioHangId());
        if(gioHang.isEmpty()){
            return null;
        }
        dbConnect.gioHangRepo.delete(gioHang.get());
        return gioHang.get();
    }

    @Override
    public void xoaGioHangByTaiKhoanId(int taiKhoanId) {
         dbConnect.gioHangRepo.deleteByTaiKhoanId(taiKhoanId);
    }
}
