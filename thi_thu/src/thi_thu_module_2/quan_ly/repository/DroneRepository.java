package thi_thu_module_2.quan_ly.repository;

import thi_thu_module_2.quan_ly.common.ReadAndWriteFile;
import thi_thu_module_2.quan_ly.entity.Drone;

import java.util.ArrayList;
import java.util.List;

public class DroneRepository implements IDroneRepository {
    private static final String DRONE_FILE = "src/thi_thu_module_2/quan_ly/data/drone.csv";

    @Override
    public void add(Drone drone) {
        List<String> stringList = new ArrayList<>();
        stringList.add(drone.getFileCSVDrone());
        ReadAndWriteFile.writeFileCSV(DRONE_FILE, stringList, true);
    }

    @Override
    public List<Drone> findAll() {
        List<Drone> drones = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFileCSV(DRONE_FILE);
        String[] array;
        for (int i = 0; i < stringList.size(); i++) {
            array = stringList.get(i).split("\\s*,\\s*");
            Drone drone = new Drone(array[0], array[1], Integer.parseInt(array[2]), array[3], Double.parseDouble(array[4]));
            drones.add(drone);
        }
        return drones;
    }

    @Override
    public void delete(Drone drone) {
        List<Drone> drones = findAll();
        drones.remove(drone);
        List<String> stringList = new ArrayList<>();
        for (Drone drone1 : drones) {
            stringList.add(drone1.getFileCSVDrone());
        }
        ReadAndWriteFile.writeFileCSV(DRONE_FILE, stringList, false);
    }

    @Override
    public Drone findMaDrone(String maDrone) {
        List<Drone> drones = findAll();
        for (Drone drone : drones) {
            if (drone.getSoHieuDangKy().contains(maDrone)) {
                return drone;
            }
        }
        return null;
    }

    @Override
    public List<Drone> searchNameDrone(String name) {
        List<Drone> drones = new ArrayList<>();
        for (Drone drone : findAll()) {
            if (drone.getTenDieuPhoi().contains(name)) {
                drones.add(drone);
            }
        }
        return drones;
    }

}
