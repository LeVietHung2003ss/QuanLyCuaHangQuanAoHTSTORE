package org.example.web_shop_quan_ao.Repository;

import lombok.Data;
import org.example.web_shop_quan_ao.Model.DonDatHang;
import org.example.web_shop_quan_ao.Model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonDatHangRepo extends JpaRepository<DonDatHang,Integer> {
    @Query(value = "SELECT d FROM DonDatHang d RIGHT JOIN d.gioHang g WHERE g.TaiKhoanId=:taiKhoanId")
    List<DonDatHang>finDonHangByTaiKhoanId(@Param("taiKhoanId")int taiKhoanId);

    @Query(value = "SELECT * FROM DonDatHang  WHERE DonDatHang .TaiKhoanId=:taiKhoanId",nativeQuery = true)
    List<DonDatHang>DsDonHangByTaiKhoanId(@Param("taiKhoanId")int taiKhoanId);

//    List<DonDatHang>findByNgayDatHangBetween(Data fromDate,Data toDate);
   @Query("SELECT d FROM DonDatHang d WHERE d.NgayDatHang BETWEEN :fromDate AND :toDate")
   List<DonDatHang> findDonHangByDateRange(@Param("fromDate") String fromDate, @Param("toDate") String toDate);


}
