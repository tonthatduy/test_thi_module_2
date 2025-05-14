package thi_thu_module_2.quan_ly.service;

import thi_thu_module_2.quan_ly.entity.Drone;
import thi_thu_module_2.quan_ly.repository.DroneRepository;
import thi_thu_module_2.quan_ly.repository.IDroneRepository;

import java.util.List;

public class DroneService implements IDroneService {
    private IDroneRepository droneRepository = new DroneRepository();

    @Override
    public void add(Drone drone) {
        droneRepository.add(drone);
    }

    @Override
    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    @Override
    public void delete(Drone drone) {
        droneRepository.delete(drone);
    }

    @Override
    public Drone findMaDrone(String maDrone) {
        return droneRepository.findMaDrone(maDrone);
    }

    @Override
    public List<Drone> searchNameDrone(String name) {
        return droneRepository.searchNameDrone(name);
    }
}
