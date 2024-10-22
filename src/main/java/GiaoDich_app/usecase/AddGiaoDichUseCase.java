package GiaoDich_app.usecase;

import java.util.Date;

public class AddGiaoDichUseCase {
    protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected double dienTich;
    protected double donGia;

    //nha
    protected String loaiNha;
    protected String diaChi;

    //dat
    protected String loaiDat;

    public AddGiaoDichUseCase(double dienTich, double donGia, int maGiaoDich, Date ngayGiaoDich) {
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public AddGiaoDichUseCase(String diaChi, double dienTich, double donGia, String loaiNha, int maGiaoDich, Date ngayGiaoDich) {
        this.diaChi = diaChi;
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.loaiNha = loaiNha;
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public AddGiaoDichUseCase(int maGiaoDich, Date ngayGiaoDich, double donGia, String diaChi, String loaiDat) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.diaChi = diaChi;
        this.loaiDat = loaiDat;
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
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

    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }

    


}
