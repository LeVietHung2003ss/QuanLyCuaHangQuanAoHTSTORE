package org.example.web_shop_quan_ao.Repository;

import org.example.web_shop_quan_ao.Model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham,Integer> {
    @Query(value = "SELECT * FROM SanPham WHERE SanPham.tenSanPham LIKE :tenSanPham%",nativeQuery = true)
    List<SanPham> TimKiemSanPhamTheoTen(@Param("tenSanPham")String tenSanPham);
    @Query("SELECT s FROM SanPham s JOIN s.loaiSanPham l WHERE l.TenLoai = :tenLoai")
    List<SanPham> findSanPhamByLoaiSanPhamId(@Param("tenLoai") String tenLoai);

    @Query(value = "SELECT COUNT(*)  FROM SanPham ",nativeQuery = true)
    long countAllSanPham();

}
