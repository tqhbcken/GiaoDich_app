package GiaoDich_app.ui.Display;

import GiaoDich_app.usecase.AddGiaoDichUseCase;
import GiaoDich_app.usecase.DisplayGiaoDichUseCase;
import GiaoDich_app.usecase.dto.AddGiaoDichInputDTO;

public class DisplayGiaoDichController {
    private final AddGiaoDichUseCase addUseCase;
    private final DisplayGiaoDichUseCase displayUseCase;

    public DisplayGiaoDichController(AddGiaoDichUseCase addUseCase, DisplayGiaoDichUseCase displayUseCase) {
        this.addUseCase = addUseCase;
        this.displayUseCase = displayUseCase;
    }

    public void addGiaoDich(AddGiaoDichInputDTO input) {
        addUseCase.execute(input);
        displayUseCase.execute();  // Gọi để hiển thị danh sách cập nhật
    }
}

