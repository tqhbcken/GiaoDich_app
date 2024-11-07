package GiaoDich_app.usecase;

import java.util.Date;

import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.entity.GiaoDichDat;
import GiaoDich_app.entity.GiaoDichNha;
import GiaoDich_app.usecase.dto.AddGiaoDichInputDTO;
import GiaoDich_app.usecase.dto.AddGiaoDichOutputDTO;

public class AddGiaoDichUseCase implements AddGiaoDichInputBoundary {

    private AddGiaoDichOutputBoundary addGiaoDichOutputBoundary = null;
    private AddGiaoDichDatabaseBoundary addGiaoDichDatabaseBoundary = null;

    public AddGiaoDichUseCase(AddGiaoDichOutputBoundary addGiaoDichOutputBoundary,
            AddGiaoDichDatabaseBoundary addGiaoDichDatabaseBoundary) {
        this.addGiaoDichOutputBoundary = addGiaoDichOutputBoundary;
        this.addGiaoDichDatabaseBoundary = addGiaoDichDatabaseBoundary;
    }

    @Override
    public void execute(AddGiaoDichInputDTO addGiaoDichInputDTO) {
        // Xác thực dữ liệu đầu vào
        if (!validateInput(addGiaoDichInputDTO)) {
            throw new IllegalArgumentException("Invalid input data");
        }

        GiaoDich giaoDich = null;
        Date ngayGiaoDich = addGiaoDichInputDTO.getNgayGiaoDich();
        double dienTich = addGiaoDichInputDTO.getDienTich();
        double donGia = addGiaoDichInputDTO.getDonGia();

        if ("Dat".equals(addGiaoDichInputDTO.getLoaiGD())) {
            giaoDich = new GiaoDichDat(dienTich, donGia, ngayGiaoDich, addGiaoDichInputDTO.getLoaiDat());
        } else if ("Nha".equals(addGiaoDichInputDTO.getLoaiGD())) {
            giaoDich = new GiaoDichNha(addGiaoDichInputDTO.getDiaChi(), addGiaoDichInputDTO.getLoaiNha(), dienTich, donGia, ngayGiaoDich);
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        // Thêm vào cơ sở dữ liệu
        int addedGiaoDichId = addGiaoDichDatabaseBoundary.addGiaoDich(giaoDich);

        // Tìm theo ID
        GiaoDich addedGiaoDich = addGiaoDichDatabaseBoundary.findGiaoDichById(addedGiaoDichId);

        AddGiaoDichOutputDTO addGiaoDichOutputDTO = new AddGiaoDichOutputDTO(
                addedGiaoDich.getMaGiaoDich(), addedGiaoDich.getNgayGiaoDich(), addedGiaoDich.getDonGia(),
                addedGiaoDich.getDienTich(), addedGiaoDich.tinhThanhTien(), addedGiaoDich.tinhTongSoLuongGD(),
                addedGiaoDich.getLoaiGD()
        );

        addGiaoDichOutputBoundary.present(addGiaoDichOutputDTO);
    }

    private boolean validateInput(AddGiaoDichInputDTO dto) {
        boolean isValid = dto.getNgayGiaoDich() != null &&
                          dto.getDonGia() > 0 &&
                          dto.getDienTich() > 0;

        if ("Dat".equals(dto.getLoaiGD())) {
            isValid = isValid && dto.getLoaiDat() != null;
        } else if ("Nha".equals(dto.getLoaiGD())) {
            isValid = isValid && dto.getLoaiNha() != null;
        }

        return isValid;
    }
}
