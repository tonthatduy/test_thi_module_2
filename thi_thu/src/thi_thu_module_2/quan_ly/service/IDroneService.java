package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.Drone;

import java.util.List;

public interface IDroneService {
    void add(Drone drone);

    List<Drone> findAll();

    void delete(Drone drone);

    Drone findMaDrone(String maDrone);

    List<Drone> searchNameDrone(String name);
}
