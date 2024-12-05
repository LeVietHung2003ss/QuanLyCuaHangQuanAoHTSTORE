//package org.example.web_shop_quan_ao.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.Set;
//
//@Entity
//@Table(name = "quyen")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Quyen {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "quyenid")
//    private int QuyenId;
//    @Column(name = "tenquyen")
//    private String TenQuyen;
//    @OneToMany(mappedBy = "quyen")
//    private Set<QuyenTK>quyenTKS;
//}
