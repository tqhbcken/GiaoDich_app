package GiaoDich_app.usecase;

import java.util.List;

import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;

public interface DisplayGiaoDichDatabaseBoundary {
    List<DisplayGiaoDichOutputDTO> getAllGiaoDich();
}
