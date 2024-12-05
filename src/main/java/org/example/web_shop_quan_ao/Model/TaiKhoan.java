package org.example.web_shop_quan_ao.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="taikhoan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taikhoanid")
    private int TaiKhoanId;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String passWord;
//    @Column(name = "enabled")
//    private Boolean enabled;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "vaitro")
    private  String vaitro;
//    @OneToMany(mappedBy = "taikhoan",fetch = FetchType.EAGER)
//    private Set<QuyenTK> quyenTKS;
}
