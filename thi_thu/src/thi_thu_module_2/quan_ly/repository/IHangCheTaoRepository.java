package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.entity.HangCheTao;

import java.util.List;

public interface IHangCheTaoRepository {
    List<HangCheTao> findAll();
    HangCheTao findByID(String type);
}
