package org.example.web_shop_quan_ao.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "khachhang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khachhangid")
    private int KhachHangId;
    @Column(name = "hoten")
    private String HoTen;
    @Column(name = "diachi")
    private String DiaChi;
    @Column(name = "sdt")
    private String  SDT;
    @Column(name = "email")
    private String Email;

}
