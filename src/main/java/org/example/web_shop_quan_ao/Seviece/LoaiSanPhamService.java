package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.LoaiSanPham;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiSanPhamService implements ILoaiSanPhamService {
    @Autowired
    public DbConnect dbConnect;
    @Override
    public List<LoaiSanPham> DsLoaiSanPham() {
        return  dbConnect.loaiSanPhamRepo.findAll();
    }

    @Override
    public Optional<LoaiSanPham> findLoaiSanPhamById(int id) {
        return dbConnect.loaiSanPhamRepo.findById(id);
    }

    @Override
    public LoaiSanPham ThemLoaiSanPham(LoaiSanPham loaiSanPham) {
        return dbConnect.loaiSanPhamRepo.save(loaiSanPham);
    }

    @Override
    public LoaiSanPham SuaLoaiSanPham(LoaiSanPham loaiSanPhamSua) {
        Optional<LoaiSanPham>loaiSanPham=dbConnect.loaiSanPhamRepo.findById(loaiSanPhamSua.getLoaiSanPhamId());
        if(loaiSanPham.isEmpty()){
            return null;    
        }
        LoaiSanPham loaiSanPham1=loaiSanPham.get();
        loaiSanPham1.setTenLoai(loaiSanPhamSua.getTenLoai());
        dbConnect.loaiSanPhamRepo.save(loaiSanPham1);
        return loaiSanPham1;
    }

    @Override
    public LoaiSanPham XoaLoaiSanPham(int idXoa) {
        Optional<LoaiSanPham>loaiSanPham=dbConnect.loaiSanPhamRepo.findById(idXoa);
        if(loaiSanPham.isEmpty()){
            return null;
        }
        dbConnect.loaiSanPhamRepo.delete(loaiSanPham.get());
        return loaiSanPham.get();
    }

    @Override
    public List<LoaiSanPham> TimKiemDanhMuc(String tenLoai) {
        return dbConnect.loaiSanPhamRepo.TimKiemDanhMuc(tenLoai);
    }
}
