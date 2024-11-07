package GiaoDich_app.ui;

import java.text.DecimalFormat;

import GiaoDich_app.usecase.AddGiaoDichOutputBoundary;
import GiaoDich_app.usecase.dto.AddGiaoDichOutputDTO;

public class AddGiaoDichPresenter implements AddGiaoDichOutputBoundary {
    
    private AddGiaoDichOutputDTO addGiaoDichOutputDTO = null;
    @Override
    public void present(AddGiaoDichOutputDTO addGiaoDichOutputDTO) {
       this.addGiaoDichOutputDTO = addGiaoDichOutputDTO;
       testPrint(addGiaoDichOutputDTO);
    }

    public AddGiaoDichOutputDTO getGiaoDichOutputDTO(){
        return addGiaoDichOutputDTO;
    }

    private void testPrint(AddGiaoDichOutputDTO addGiaoDichOutputDTO) {
        DecimalFormat df = new DecimalFormat("#,###.00"); 
    System.out.println("Loai giao dich: " + addGiaoDichOutputDTO.getLoaiGD());
    System.out.println("Thanh tien: " + df.format(addGiaoDichOutputDTO.getThanhTien()));
    System.out.println("Tong so luong giao dich: " + addGiaoDichOutputDTO.getTongSoLuongGD());
    }
}
