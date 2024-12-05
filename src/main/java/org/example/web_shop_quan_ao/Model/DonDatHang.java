package org.example.web_shop_quan_ao.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "dondathang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dondathangid")
    private int DonDatHangId;
    @Column(name = "giohangid")
    private int GioHangId;
    @Column(name = "ngaydathang")
    private String NgayDatHang;
    @Column(name = "khachhangid")
    private int KhachHangId;
    @Column(name = "trangthai")
    private boolean TrangThai;
    @Column(name = "taikhoanid")
    private int TaiKhoanId;
    @Column(name = "tonggiatridondathang")
    private double TongGiaTriDonHang;
    @JoinColumn(name = "khachhangid",insertable = false,updatable = false)
    @ManyToOne
    private KhachHang khachHang;
    @JoinColumn(name = "giohangid",insertable = false,updatable = false)
    @ManyToOne
    private GioHang gioHang;
    @JoinColumn(name = "taikhoanid",insertable = false,updatable = false)
    @ManyToOne
    private TaiKhoan taiKhoan;

}
