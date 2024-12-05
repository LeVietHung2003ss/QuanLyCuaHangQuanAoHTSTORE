package org.example.web_shop_quan_ao.Repository;

import org.example.web_shop_quan_ao.Model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan,Integer> {
//    @Query(value = "SELECT * FROM TaiKhoan  WHERE TaiKhoan .userName=:userName",nativeQuery = true)
//    public TaiKhoan tenUser(@Param("userName")String userName);

    TaiKhoan getTaiKhoanByUserName(String userName);
//    TaiKhoan findTaiKhoanByUserName(String userName);
//   List <TaiKhoan> findTaiKhoanByPassWord(String passWord);
   TaiKhoan findTaiKhoanByUserNameAndPassWord(String userName, String passWord);
}
