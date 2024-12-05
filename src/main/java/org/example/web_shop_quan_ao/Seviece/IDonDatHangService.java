package org.example.web_shop_quan_ao.Seviece;

import lombok.Data;
import org.example.web_shop_quan_ao.Model.DonDatHang;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IDonDatHangService {
    public List<DonDatHang>findDonHangByTaiKhoanId(int taiKhoanId);
    List<DonDatHang> findDonHangByDateRange(String fromDate, String toDate);
}
