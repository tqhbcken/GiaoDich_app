package GiaoDich_app.usecase;

import java.util.List;

import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;

public class DisplayGiaoDichUseCase {
    private final DisplayGiaoDichDatabaseBoundary databaseBoundary;
    private final DisplayGiaoDichOutputBoundary outputBoundary;

    public DisplayGiaoDichUseCase(DisplayGiaoDichDatabaseBoundary databaseBoundary, DisplayGiaoDichOutputBoundary outputBoundary) {
        this.databaseBoundary = databaseBoundary;
        this.outputBoundary = outputBoundary;
    }

    public void execute() {
        List<DisplayGiaoDichOutputDTO> giaoDichList = databaseBoundary.getAllGiaoDich();
        outputBoundary.present(giaoDichList);
    }
}

