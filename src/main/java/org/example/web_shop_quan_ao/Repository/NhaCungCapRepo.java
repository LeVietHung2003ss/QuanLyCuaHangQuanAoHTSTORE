package org.example.web_shop_quan_ao.Repository;

import org.example.web_shop_quan_ao.Model.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepo extends JpaRepository<NhaCungCap,Integer> {
    @Query(value = "SELECT * FROM NhaCungCap WHERE NhaCungCap .tenNhaCungCap LIKE :tenNhaCungCap%",nativeQuery = true)
    public List<NhaCungCap> TimKiemNhaCungCap(@Param("tenNhaCungCap") String tenNhaCungCap);
}
