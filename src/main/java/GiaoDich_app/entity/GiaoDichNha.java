package GiaoDich_app.entity;

import java.util.Date;

public class GiaoDichNha extends GiaoDich{
    private String loaiNha;
    private String diaChi;

    public GiaoDichNha(String diaChi, String loaiNha, double dienTich, double donGia, Date ngayGiaoDich, String loaiGD) {
        super(dienTich, donGia, ngayGiaoDich, "Nha");
        this.diaChi = diaChi;
        this.loaiNha = loaiNha;
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

    @Override
    public int tinhTongSoLuong(){
        return 0;
    }
}
