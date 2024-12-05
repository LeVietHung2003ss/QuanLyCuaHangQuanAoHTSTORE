package org.example.web_shop_quan_ao.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "loaisanpham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaisanphamid")
    private int LoaiSanPhamId;
    @Column(name = "tenloai")
    private String TenLoai;
//    @OneToMany(mappedBy = "loaiSanPham")
//    @JsonManagedReference
//    private Set<SanPham> sanPhams;
}
