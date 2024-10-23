package GiaoDich_app.entity;

import java.util.Date;

public class GiaoDichDat extends GiaoDich {

    private String loaiDat;


    public GiaoDichDat(double dienTich, double donGia, Date ngayGiaoDich, String loaiDat) {
        super(dienTich, donGia, ngayGiaoDich, "Dat");
        this.loaiDat = loaiDat;
    }

    @Override
    public double tinhThanhTien(){
        // Giả sử: đất loại A có hệ số 1.5, đất loại B là 1.2, đất loại C là 1.0
        if (loaiDat.equalsIgnoreCase("A")) {
            return super.getDienTich() * super.getDonGia() * 1.5;
        } else if (loaiDat.equalsIgnoreCase("B") || loaiDat.equalsIgnoreCase("C")) {
            return super.getDienTich() * super.getDonGia() ;       
        } else {
            // Nếu loại đất không hợp lệ, trả về 0
            return 0;
        }
    }
    @Override
    public int tinhTongSoLuongGD() {
      return 0;  
    }
}
