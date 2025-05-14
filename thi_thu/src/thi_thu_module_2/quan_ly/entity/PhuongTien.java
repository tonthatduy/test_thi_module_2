package thi_thu_module_2.quan_ly.entity;

public abstract class PhuongTien {
    private String soHieuDangKy;
    private String tenHangCheTao;
    private int namSanXuat;
    private String tenDieuPhoi;

    public PhuongTien(String soHieuDangKy, String tenHangCheTao, int namSanXuat, String tenDieuPhoi) {
        this.soHieuDangKy = soHieuDangKy;
        this.tenHangCheTao = tenHangCheTao;
        this.namSanXuat = namSanXuat;
        this.tenDieuPhoi = tenDieuPhoi;
    }

    public String getSoHieuDangKy() {
        return soHieuDangKy;
    }

    public void setSoHieuDangKy(String soHieuDangKy) {
        this.soHieuDangKy = soHieuDangKy;
    }

    public String getTenHangCheTao() {
        return tenHangCheTao;
    }

    public void setTenHangCheTao(String tenHangCheTao) {
        this.tenHangCheTao = tenHangCheTao;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getTenDieuPhoi() {
        return tenDieuPhoi;
    }

    public void setTenDieuPhoi(String tenDieuPhoi) {
        this.tenDieuPhoi = tenDieuPhoi;
    }

    @Override
    public String toString() {
        return "soHieuDangKy='" + soHieuDangKy + '\'' +
                ", tenHangCheTao='" + tenHangCheTao + '\'' +
                ", NamSanXuat='" + namSanXuat + '\'' +
                ", tenDieuPhoi='" + tenDieuPhoi + '\'';
    }
    public String toFileCSV(){
        return this.soHieuDangKy + "," + this.tenHangCheTao +"," + this.namSanXuat +"," + this.tenDieuPhoi;
    }
}
