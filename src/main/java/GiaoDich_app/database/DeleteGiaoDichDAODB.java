package GiaoDich_app.database;

import java.util.Map;

import GiaoDich_app.entity.GiaoDich;

public class DeleteGiaoDichDAODB {
    private Map<Integer, GiaoDich> mockDatabase;

    public DeleteGiaoDichDAODB(Map<Integer, GiaoDich> mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    public boolean deleteGiaoDich(int giaoDichId) {
        return mockDatabase.remove(giaoDichId) != null;
    }
}
