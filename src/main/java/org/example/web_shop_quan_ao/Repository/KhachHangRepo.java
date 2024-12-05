package org.example.web_shop_quan_ao.Repository;

import org.example.web_shop_quan_ao.Model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
    @Query(value = "SELECT *FROM KhachHang WHERE KhachHang .hoTen LIKE :tenKhachHang%",nativeQuery = true)
    List<KhachHang>TimKiemKhachHang(@Param("tenKhachHang")String tenKhachHang);
    @Query(value = "SELECT COUNT(*)  FROM KhachHang ",nativeQuery = true)
    long countAllKhachHang();
}
