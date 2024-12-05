package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.TaiKhoan;

import java.util.List;
import java.util.Optional;

public interface ITaiKhoanService {
    public TaiKhoan findByUsername(String userName);
    public TaiKhoan themTaiKhoan(TaiKhoan taiKhoan);
    TaiKhoan findByTaiKhoanId(int taiKhoanId);
//    Boolean checkUserbyPassword (String password);
//    Boolean checkUserbyEmail(String email);
    Boolean checkUserbyEmailAndPassword(String email,String passWord);
    public TaiKhoan suaTaiKhoan(TaiKhoan taiKhoanSua);
    TaiKhoan getUserbyEmail(String email);

}
