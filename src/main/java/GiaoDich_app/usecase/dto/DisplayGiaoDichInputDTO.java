package GiaoDich_app.usecase.dto;

public class DisplayGiaoDichInputDTO {
// Các thuộc tính đầu vào nếu cần
    // Ví dụ: nếu bạn muốn lọc theo ngày giao dịch hoặc loại giao dịch

    private String loaiGiaoDich;
    
    // Các getter và setter nếu cần thiết

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    // Constructor mặc định hoặc có tham số nếu cần
    public DisplayGiaoDichInputDTO() {
        // Khởi tạo mặc định nếu cần
    }

    public DisplayGiaoDichInputDTO(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }
}
