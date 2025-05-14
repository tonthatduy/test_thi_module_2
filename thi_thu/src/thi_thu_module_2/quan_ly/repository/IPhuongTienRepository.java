package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.entity.PhuongTien;

import java.util.List;

public interface IPhuongTienRepository {
    void delete(PhuongTien phuongTien);

    PhuongTien findMaHangPhuongTien(String tenDieuPhoi);

    List<PhuongTien> findAll();

    PhuongTien findByID(String id);
}
