package GiaoDich_app.usecase.dto;

import java.util.Date;

public class AddGiaoDichOutputDTO {
    
    protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected double donGia;
    protected double dienTich;

    protected double thanhTien;
    protected int tongSoLuongGD;

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public AddGiaoDichOutputDTO(int maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich, double thanhTien, int tongSoLuongGD) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.thanhTien = thanhTien;
        this.tongSoLuongGD = tongSoLuongGD;
    }

    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTongSoLuongGD() {
        return tongSoLuongGD;
    }

    public void setTongSoLuongGD(int tongSoLuongGD) {
        this.tongSoLuongGD = tongSoLuongGD;
    }
}
