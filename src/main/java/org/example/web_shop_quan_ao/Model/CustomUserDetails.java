//package org.example.web_shop_quan_ao.Model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class CustomUserDetails implements UserDetails {
//    private TaiKhoan taiKhoan;
//    private Collection<? extends GrantedAuthority> authorities;
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return taiKhoan.getPassWord();
//    }
//
//    @Override
//    public String getUsername() {
//        return taiKhoan.getUserName();
//    }
//}