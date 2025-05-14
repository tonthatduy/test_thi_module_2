package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.PhuongTien;
import thi_thu_module_2.quan_ly.repository.IPhuongTienRepository;
import thi_thu_module_2.quan_ly.repository.PhuongTienRepository;

public class PhuongTienService implements IPhuongTienService {
    private IPhuongTienRepository phuongTienRepository = new PhuongTienRepository();

    @Override
    public void delete(PhuongTien phuongTien) {
        phuongTienRepository.delete(phuongTien);
    }

    @Override
    public PhuongTien findMaHangPhuongTien(String maHangPhuongTien) {
        return phuongTienRepository.findMaHangPhuongTien(maHangPhuongTien);
    }

    @Override
    public PhuongTien findByID(String id) {
        return phuongTienRepository.findByID(id);
    }
}
