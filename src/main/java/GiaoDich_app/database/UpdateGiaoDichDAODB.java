package GiaoDich_app.database;

import java.util.Map;

import GiaoDich_app.entity.GiaoDich;

public class UpdateGiaoDichDAODB {
    private Map<Integer, GiaoDich> mockDatabase;

    public UpdateGiaoDichDAODB(Map<Integer, GiaoDich> mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    public boolean updateGiaoDich(int giaoDichId, GiaoDich updatedGiaoDich) {
        if (mockDatabase.containsKey(giaoDichId)) {
            mockDatabase.put(giaoDichId, updatedGiaoDich);
            return true;
        }
        return false;
    }
}
