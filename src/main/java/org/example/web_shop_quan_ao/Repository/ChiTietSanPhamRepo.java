//package org.example.web_shop_quan_ao.Repository;
//
//import org.example.web_shop_quan_ao.Model.ChiTietSanPham;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham,Integer> {
//////    @Query(value = "SELECT  * FROM ChiTietSanPham RIGHT JOIN SanPham ON ChiTietSanPham .SanPhamId=SanPham .SanPhamId WHERE SanPham .SanPhamId =:sanPhamId",nativeQuery = true)
//////    ChiTietSanPham findSanPhamById( @Param("sanPhamId") int sanPhamId);
////    @Query(value = "SELECT c.* FROM ChiTietSanPham c RIGHT JOIN SanPham s ON c.SanPhamId = s.SanPhamId WHERE s.SanPhamId = :sanPhamId", nativeQuery = true)
////    ChiTietSanPham findSanPhamById(@Param("sanPhamId") int sanPhamId);
//
////    @Query(value = "SELECT COUNT(*) FROM ChiTietSanPham WHERE ChiTietSanPham .ChiTietSanPhamId =:chiTietSanPhamId",nativeQuery = true)
////    long soLuongHienThiByGioHang(@Param("chiTietSanPhamId") int chiTietSanPhamId);
//    @Query(value = "SELECT COUNT (*) FROM ChiTietSanPham  WHERE ChiTietSanPham .TaiKhoanId =:taiKhoanId",nativeQuery = true)
//    long soLuongHienThiByGioHang(@Param("taiKhoanId") int taiKhoanId);
//
//}
