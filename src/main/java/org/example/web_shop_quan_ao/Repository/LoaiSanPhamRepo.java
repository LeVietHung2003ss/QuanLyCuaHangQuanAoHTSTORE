package org.example.web_shop_quan_ao.Repository;

import org.example.web_shop_quan_ao.Model.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface LoaiSanPhamRepo extends JpaRepository<LoaiSanPham,Integer> {
    @Query(value = "SELECT * FROM LoaiSanPham WHERE LoaiSanPham .tenLoai LIKE :tenLoai%",nativeQuery = true)
    List<LoaiSanPham> TimKiemDanhMuc(@Param("tenLoai") String tenLoai);
}
