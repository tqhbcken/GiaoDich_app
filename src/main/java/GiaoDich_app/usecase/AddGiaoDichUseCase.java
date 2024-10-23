package GiaoDich_app.usecase;

import java.util.Date;

import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.entity.GiaoDichDat;
import GiaoDich_app.entity.GiaoDichNha;
import GiaoDich_app.usecase.dto.AddGiaoDichInputDTO;
import GiaoDich_app.usecase.dto.AddGiaoDichOutputDTO;

public class AddGiaoDichUseCase implements AddGiaoDichInputBoundary {
    private AddGiaoDichOutputBoundary addGiaoDichOutputBoundary;
    private AddGiaoDichDatabaseBoundary addGiaoDichDatabaseBoundary;

    public AddGiaoDichUseCase(AddGiaoDichOutputBoundary addGiaoDichOutputBoundary,
                              AddGiaoDichDatabaseBoundary addGiaoDichDatabaseBoundary) {
        this.addGiaoDichOutputBoundary = addGiaoDichOutputBoundary;
        this.addGiaoDichDatabaseBoundary = addGiaoDichDatabaseBoundary;
    }

    @Override
    public void execute(AddGiaoDichInputDTO addGiaoDichInputDTO) {
        //validate
        //store dg
        GiaoDich giaodich = null;
        Date ngayGiaoDich = addGiaoDichInputDTO.getNgayGiaoDich();
        double dienTich = addGiaoDichInputDTO.getDienTich();
        double donGia = addGiaoDichInputDTO.getDonGia();

        if(addGiaoDichInputDTO.getLoaiGD().equals("Dat")){
            // Kiểm tra loại đất trước khi tạo đối tượng
            
            giaodich = new GiaoDichDat(dienTich, donGia, ngayGiaoDich, addGiaoDichInputDTO.getLoaiDat());
        }else {
            giaodich = new GiaoDichNha(addGiaoDichInputDTO.getDiaChi(), addGiaoDichInputDTO.getLoaiNha(), dienTich, donGia, ngayGiaoDich);
        }

        //them vao db
        int addedGiaoDichId = addGiaoDichDatabaseBoundary.addGiaoDich(giaodich);

        //tim theo id
        GiaoDich addedGiaoDich = addGiaoDichDatabaseBoundary.findGiaoDichById(addedGiaoDichId);

        AddGiaoDichOutputDTO addGiaoDichOutputDTO = new AddGiaoDichOutputDTO(
                addedGiaoDich.getMaGiaoDich(), addedGiaoDich.getNgayGiaoDich(), addedGiaoDich.getDonGia(),
                addedGiaoDich.getDienTich(), addedGiaoDich.tinhThanhTien(), addedGiaoDich.tinhTongSoLuongGD()
        );

        addGiaoDichOutputBoundary.present(addGiaoDichOutputDTO);
    }

    private boolean validateGiaoDichType(AddGiaoDichInputDTO dto) {
        return dto.getLoaiGD().equals("Dat") || dto.getLoaiGD().equals("Nha");
    }

    private boolean validateLoaiDat(AddGiaoDichInputDTO dto) {
        return dto.getLoaiGD().equals("Dat") && validateLoaiDatType(dto);
    }
    
    private boolean validateLoaiDatType(AddGiaoDichInputDTO dto) {
        return dto.getLoaiDat().equals("A") || dto.getLoaiDat().equals("B") || dto.getLoaiDat().equals("C");
    }

    private boolean validateInput(AddGiaoDichInputDTO dto) {
        return validateNgayGiaoDich(dto.getNgayGiaoDich()) &&
               validateDonGia(dto.getDonGia()) &&
               validateDienTich(dto.getDienTich());
    }

    private boolean validateNgayGiaoDich(Date ngayGiaoDich) {
        // Kiểm tra xem ngày giao dịch có hợp lệ hay không
        return ngayGiaoDich != null && !ngayGiaoDich.after(new Date());
    }

    private boolean validateDonGia(double donGia) {
        // Kiểm tra xem đơn giá có hợp lệ hay không
        return donGia > 0;
    }

    private boolean validateDienTich(double dienTich) {
        // Kiểm tra xem diện tích có hợp lệ hay không
        return dienTich > 0;
    }
}
