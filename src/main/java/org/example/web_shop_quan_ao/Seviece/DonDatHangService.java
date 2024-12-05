package org.example.web_shop_quan_ao.Seviece;

import lombok.Data;
import org.example.web_shop_quan_ao.Model.DonDatHang;
import org.example.web_shop_quan_ao.Model.GioHang;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonDatHangService implements IDonDatHangService{
    @Autowired
    public DbConnect dbConnect;
    @Override
    public List<DonDatHang> findDonHangByTaiKhoanId(int taiKhoanId) {
        return dbConnect.donDatHangRepo.finDonHangByTaiKhoanId(taiKhoanId);
    }

    @Override
    public List<DonDatHang> findDonHangByDateRange(String fromDate, String toDate) {
        return dbConnect.donDatHangRepo.findDonHangByDateRange(fromDate,toDate);
    }

    public List<DonDatHang> DsDonHangByTaiKhoanId(int taiKhoanId){
        return dbConnect.donDatHangRepo.DsDonHangByTaiKhoanId(taiKhoanId);
    }
    public List<DonDatHang>DsDonHang(){
        return dbConnect.donDatHangRepo.findAll();
    }
    public DonDatHang getTongTien(){
        double tongTien=0;
        for(DonDatHang item:DsDonHang()){
            tongTien+=item.getGioHang().getThanhTien();
        }
        return getTongTien();
    }
    public DonDatHang themDonHang(DonDatHang donDatHang){
        return dbConnect.donDatHangRepo.save(donDatHang);
    }
    public DonDatHang xoaDonHang(int xoaDonHang){
        Optional<DonDatHang>donDatHang=dbConnect.donDatHangRepo.findById(xoaDonHang);
        if(donDatHang.isEmpty()){
            return null;
        }
        dbConnect.donDatHangRepo.delete(donDatHang.get());
        return donDatHang.get();
    }
    public DonDatHang suaDonHang(DonDatHang suaDonHang){
        Optional<DonDatHang>donDatHang=dbConnect.donDatHangRepo.findById(suaDonHang.getDonDatHangId());
        if(donDatHang.isEmpty()){
            return null;
        }
        DonDatHang donDatHang1=donDatHang.get();
        donDatHang1.setTrangThai(suaDonHang.isTrangThai());
        dbConnect.donDatHangRepo.save(donDatHang1);
        return donDatHang1;
    }
    public Optional<DonDatHang>findDonHangById(int id){
        return dbConnect.donDatHangRepo.findById(id);
    }

}
