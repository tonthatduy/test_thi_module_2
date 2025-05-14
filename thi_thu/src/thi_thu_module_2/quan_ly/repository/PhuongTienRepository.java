package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.entity.Drone;
import thi_thu_module_2.quan_ly.entity.PhuongTien;
import thi_thu_module_2.quan_ly.entity.XeTuanTra;

import java.util.ArrayList;
import java.util.List;

public class PhuongTienRepository implements IPhuongTienRepository {
    private static List<PhuongTien> phuongTiens = new ArrayList<>();
    private static IDroneRepository droneRepository = new DroneRepository();
    private static IXeTuanTraRepository xeTuanTraRepository = new XeTuanTraRepository();

    @Override
    public List<PhuongTien> findAll() {
        phuongTiens.addAll(droneRepository.findAll());
        phuongTiens.addAll(xeTuanTraRepository.findAll());
        return phuongTiens;
    }

    @Override
    public void delete(PhuongTien phuongTien) {
        if (phuongTien instanceof Drone) {
            droneRepository.delete((Drone) phuongTien);
        } else if (phuongTien instanceof XeTuanTra) {
            xeTuanTraRepository.delete((XeTuanTra) phuongTien);
        }
    }

    @Override
    public PhuongTien findMaHangPhuongTien(String maHangPhuongTien) {
        List<PhuongTien> phuongTiens1 = findAll();
        for (int i = 0; i < phuongTiens1.size(); i++) {
            if (phuongTiens1.get(i).getSoHieuDangKy().equalsIgnoreCase(maHangPhuongTien))
                return phuongTiens1.get(i);
        }
        return null;
    }

    @Override
    public PhuongTien findByID(String id) {
        for (PhuongTien phuongTien : findAll()) {
            if (phuongTien.getSoHieuDangKy().equalsIgnoreCase(id)) {
                return phuongTien;
            }
        }
        return null;
    }


}
