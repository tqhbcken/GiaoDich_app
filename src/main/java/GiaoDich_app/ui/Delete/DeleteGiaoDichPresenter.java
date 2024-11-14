package GiaoDich_app.ui.Delete;

import GiaoDich_app.usecase.Delete.DeleteGiaoDichInputBoundary;
import GiaoDich_app.usecase.Delete.dto.DeleteGiaoDichInputDTO;
import GiaoDich_app.usecase.Delete.dto.DeleteGiaoDichOutputDTO;

public class DeleteGiaoDichPresenter {
    private DeleteGiaoDichView view;
    private DeleteGiaoDichInputBoundary useCase;

    public DeleteGiaoDichPresenter(DeleteGiaoDichView view, DeleteGiaoDichInputBoundary useCase) {
        this.view = view;
        this.useCase = useCase;
    }

    public void deleteGiaoDich(DeleteGiaoDichInputDTO inputDTO) {
        DeleteGiaoDichOutputDTO outputDTO = useCase.execute(inputDTO);
        if (outputDTO.isSuccess()) {
            view.showDeleteResult("Xóa giao dịch thành công!");
        } else {
            view.showDeleteResult("Xóa giao dịch thất bại.");
        }
    }

    public void showDeleteResult(String message) {
        view.showDeleteResult(message);
    }
}