//package org.example.web_shop_quan_ao.Model.DTO;
//
//import org.example.web_shop_quan_ao.Model.SanPham;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Cart {
//    private List<CartItem>items;
//    private  double tongTien;
//    public Cart(){
//        items=new ArrayList<>();//khởi tạo các item
//        tongTien=0; // gán giá trị
//    }
//    //phương thức lấy item
//    public CartItem getItem(SanPham sanPham){
//        for(CartItem item:items){
//            if(item.getSanPham().getSanPhamId()==sanPham.getSanPhamId()){// đã tồn tại sản phẩm
//                return item;
//            }
//        }
//        return null; // ko tồn tại sp trong giỏ hàng
//    }
//    // lấy về tất cả cá item
//    public  List<CartItem>getItems(){
//        return items;
//    }
//    // lấy về số lượng cái item
//    public  int getItemCount(){
//        return  items.size();
//    }
//    //thêm 1 item
//    public void addItem( CartItem item){
//        addItem(item.getSanPham(),item.getSoLuong());
//    }
//    //thêm item với số lượng cho trước
//    public void addItem(SanPham sanPham,int soLuong){
//        CartItem item=getItem(sanPham);
//        if(item!=null){
//            item.setSoLuong(item.getSoLuong()+ soLuong);
//        }else{
//            item=new CartItem(sanPham);
//            item.setSoLuong(soLuong);
//            items.add(item);
//        }
//    }
//    public void updateItem(SanPham sanPham,int soLuong){
//        CartItem item=getItem(sanPham);
//        if(item!=null){
//            item.setSoLuong(soLuong);
//        }
//    }
//    public void removeItem(SanPham sanPham){
//        CartItem item=getItem(sanPham);
//        if(item!=null){
//            items.remove(item);
//        }
//    }
//    public void clearItem(){
//        items.clear();
//        tongTien=0;
//    }
//    public double getTongTien(){
//        tongTien=0;
//        for(CartItem item:items){
//            tongTien+=item.getThanhTien();
//        }
//        return tongTien;
//    }
//
//}
