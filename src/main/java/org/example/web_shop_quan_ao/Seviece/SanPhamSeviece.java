package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.SanPham;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamSeviece implements ISanPhamSeviece{
    @Autowired
    public DbConnect dbConnect;

    @Override
    public Optional<SanPham> findSanPhamById(int id) {
        return dbConnect.sanPhamRepo.findById(id);
    }
    @Override
    public SanPham findChiTietSanPhamById(int id) {
        return dbConnect.sanPhamRepo.findById(id).get();
    }

    @Override
    public List<SanPham> DsSanPham() {
        return dbConnect.sanPhamRepo.findAll();
    }

    @Override
    public SanPham ThemSanPham(SanPham sanPham) {
        return dbConnect.sanPhamRepo.save(sanPham);
    }

    @Override
    public SanPham SuaSanPham(SanPham sanPhamSua) {
        Optional<SanPham>sanPham=dbConnect.sanPhamRepo.findById(sanPhamSua.getSanPhamId());
        if (sanPham.isEmpty()){
            return null;
        }
        SanPham sanPham1=sanPham.get();
        sanPham1.setTenSanPham(sanPhamSua.getTenSanPham());
        sanPham1.setLoaiSanPhamId(sanPhamSua.getLoaiSanPhamId());
        sanPham1.setNhaCungCapId(sanPhamSua.getNhaCungCapId());
        sanPham1.setGiaSanPham(sanPhamSua.getGiaSanPham());
        sanPham1.setMoTaSanPham(sanPhamSua.getMoTaSanPham());
        sanPham1.setHinhAnh(sanPhamSua.getHinhAnh());
        sanPham1.setTongSoLuongTrongKho(sanPhamSua.getTongSoLuongTrongKho());
        dbConnect.sanPhamRepo.save(sanPham1);
        return sanPham1;
    }

    @Override
    public SanPham XoaSanPham(int idXoa) {
        Optional<SanPham>sanPham=dbConnect.sanPhamRepo.findById(idXoa);
        if(sanPham.isEmpty()){
            return null;
        }
        dbConnect.sanPhamRepo.delete(sanPham.get());
        return sanPham.get();
    }

    @Override
    public List<SanPham> TimKiemSanPhamByTen(String tenSanPham) {
        return dbConnect.sanPhamRepo.TimKiemSanPhamTheoTen(tenSanPham);
    }

    @Override
    public List<SanPham> findSanPhamByLoaiSanPhamId(String tenLoai) {
        return dbConnect.sanPhamRepo.findSanPhamByLoaiSanPhamId(tenLoai);
    }
    @Override
    public long DemSoLuongSanPham() {
        return dbConnect.sanPhamRepo.countAllSanPham();
    }

    @Override
    public Page<SanPham> TimKiemSanPhamByTen(String tenSanPham, Integer pageNo) {
        List list=this.TimKiemSanPhamByTen(tenSanPham);
        Pageable pageable=PageRequest.of(pageNo-1,4);
        Integer start= (int) pageable.getOffset();
        Integer end= (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size():pageable.getOffset() + pageable.getPageSize());
        list =list.subList(start,end);
        return new PageImpl<SanPham>(list,pageable,this.TimKiemSanPhamByTen(tenSanPham).size());
    }

    @Override
    public Page<SanPham> DsSanPham(Integer pageNo) {
        Pageable pageable= PageRequest.of(pageNo-1,4);
        return this.dbConnect.sanPhamRepo.findAll(pageable);
    }
}
