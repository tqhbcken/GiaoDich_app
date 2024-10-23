package GiaoDich_app.usecase;

import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.entity.GiaoDichDat;
import GiaoDich_app.entity.GiaoDichNha;
import GiaoDich_app.usecase.dto.AddGiaoDichInputDTO;
import GiaoDich_app.usecase.dto.AddGiaoDichOutputDTO;

import java.util.Date;

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

    private boolean validateNgayGiaoDich(Date ngayGiaoDich) {
        return false;
    }

    private  boolean validateDonGia(Date donGia) {
        return false;
    }

    private boolean validateDienTich(Date dienTich) {
        return false;
    }
}
