package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.example.web_shop_quan_ao.Repository.DbConnect;
import org.example.web_shop_quan_ao.Repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService implements ITaiKhoanService{
    @Autowired
    public DbConnect dbConnect;
    @Override
    public TaiKhoan findByUsername(String userName) {
        return dbConnect.taiKhoanRepo.getTaiKhoanByUserName(userName);
    }

    @Override
    public TaiKhoan findByTaiKhoanId(int taiKhoanId) {
        return dbConnect.taiKhoanRepo.findById(taiKhoanId).get();
    }

    @Override
    public TaiKhoan themTaiKhoan(TaiKhoan taiKhoan) {
        return dbConnect.taiKhoanRepo.save(taiKhoan);
    }

    @Override
    public TaiKhoan suaTaiKhoan(TaiKhoan taiKhoanSua) {
        Optional<TaiKhoan> taiKhoan=dbConnect.taiKhoanRepo.findById(taiKhoanSua.getTaiKhoanId());
        if(taiKhoan.isEmpty()){
            return null;
        }
        TaiKhoan taiKhoan1=taiKhoan.get();
        taiKhoan1.setFullName(taiKhoanSua.getFullName());
        taiKhoan1.setUserName(taiKhoanSua.getUserName());
        taiKhoan1.setPassWord(taiKhoanSua.getPassWord());
        taiKhoan1.setGender(taiKhoanSua.getGender());
        taiKhoan1.setAddress(taiKhoanSua.getAddress());
        taiKhoan1.setTelephone(taiKhoanSua.getTelephone());
        taiKhoan1.setEmail(taiKhoanSua.getEmail());
        dbConnect.taiKhoanRepo.save(taiKhoan1);
        return taiKhoan1;
    }

//    @Override
//    public Boolean checkUserbyPassword(String password) {
//        List<TaiKhoan> user=dbConnect.taiKhoanRepo.findTaiKhoanByPassWord(password);
//        if(user==null) return false;
//        return true;
//    }
//
//    @Override
//    public Boolean checkUserbyEmail(String email) {
//        TaiKhoan user = dbConnect.taiKhoanRepo.findTaiKhoanByUserName(email);
//        if(user==null) return false;
//        return true;
//    }


    @Override
    public Boolean checkUserbyEmailAndPassword(String email, String passWord) {
        TaiKhoan check=dbConnect.taiKhoanRepo.findTaiKhoanByUserNameAndPassWord(email,passWord);
        if(check==null) return false;
        return true;
    }

    @Override
    public TaiKhoan getUserbyEmail(String email) {
        return dbConnect.taiKhoanRepo.getTaiKhoanByUserName(email);
    }
}
