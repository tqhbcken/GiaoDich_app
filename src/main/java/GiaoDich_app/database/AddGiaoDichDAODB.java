package GiaoDich_app.database;

import java.util.HashMap;
import java.util.Map;

import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.usecase.AddGiaoDichDatabaseBoundary;

public class AddGiaoDichDAODB implements AddGiaoDichDatabaseBoundary{
    private Map<Integer, GiaoDich> mockDatabase = new HashMap<>();
    private int currentGiaoDichId = 0;
    @Override
    public int addGiaoDich(GiaoDich giaodich){
        mockDatabase.put(++currentGiaoDichId,giaodich);
        return currentGiaoDichId;
    }
    @Override
    public GiaoDich findGiaoDichById(int giaoDichId) {
        // TODO Auto-generated method stub
        GiaoDich giaodich = null;
        giaodich = mockDatabase.get(giaoDichId);
        return giaodich;
        
    }

}
