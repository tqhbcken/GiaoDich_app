package GiaoDich_app.entity;

import java.util.Date;

public abstract class GiaoDich {
    protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected double donGia;
    protected double dienTich;
    protected String loaiGD;

    public GiaoDich(double dienTich, double donGia, Date ngayGiaoDich, String loaiGD) {
        this.dienTich = dienTich;
        this.donGia = donGia;       
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGD = loaiGD;
    }

    //tinh tong thanh tien
    public abstract double tinhThanhTien();
    //tinh tong so luong tung loaiGD
    public abstract int tinhTongSoLuongGD();

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public String getLoaiGD() {
        return loaiGD;
    }


    
}
