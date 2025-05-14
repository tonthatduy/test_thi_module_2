package thi_thu_module_2.quan_ly.entity;

import java.util.Objects;

public class XeTuanTra extends PhuongTien {
    private int khaNangChongBucXa;

    public XeTuanTra(String soHieuDangKy, String tenHangCheTao, int namSanXuat, String tenDieuPhoi, int khaNangChongBucXa) {
        super(soHieuDangKy, tenHangCheTao, namSanXuat, tenDieuPhoi);
        this.khaNangChongBucXa = khaNangChongBucXa;
    }

    public int getKhaNangChongBucXa() {
        return khaNangChongBucXa;
    }

    public void setKhaNangChongBucXa(int khaNangChongBucXa) {
        this.khaNangChongBucXa = khaNangChongBucXa;
    }

    @Override
    public String toString() {
        return "XeTuanTra{" + super.toString() +
                "khaNangChongBucXa=' Cấp " + khaNangChongBucXa + '\'' +
                '}';
    }

    public String getFileCSVXeTuanTra() {
        return super.toFileCSV() + "," + this.khaNangChongBucXa;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        XeTuanTra xeTuanTra = (XeTuanTra) object;
        return Objects.equals(khaNangChongBucXa, xeTuanTra.khaNangChongBucXa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(khaNangChongBucXa);
    }
}
