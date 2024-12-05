package org.example.web_shop_quan_ao.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "nhacungcap")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nhacungcapid")
    private int NhaCungCapId;
    @Column(name="tennhacungcap")
    private String TenNhaCungCap;
    @Column(name = "diachi")
    private String DiaChi;
    @Column(name = "sdt")
    private int SDT;
    @Column(name = "email")
    private String Email;
//    @OneToMany(mappedBy = "nhaCungCap")
//    @JsonManagedReference
//    private Set<SanPham> sanPhams;

}
