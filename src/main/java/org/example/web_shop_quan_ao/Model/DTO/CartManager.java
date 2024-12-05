//package org.example.web_shop_quan_ao.Model.DTO;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CartManager {
//    private static final String SESSION_KEY_SHOPPING_CART="gioHang";
//    //phương thức lấy về giỏ hàng
//    public Cart getCart(HttpSession session){
//        Cart cart=(Cart) session.getAttribute(SESSION_KEY_SHOPPING_CART);
//        if(cart==null){
//            cart=new Cart();
//            session.setAttribute(SESSION_KEY_SHOPPING_CART,cart);
//        }
//
//        return cart;
//    }
//    //thiết lập một giỏ hàng
//    public  void setCart(HttpSession session,Cart cart){
//        session.setAttribute(SESSION_KEY_SHOPPING_CART,cart);
//    }
//    //xóa giỏ hàng
//    public void  removeCart(HttpSession session){
//        session.removeAttribute(SESSION_KEY_SHOPPING_CART);
//    }
//
//}
