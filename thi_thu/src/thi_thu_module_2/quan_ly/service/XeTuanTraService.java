package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.XeTuanTra;
import thi_thu_module_2.quan_ly.repository.IXeTuanTraRepository;
import thi_thu_module_2.quan_ly.repository.XeTuanTraRepository;

import java.util.List;

public class XeTuanTraService implements IXeTuanTraService {
    private IXeTuanTraRepository xeTuanTraRepository = new XeTuanTraRepository();

    @Override
    public List<XeTuanTra> findAll() {
        return xeTuanTraRepository.findAll();
    }

    @Override
    public void add(XeTuanTra xeTuanTra) {
        xeTuanTraRepository.add(xeTuanTra);
    }
}
