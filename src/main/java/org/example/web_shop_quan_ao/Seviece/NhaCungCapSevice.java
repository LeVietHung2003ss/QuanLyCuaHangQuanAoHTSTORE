package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.NhaCungCap;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapSevice implements INhaCungCapSeviece{
    @Autowired
    public DbConnect dbConnect;
    @Override
    public List<NhaCungCap> DsNhaCungCap() {
        return dbConnect.nhaCungCapRepo.findAll();
    }

    @Override
    public Optional<NhaCungCap> findNhaCungCapById(int id) {
        return dbConnect.nhaCungCapRepo.findById(id);
    }

    @Override
    public NhaCungCap ThemNhaCungCap(NhaCungCap nhaCungCap) {
        return dbConnect.nhaCungCapRepo.save(nhaCungCap);
    }

    @Override
    public NhaCungCap SuaNhaCungCap(NhaCungCap nhaCungCapSua) {
        Optional<NhaCungCap>nhaCungCap=dbConnect.nhaCungCapRepo.findById(nhaCungCapSua.getNhaCungCapId());
        if(nhaCungCap.isEmpty()){
            return null;
        }
        NhaCungCap nhaCungCap1=nhaCungCap.get();
        nhaCungCap1.setTenNhaCungCap(nhaCungCapSua.getTenNhaCungCap());
        nhaCungCap1.setDiaChi(nhaCungCapSua.getDiaChi());
        nhaCungCap1.setSDT(nhaCungCapSua.getSDT());
        nhaCungCap1.setEmail(nhaCungCapSua.getEmail());
        dbConnect.nhaCungCapRepo.save(nhaCungCap1);
        return nhaCungCap1;
    }

    @Override
    public NhaCungCap XoaNhaCungCap(int idNhaCungCap) {
        Optional<NhaCungCap>nhaCungCap=dbConnect.nhaCungCapRepo.findById(idNhaCungCap);
        if(nhaCungCap.isEmpty()){
            return null;
        }
        dbConnect.nhaCungCapRepo.delete(nhaCungCap.get());
        return nhaCungCap.get();
    }

    @Override
    public List<NhaCungCap> TimKiemNhaCungCap(String tenNhaCungCap) {
        return dbConnect.nhaCungCapRepo.TimKiemNhaCungCap(tenNhaCungCap);
    }
}
