package thi_thu_module_2.quan_ly.view;

import thi_thu_module_2.quan_ly.common.Validate;
import thi_thu_module_2.quan_ly.controller.PhuongTienController;
import thi_thu_module_2.quan_ly.entity.Drone;
import thi_thu_module_2.quan_ly.entity.HangCheTao;
import thi_thu_module_2.quan_ly.entity.PhuongTien;
import thi_thu_module_2.quan_ly.entity.XeTuanTra;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhuongTienView {
    private static Scanner scanner = new Scanner(System.in);

    public static String nhapSoHieu() {
        System.out.println("Nhập Số Hiệu");
        return scanner.nextLine();
    }

    public static boolean comFirm() {
        String string;
        do {
            System.out.println("Nhập Y để Xóa N để Hủy");
            string = scanner.nextLine();
        } while (!string.equalsIgnoreCase("Y") && !string.equalsIgnoreCase("N"));
        if (string.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void displayListPhuongTien(PhuongTien phuongTien) {
        System.out.println(phuongTien);
    }

    public static void displayListDrone(List<Drone> drones) {
        for (int i = 0; i < drones.size(); i++) {
            System.out.println(drones.get(i));
        }
    }

    public static void displayListXeTuanTra(List<XeTuanTra> xeTuanTras) {
        for (int i = 0; i < xeTuanTras.size(); i++) {
            System.out.println(xeTuanTras.get(i));

        }
    }


    public static void displayListHangCheTao(List<HangCheTao> hangCheTaos) {
        for (HangCheTao hangCheTao : hangCheTaos) {
            System.out.println(hangCheTao.getMaHang() + "," + hangCheTao.getTenHang() + "," + hangCheTao.getQuocGia());
        }
    }

    public static String nhapTenDrone() {
        System.out.println("Nhập tên khách hàng cần tìm");
        return scanner.nextLine();
    }


    public Drone inputDrone() {
        System.out.println("Nhập mã phương tiện(DRN-XXX): ");
        String id = Validate.validateInput("DRN-\\d{3}", "Mã Phương Tiện Sai Định Dạng. Nhập lại");
        PhuongTienController.displayHangCheTao();
        String hangCheTao;
        do {
            System.out.println("Chọn Hãng Chế Tạo");
            hangCheTao = scanner.nextLine();
            if (PhuongTienController.checkHangCheTao(hangCheTao)) {
                hangCheTao = PhuongTienController.getHangCheTao(hangCheTao);
                break;
            } else {
                System.out.println("Không Hợp Lệ");
            }
        } while (true);
        int namSanXuat = Validate.inputYear();
        System.out.println("Nhập tên người điều phối (VD: Nguyen Van A)");
        String tenNguoiDieuPhoi = Validate.validateInput("^([A-Z][a-z]*)\\s([A-Z][a-z]*\\s)*([A-Z][a-z]*)$",
                "Tên Sai Định Dạng, Nhập Chữ Cái Đầu Phải ghi hoa");
        System.out.println("Tầm bay tối đa");
        double tamBayToiDa = Validate.validateDouble(0, Double.MAX_VALUE, "Tầm Bay Không Hợp Lệ");
        return new Drone(id, hangCheTao, namSanXuat, tenNguoiDieuPhoi, tamBayToiDa);
    }

    public XeTuanTra inputXeTuanTra() {
        String idRegex = "XTT-\\d{3}";
        Pattern pattern = Pattern.compile(idRegex);
        String id;
        do {
            System.out.println("Nhập mã phương tiện(XTT-XXX): ");
            id = scanner.nextLine();
            Matcher matcher = pattern.matcher(id);
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Mã Không Hợp Lệ");
            }
        } while (true);
        PhuongTienController.displayHangCheTao();
        String hangCheTao;
        do {
            System.out.println("Chọn Hãng Chế Tạo");
            hangCheTao = scanner.nextLine();
            if (PhuongTienController.checkHangCheTao(hangCheTao)) {
                hangCheTao = PhuongTienController.getHangCheTao(hangCheTao);
                break;
            } else {
                System.out.println("Không Hợp Lệ");
            }
        } while (true);
        System.out.println("Nhập Năm Sản Xuất");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên người điều phối");
        String tenNguoiDieuPhoi = scanner.nextLine();
        System.out.println("Nhập khả năng chống bức xạ");
        int khaNangChongPhucXa = Validate.validateInteger(1, 10, "Dữ Liệu Không Hợp Lệ");
        return new XeTuanTra(id, hangCheTao, namSanXuat, tenNguoiDieuPhoi, khaNangChongPhucXa);

    }

    public static String findMaDrone() {
        System.out.println("Nhập Mã Drone Cần Xóa");
        return scanner.nextLine();
    }

}
