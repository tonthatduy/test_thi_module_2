package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.HangCheTao;

import java.util.List;

public interface IHangCheTaoService {
    List<HangCheTao> findAll();
    HangCheTao findByID(String type);
}
