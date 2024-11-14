package GiaoDich_app.usecase.Delete;

import GiaoDich_app.database.DeleteGiaoDichDAODB;
import GiaoDich_app.usecase.Delete.dto.DeleteGiaoDichInputDTO;
import GiaoDich_app.usecase.Delete.dto.DeleteGiaoDichOutputDTO;

public class DeleteGiaoDichUseCase implements DeleteGiaoDichInputBoundary {
    private DeleteGiaoDichDAODB dao;

    public DeleteGiaoDichUseCase(DeleteGiaoDichDAODB dao) {
        this.dao = dao;
    }

    @Override
    public DeleteGiaoDichOutputDTO execute(DeleteGiaoDichInputDTO input) {
        boolean success = dao.deleteGiaoDich(input.getMaGiaoDich());
        return new DeleteGiaoDichOutputDTO(success);
    }
}
