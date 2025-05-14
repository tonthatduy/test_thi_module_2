package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.HangCheTao;
import thi_thu_module_2.quan_ly.repository.HangCheTaoRepository;
import thi_thu_module_2.quan_ly.repository.IHangCheTaoRepository;

import java.util.List;

public class HangCheTaoService implements IHangCheTaoService {
    private IHangCheTaoRepository hangCheTaoRepository = new HangCheTaoRepository();


    @Override
    public List<HangCheTao> findAll() {
        return hangCheTaoRepository.findAll();
    }

    @Override
    public HangCheTao findByID(String type) {
        return hangCheTaoRepository.findByID(type);
    }
}
