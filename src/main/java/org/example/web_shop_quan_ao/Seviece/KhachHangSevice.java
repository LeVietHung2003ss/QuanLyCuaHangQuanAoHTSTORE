package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.KhachHang;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangSevice implements IKhachHangSevice{
    @Autowired
    public DbConnect dbConnect;
    @Override
    public List<KhachHang> DsKhachHang() {
        return dbConnect.khachHangRepo.findAll();
    }

    @Override
    public Optional<KhachHang> findKhachHangById(int id) {
        return dbConnect.khachHangRepo.findById(id);
    }

    @Override
    public KhachHang ThemKhachHang(KhachHang khachHang) {
        return dbConnect.khachHangRepo.save(khachHang);
    }

    @Override
    public KhachHang SuaKhachHang(KhachHang khachHangSua) {
        Optional<KhachHang>khachHang=dbConnect.khachHangRepo.findById(khachHangSua.getKhachHangId());
        if(khachHang.isEmpty()){
            return null;
        }
        KhachHang khachHang1=khachHang.get();
        khachHang1.setHoTen(khachHangSua.getHoTen());
        khachHang1.setDiaChi(khachHangSua.getDiaChi());
        khachHang1.setSDT(khachHangSua.getSDT());
        khachHang1.setEmail(khachHangSua.getEmail());
        dbConnect.khachHangRepo.save(khachHang1);
        return khachHang1;
    }

    @Override
    public KhachHang XoaKhachHang(int idXoa) {
        Optional<KhachHang>khachHang=dbConnect.khachHangRepo.findById(idXoa);
        if(khachHang.isEmpty()){
            return null;
        }
        dbConnect.khachHangRepo.delete(khachHang.get());
        return khachHang.get();
    }

    @Override
    public List<KhachHang> TimKiemKhachHang(String tenKhachHang) {
        return dbConnect.khachHangRepo.TimKiemKhachHang(tenKhachHang);
    }

    @Override
    public long DemSoLuongKhachHang() {
        return dbConnect.khachHangRepo.countAllKhachHang();
    }
}
