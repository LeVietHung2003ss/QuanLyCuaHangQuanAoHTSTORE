package org.example.web_shop_quan_ao.Repository;

import org.example.web_shop_quan_ao.Model.GioHang;
import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Repository
public interface GioHangRepo extends JpaRepository<GioHang,Integer> {
    @Query(value = "SELECT COUNT(*) FROM GioHang WHERE GioHang.TaiKhoanId =:taiKhoanId",nativeQuery = true)
    long countGioHangbyUser( @Param("taiKhoanId") int taiKhoanId);
    @Query(value = "SELECT * FROM GioHang  WHERE GioHang .TaiKhoanId =:taiKhoanId",nativeQuery = true)
    List<GioHang> DsGioHangByTaiKhoanId(@Param("taiKhoanId")int taiKhoanId);
    @Query(value = "SELECT * FROM GioHang  WHERE GioHang .SanPhamId =:sanPhamId",nativeQuery = true)
   Optional< GioHang> findGioHangBySanPhamId(@Param("sanPhamId")int sanPhamId);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM GioHang g WHERE g.TaiKhoanId=:taiKhoanId")
    void deleteByTaiKhoanId(int taiKhoanId);



}
