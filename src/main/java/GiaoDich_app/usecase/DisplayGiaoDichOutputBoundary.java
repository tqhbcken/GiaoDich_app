package GiaoDich_app.usecase;

import java.util.List;
import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;



public interface DisplayGiaoDichOutputBoundary {
    void displayGiaoDichList(List<DisplayGiaoDichOutputDTO> giaoDichList);
    void present(List<DisplayGiaoDichOutputDTO> giaoDichList);
    void showError(String errorMessage);
}

