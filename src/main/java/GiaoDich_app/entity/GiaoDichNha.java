package GiaoDich_app.entity;

import java.util.Date;

public class GiaoDichNha extends GiaoDich{
    private String loaiNha;
    private String diaChi;


    public GiaoDichNha(String loaiNha, double dienTich, double donGia, int maGiaoDich, Date ngayGiaoDich, String diaChi) {
        super(dienTich, donGia, maGiaoDich, ngayGiaoDich);
        this.loaiNha = loaiNha;
        this.diaChi= diaChi;
    }

    @Override
    public double tinhThanhTien(){
        if (loaiNha.equalsIgnoreCase("Vip")) {
            return super.getDienTich() * super.getDonGia();
        } else if (loaiNha.equalsIgnoreCase("Normal")) {
            return super.getDienTich() * super.getDonGia() * 0.9;
        } else {
            // Nếu loại đất không hợp lệ, trả về 0
            return 0;
        }
    };
}
