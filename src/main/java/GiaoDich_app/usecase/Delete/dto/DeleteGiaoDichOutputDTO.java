package GiaoDich_app.usecase.Delete.dto;

public class DeleteGiaoDichOutputDTO {
    private boolean success;

    public DeleteGiaoDichOutputDTO(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
