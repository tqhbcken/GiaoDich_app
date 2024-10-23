package GiaoDich_app.usecase.dto;

import java.util.Date;

public class AddGiaoDichInputDTO {

    protected Date ngayGiaoDich;
    protected double dienTich;
    protected double donGia;
    protected String loaiGD;

    //nha
    private String diaChi;
    private String loaiNha;

    //dat
    private String loaiDat;


    //contructor cho gd
    public AddGiaoDichInputDTO(Date ngayGiaoDich, double dienTich, double donGia, String loaiGD) {
        this.ngayGiaoDich = ngayGiaoDich;
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.loaiGD = loaiGD;
    }
    //contructor cho nha
    public AddGiaoDichInputDTO(Date ngayGiaoDich, double donGia, double dienTich, String loaiGD, String loaiNha, String diaChi) {
        this(ngayGiaoDich, donGia, dienTich, loaiGD);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    //contructor cho dat
    public AddGiaoDichInputDTO(Date ngayGiaoDich, double dienTich, double donGia, String loaiGD, String loaiDat) {
        this.ngayGiaoDich = ngayGiaoDich;
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.loaiGD = loaiGD;
        this.loaiDat = loaiDat;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getLoaiGD() {
        return loaiGD;
    }

    public void setLoaiGD(String loaiGD) {
        this.loaiGD = loaiGD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }
}



