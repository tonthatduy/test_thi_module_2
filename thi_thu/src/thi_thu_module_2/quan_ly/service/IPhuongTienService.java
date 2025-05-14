package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.PhuongTien;

public interface IPhuongTienService {
    void delete(PhuongTien phuongTien);
    PhuongTien findMaHangPhuongTien(String maHangPhuongTien);
    PhuongTien findByID(String id);
}
