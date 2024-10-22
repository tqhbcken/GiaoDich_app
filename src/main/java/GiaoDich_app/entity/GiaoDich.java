package GiaoDich_app.entity;

import java.util.Date;

public abstract class GiaoDich {
    protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected double donGia;
    protected double dienTich;

    public GiaoDich(double dienTich, double donGia, int maGiaoDich, Date ngayGiaoDich) {
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public abstract double tinhThanhTien();

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


    
}
