//package org.example.web_shop_quan_ao.Model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "chitietdondathang")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class ChiTietDonDatHang {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "chitietdondathangid")
//    private int ChiTietDonDatHangId;
//    @Column(name = "dondathangid")
//    private int DonDatHangId;
//    @Column(name = "sanphamid")
//    private int SanPhamId;
//    @Column(name = "soluongmua")
//    private int SoLuongMua;
//    @Column(name = "giaban")
//    private float GiaBan;
//    @Column(name = "thanhtien")
//    private float ThanhTien;
//    @JoinColumn(name = "sanphamid",insertable = false,updatable = false)
//    @JsonBackReference
//    @OneToOne
//    private SanPham sanPham;
//    @JoinColumn(name = "dondathangid",insertable = false,updatable = false)
//    @JsonBackReference
//    @OneToOne
//    private DonDatHang donDatHang;
//}
