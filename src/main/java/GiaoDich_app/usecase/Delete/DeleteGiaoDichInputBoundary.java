package GiaoDich_app.usecase.Delete;

import GiaoDich_app.usecase.Delete.dto.DeleteGiaoDichInputDTO;
import GiaoDich_app.usecase.Delete.dto.DeleteGiaoDichOutputDTO;

public interface DeleteGiaoDichInputBoundary {
    DeleteGiaoDichOutputDTO execute(DeleteGiaoDichInputDTO input);
}
