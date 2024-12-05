package org.example.web_shop_quan_ao.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "giohang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "giohangid")
    private int GioHangId;
    @Column(name="sanphamid")
    private int SanPhamId;
    @Column(name = "taikhoanid")
    private int TaiKhoanId;
    @Column(name = "soluong")
    private int SoLuong;
    @Column(name = "thanhtien")
    private  double ThanhTien;
    @JoinColumn(name = "sanphamid",insertable = false,updatable = false)
    @ManyToOne
    private SanPham sanPham;
    @JoinColumn(name = "taikhoanid",insertable = false,updatable = false)
    @OneToOne
    private TaiKhoan taiKhoan;



    public GioHang(SanPham sanPham,TaiKhoan taiKhoan,int soLuong){
        this.sanPham=sanPham;
        this.taiKhoan=taiKhoan;
        soLuong=1;
        this.ThanhTien=sanPham.getGiaSanPham()*soLuong;
    }
    public  GioHang(SanPham sanPham){

    }


}
