package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.XeTuanTra;

import java.util.List;

public interface IXeTuanTraService {
    List<XeTuanTra> findAll();
    void add(XeTuanTra xeTuanTra);
}
