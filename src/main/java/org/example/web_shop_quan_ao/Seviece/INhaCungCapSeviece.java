package org.example.web_shop_quan_ao.Seviece;

import org.example.web_shop_quan_ao.Model.NhaCungCap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface INhaCungCapSeviece {
    public List<NhaCungCap> DsNhaCungCap();
    Optional<NhaCungCap>findNhaCungCapById(int id);
    public NhaCungCap ThemNhaCungCap(NhaCungCap nhaCungCap);
    public NhaCungCap SuaNhaCungCap(NhaCungCap nhaCungCapSua);
    public NhaCungCap XoaNhaCungCap(int idNhaCungCap);
    public List<NhaCungCap> TimKiemNhaCungCap(String tenNhaCungCap);
}
