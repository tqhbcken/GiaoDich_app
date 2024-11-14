package GiaoDich_app.usecase.Delete.dto;

public class DeleteGiaoDichInputDTO {
    private String maGiaoDich;

    public DeleteGiaoDichInputDTO(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }
}
