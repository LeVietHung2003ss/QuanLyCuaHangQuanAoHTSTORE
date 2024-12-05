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
//@Table(name = "quyentk")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class QuyenTK {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "quentkId")
//    private int Id;
//    @JoinColumn(name = "quyenid",referencedColumnName = "quyenid")
//    @ManyToOne
//    private Quyen quyen;
//    @JoinColumn(name = "taikhanid",referencedColumnName = "taikhanid")
//    @ManyToOne
//    private TaiKhoan taikhoan;
//
//
//}
