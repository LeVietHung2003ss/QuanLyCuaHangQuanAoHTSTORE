package org.example.web_shop_quan_ao.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sanpham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sanphamid")
    private int SanPhamId;
    @Column(name = "loaisanphamid")
    private int LoaiSanPhamId;
    @Column(name = "nhacungcapid")
    private int NhaCungCapId;
    @Column(name = "tensanpham")
    private String TenSanPham;
    @Column(name="giasanpham")
    private int GiaSanPham;
    @Lob
    @Column(name="motasanpham",columnDefinition = "TEXT")
    private String MoTaSanPham;
    @Column(name="hinhanh")
    private String HinhAnh;
    @Column(name = "tongsoluongtrongkho")
    private int TongSoLuongTrongKho;
    @JoinColumn(name = "loaisanphamid",insertable = false,updatable = false)
    @JsonBackReference(value = "loaiSanPham-sanPham")
    @ManyToOne
    private LoaiSanPham loaiSanPham;
    @JoinColumn(name = "nhacungcapid",insertable = false,updatable = false)
    @JsonBackReference(value = "nhaCungCap-sanPham")
    @ManyToOne
    private NhaCungCap nhaCungCap;

}
