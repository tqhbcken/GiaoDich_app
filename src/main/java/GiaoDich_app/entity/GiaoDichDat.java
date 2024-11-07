package GiaoDich_app.entity;

import java.util.Date;

public class GiaoDichDat extends GiaoDich {

    private String loaiDat;

    public GiaoDichDat(double dienTich, double donGia, Date ngayGiaoDich, String loaiDat) {
        super(dienTich, donGia, ngayGiaoDich, "Dat");
        this.loaiDat = loaiDat;
    }

    

    @Override
    public double tinhThanhTien() {
        double thanhTien;

        switch (loaiDat) {
            case "A":
                thanhTien = getDienTich() * getDonGia() * 1.5;  // Loại A
                break;
            case "B":
            case "C":
                thanhTien = getDienTich() * getDonGia();  // Loại B và C
                break;
            default:
                thanhTien = 0;  // Trường hợp không hợp lệ
                break;
        }
        return thanhTien;
    }

    public String getLoaiDat() {
        return loaiDat;
    }
}
