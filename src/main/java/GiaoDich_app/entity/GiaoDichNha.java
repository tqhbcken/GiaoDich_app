package GiaoDich_app.entity;

import java.util.Date;

public class GiaoDichNha extends GiaoDich{
    
    private String loaiNha;
    private String diaChi;

    public GiaoDichNha(String diaChi, String loaiNha, double dienTich, double donGia, Date ngayGiaoDich) {
        super(dienTich, donGia, ngayGiaoDich, "Nha");
        this.diaChi = diaChi;
        this.loaiNha = loaiNha;
    }

    
    

    @Override
    public double tinhThanhTien() {
        double thanhTien = 0;

        // Kiểm tra các thuộc tính trước khi sử dụng
        if (loaiNha == null) {
            throw new IllegalArgumentException("loaiNha cannot be null");
        }
        
        // Tính toán giá trị thanh toán dựa trên loaiNha
        switch (loaiNha) {
            case "Vip":
                thanhTien = getDienTich() * getDonGia() * 2; // Ví dụ: Loại 1 có giá gấp 2
                break;
            case "Normal":
                thanhTien = getDienTich() * getDonGia();
                break;
            default:
                thanhTien = 0; // Trường hợp không hợp lệ
                break;
        }

        return thanhTien;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }


}
