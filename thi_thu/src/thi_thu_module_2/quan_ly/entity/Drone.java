package thi_thu_module_2.quan_ly.entity;

import java.util.Objects;

public class Drone extends PhuongTien {
    private double tamBayToiDa;

    public Drone(String soHieuDangKy, String tenHangCheTao, int namSanXuat, String tenDieuPhoi, double tamBayToiDa) {
        super(soHieuDangKy, tenHangCheTao, namSanXuat, tenDieuPhoi);
        this.tamBayToiDa = tamBayToiDa;
    }

    public double getTamBayToiDa() {
        return tamBayToiDa;
    }

    public void setTamBayToiDa(double tamBayToiDa) {
        this.tamBayToiDa = tamBayToiDa;
    }

    @Override
    public String toString() {
        return "Drone{" +
                super.toString() +
                "tamBayToiDa='" + tamBayToiDa + '\'' +
                '}';
    }

    public String getFileCSVDrone() {
        return super.toFileCSV() + "," + this.tamBayToiDa;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Drone drone = (Drone) object;
        return Objects.equals(tamBayToiDa, drone.tamBayToiDa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tamBayToiDa);
    }
}
