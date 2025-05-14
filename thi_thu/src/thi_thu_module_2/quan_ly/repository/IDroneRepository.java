package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.entity.Drone;

import java.util.List;

public interface IDroneRepository {
    void add(Drone drone);

    List<Drone> findAll();

    void delete(Drone drone);

    Drone findMaDrone(String maDrone);

    List<Drone> searchNameDrone(String name);
}
