package GiaoDich_app.ui.Delete;

import GiaoDich_app.usecase.Delete.dto.DeleteGiaoDichInputDTO;

public class DeleteGiaoDichController {
    private DeleteGiaoDichPresenter presenter;

    public DeleteGiaoDichController(DeleteGiaoDichPresenter presenter) {
        this.presenter = presenter;
    }

    public void onDeleteButtonClicked(String maGiaoDich) {
        if (maGiaoDich.isEmpty()) {
            presenter.showDeleteResult("Mã giao dịch không được để trống!");
        } else {
            DeleteGiaoDichInputDTO inputDTO = new DeleteGiaoDichInputDTO(maGiaoDich);
            presenter.deleteGiaoDich(inputDTO); // Gọi presenter để xử lý xóa
        }
    }
}
