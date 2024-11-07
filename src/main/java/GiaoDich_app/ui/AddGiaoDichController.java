package GiaoDich_app.ui;

import GiaoDich_app.usecase.AddGiaoDichInputBoundary;
import GiaoDich_app.usecase.dto.AddGiaoDichInputDTO;

public class AddGiaoDichController {
    
    private AddGiaoDichInputBoundary addGiaoDichInputBoundary = null;

    public AddGiaoDichController(AddGiaoDichInputBoundary addGiaoDichInputBoundary){
        this.addGiaoDichInputBoundary = addGiaoDichInputBoundary;

    }

    public void execute (AddGiaoDichInputDTO addGiaoDichInputDTO){
        addGiaoDichInputBoundary.execute(addGiaoDichInputDTO);
    }
}
