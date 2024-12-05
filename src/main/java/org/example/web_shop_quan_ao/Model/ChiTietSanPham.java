//package org.example.web_shop_quan_ao.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@Table(name="chitietsanpham")
//public class ChiTietSanPham {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="chitietsanphamid")
//    private int ChiTietSanPhamId;
//    @Column(name="sanphamid")
//    private int SanPhamId;
//    @Column(name="soluong")
//    private int SoLuong;
//    @Column(name="thanhtien")
//    private double ThanhTien;
//    @Column(name = "taikhoanid")
//    private int TaiKhoanId;
//    @JoinColumn(name = "sanphamid",insertable = false,updatable = false)
//    @ManyToOne
//    private SanPham sanPham;
//    @JoinColumn(name = "taikhoanid",insertable = false,updatable = false)
//    @OneToOne
//    private TaiKhoan taiKhoan;
//    public ChiTietSanPham(){
//
//    }
//    public ChiTietSanPham(SanPham sanPham,TaiKhoan taiKhoan){
//        this.sanPham=sanPham;
//        this.SoLuong=1;
//        this.ThanhTien=sanPham.getGiaSanPham() * SoLuong;
//        this.taiKhoan=taiKhoan;
//    }
//
////    public ChiTietSanPham( SanPham sanPham) {
////        SoLuong = 1;
////        ThanhTien = sanPham.getGiaSanPham();
////        this.sanPham = sanPham;
////    }
////
////    public ChiTietSanPham() {
////
////    }
////
////    public int getChiTietSanPhamId() {
////        return ChiTietSanPhamId;
////    }
////
////    public void setChiTietSanPhamId(int chiTietSanPhamId) {
////        ChiTietSanPhamId = chiTietSanPhamId;
////    }
////
////    public int getSanPhamId() {
////        return SanPhamId;
////    }
////
////    public void setSanPhamId(int sanPhamId) {
////        SanPhamId = sanPhamId;
////    }
////
////    public int getSoLuong() {
////        return SoLuong;
////    }
////
////    public void setSoLuong(int soLuong) {
////        SoLuong = soLuong;
////    }
////
////    public double getThanhTien() {
////        ThanhTien=sanPham.getGiaSanPham() * SoLuong;
////        return ThanhTien;
////    }
////
////    public void setThanhTien(double thanhTien) {
////        ThanhTien = thanhTien;
////    }
////
////    public SanPham getSanPham() {
////        return sanPham;
////    }
////
////    public void setSanPham(SanPham sanPham) {
////        this.sanPham = sanPham;
////    }
//}
//
