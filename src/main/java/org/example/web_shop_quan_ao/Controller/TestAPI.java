package org.example.web_shop_quan_ao.Controller;

import org.example.web_shop_quan_ao.Model.DonDatHang;
import org.example.web_shop_quan_ao.Model.GioHang;
import org.example.web_shop_quan_ao.Model.NhaCungCap;
import org.example.web_shop_quan_ao.Model.SanPham;
import org.example.web_shop_quan_ao.Seviece.DonDatHangService;
import org.example.web_shop_quan_ao.Seviece.GioHangService;
import org.example.web_shop_quan_ao.Seviece.NhaCungCapSevice;
import org.example.web_shop_quan_ao.Seviece.SanPhamSeviece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/version1.0")
public class TestAPI {
    @Autowired
    public SanPhamSeviece sanPhamSeviece;
    @Autowired
    public NhaCungCapSevice nhaCungCapSevice;
    @Autowired
    public GioHangService gioHangService;
    @Autowired
    public DonDatHangService donDatHangService;
    @RequestMapping(value = "findDonHangByTaiKhoanId",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DonDatHang> findDonHangByTaiKhoanId(@RequestParam int taiKhoanId){
        return donDatHangService.findDonHangByTaiKhoanId(taiKhoanId);
    }

    @RequestMapping(value = "findGioHangByTaiKhoanId",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GioHang> findGioHangByTaiKhoanId(@RequestParam int taiKhoanId){
        return gioHangService.DsSanPhamByTaiKhoanId(taiKhoanId);
    }

    @RequestMapping(value = "TimKiemSanPham",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SanPham> TimKiemSanPham(@RequestParam String tenSanPham){
        return sanPhamSeviece.TimKiemSanPhamByTen(tenSanPham);
    }
    @RequestMapping(value = "DsNhaCungCap",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NhaCungCap> DsNhaCungCap(){
        return nhaCungCapSevice.DsNhaCungCap();
    }
    @RequestMapping(value = "SuaNhaCungCap",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public NhaCungCap SuaNhaCungCap(@RequestBody NhaCungCap nhaCungCap){
        return nhaCungCapSevice.SuaNhaCungCap(nhaCungCap);
    }
    @RequestMapping(value = "DsSanPham",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SanPham> DsSanPham(){
        return sanPhamSeviece.DsSanPham();
    }
    @RequestMapping(value = "SuaSanPham", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public SanPham SuaSanPham(@RequestBody SanPham sanPham){
        return sanPhamSeviece.SuaSanPham(sanPham);
    }
    @RequestMapping(value = "DemSoLuongSanPham",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public long DemSoLuongSanPham(){
        return sanPhamSeviece.DemSoLuongSanPham();
    }
}
