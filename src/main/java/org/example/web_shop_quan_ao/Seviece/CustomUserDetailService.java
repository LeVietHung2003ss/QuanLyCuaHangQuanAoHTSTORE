//package org.example.web_shop_quan_ao.Seviece;
//
//import org.example.web_shop_quan_ao.Model.CustomUserDetails;
//import org.example.web_shop_quan_ao.Model.QuyenTK;
//import org.example.web_shop_quan_ao.Model.TaiKhoan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    private ITaiKhoanService iTaiKhoanService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TaiKhoan taiKhoan=iTaiKhoanService.findByUserName(username);
//        if(taiKhoan==null){
//            throw new UsernameNotFoundException("Sai");
//        }
//        Collection<GrantedAuthority> grantedAuthoritySet=new HashSet<>();
//        Set<QuyenTK> quyenTKS=taiKhoan.getQuyenTKS();
//        for(QuyenTK quyen : quyenTKS){
//            grantedAuthoritySet.add(new SimpleGrantedAuthority(quyen.getQuyen().getTenQuyen()));
//        }
//        return new CustomUserDetails(taiKhoan,grantedAuthoritySet);
//    }
//}
