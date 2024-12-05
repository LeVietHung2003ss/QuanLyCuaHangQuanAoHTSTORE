//package org.example.web_shop_quan_ao.Seviece;
//
//import org.example.web_shop_quan_ao.Model.DTO.CartItem;
//import org.example.web_shop_quan_ao.Model.SanPham;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.annotation.SessionScope;
//
//import java.util.HashMap;
//import java.util.Map;
//@SessionScope
//@Service
//public interface ShoppingCartService {
//    Map<SanPham, CartItem> maps=new HashMap<>(); //hiển thị danh sách giỏ hàng
//    public  void add(CartItem item){
//        CartItem cartItem=maps.get(item.getSanPhamId());
//        if(cartItem==null){
//            maps.put(item.getSanPhamId(),item);
//        }
//    }
//
//
//}
