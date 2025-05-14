package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.entity.XeTuanTra;

import java.util.List;

public interface IXeTuanTraRepository {
    void add(XeTuanTra xeTuanTra);

    List<XeTuanTra> findAll();

    void delete(XeTuanTra xeTuanTra);
}
