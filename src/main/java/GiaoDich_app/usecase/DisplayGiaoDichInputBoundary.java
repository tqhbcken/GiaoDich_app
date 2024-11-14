package GiaoDich_app.usecase;

import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.usecase.dto.DisplayGiaoDichInputDTO;
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;

import java.util.List;

public interface DisplayGiaoDichInputBoundary {
    void execute(DisplayGiaoDichInputDTO input);
}
