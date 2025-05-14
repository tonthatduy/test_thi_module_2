package thi_thu_module_2.quan_ly.controller;

import thi_thu_module_2.quan_ly.common.NotFoundVehicleException;
import thi_thu_module_2.quan_ly.entity.Drone;
import thi_thu_module_2.quan_ly.entity.HangCheTao;
import thi_thu_module_2.quan_ly.entity.PhuongTien;
import thi_thu_module_2.quan_ly.entity.XeTuanTra;
import thi_thu_module_2.quan_ly.service.*;
import thi_thu_module_2.quan_ly.view.PhuongTienView;

import java.util.List;
import java.util.Scanner;

public class PhuongTienController {
    private static Scanner scanner = new Scanner(System.in);
    private static IHangCheTaoService hangCheTaoService = new HangCheTaoService();
    private static IDroneService droneService = new DroneService();
    private static IPhuongTienService phuongTienService = new PhuongTienService();
    private static IXeTuanTraService xeTuanTraService = new XeTuanTraService();

    public static void displayMenu() {
        do {
            System.out.println("===Quản Lý Phương Tiện===");
            System.out.println("1.  Thêm mới phương tiện");
            System.out.println("2.  Hiển thị danh sách phương tiện");
            System.out.println("3.  Tìm kiếm phương tiện");
            System.out.println("4.  Xóa phương tiện");
            System.out.println("5.  Thoát ứng dụng");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    add();
                }
                case 2 -> {
                    System.out.println("===Hiển Thị Thông Tin Phương Tiện===");
                    display();
                }
                case 3 -> {
                    System.out.println("===Tìm Kiếm Tên Phương Tiện===");
//                    searchDrone();
                    searchPhuongTien();
                }
                case 4 -> {
                    System.out.println("===Xóa Phương Tiện===");
                    delete();
                }
                case 5 -> {
                    System.out.println("Tạm biệt");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Không hợp lệ nhập lại");
                }
            }
        } while (true);
    }

    private static void add() {
        do {
            System.out.println("===Thêm mới phương tiện===");
            System.out.println("1.  Thêm Drone Bay");
            System.out.println("2.  Thêm Xe Tuần Tra");
            System.out.println("3.  Thoát");
            System.out.print("Lụa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("===Thêm Drone===");
                        addDrone();
                    }
                    case 2 -> {
                        System.out.println("===Thêm Xe Tuần Tra===");
                        addXeTuanTra();
                    }
                    case 3 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Không Hợp Lệ!");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập số");
            }

        } while (true);
    }

    private static void display() {
        do {
            System.out.println("===Hiển Thị phương tiện===");
            System.out.println("1.  Hiển Thị Drone Bay");
            System.out.println("2.  Hiển Thị Xe Tuần Tra");
            System.out.println("3.  Thoát");
            System.out.print("Lụa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("===Hiển Thị Drone ===");
                        displayDrone();
                    }
                    case 2 -> {
                        System.out.println("===Thêm Xe Tuần Tra===");
                        displayXeTuanTra();
                    }
                    case 3 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Không Hợp Lệ!");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập số");
            }

        } while (true);

    }

    public static boolean checkHangCheTao(String type) {
        HangCheTao hangCheTao = hangCheTaoService.findByID(type);
        if (hangCheTao != null) {
            return true;
        }
        return false;
    }

    public static String getHangCheTao(String id) {
        HangCheTao hangCheTao = hangCheTaoService.findByID(id);
        return hangCheTao.getTenHang();
    }

    private static void addDrone() {
        Drone drone = new PhuongTienView().inputDrone();
        droneService.add(drone);
        System.out.println("Thêm Mới Thành Công");
    }

    private static void addXeTuanTra() {
        XeTuanTra xeTuanTra = new PhuongTienView().inputXeTuanTra();
        xeTuanTraService.add(xeTuanTra);
        System.out.println("Thêm Mới Thành Công");
    }


    public static void displayHangCheTao() {
        List<HangCheTao> hangCheTaos = hangCheTaoService.findAll();
        PhuongTienView.displayListHangCheTao(hangCheTaos);
    }

    private static void displayDrone() {
        List<Drone> droneList = droneService.findAll();
        PhuongTienView.displayListDrone(droneList);
    }

    private static void displayXeTuanTra() {
        List<XeTuanTra> xeTuanTraList = xeTuanTraService.findAll();
        PhuongTienView.displayListXeTuanTra(xeTuanTraList);
    }

    private static void delete() {
        boolean flag = false;
        do {
            String soHieu = PhuongTienView.nhapSoHieu();
            PhuongTien phuongTien = phuongTienService.findMaHangPhuongTien(soHieu);
            if (phuongTien == null) {
                try {
                    throw new NotFoundVehicleException("Không Tìm Thấy");

                } catch (NotFoundVehicleException e) {
                    System.out.println(e.getMessage());
                    flag = true;
                }

            } else if (PhuongTienView.comFirm()) {
                phuongTienService.delete(phuongTien);
                System.out.println("Xóa Thành Công");
                break;
            } else {
                System.out.println("Hủy!!");
            }
        } while (flag);
    }

    private static void searchDrone() {
        String name = PhuongTienView.nhapTenDrone();
        List<Drone> drones = droneService.searchNameDrone(name);
        PhuongTienView.displayListDrone(drones);
    }

    private static void searchPhuongTien() {
        String id = PhuongTienView.nhapSoHieu();
        PhuongTien phuongTien = phuongTienService.findByID(id);
        PhuongTienView.displayListPhuongTien(phuongTien);
    }
}
