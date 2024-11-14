package GiaoDich_app.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import GiaoDich_app.database.DBConnector.DatabaseConnector;

public class DeleteGiaoDichDAODB {
    public boolean deleteGiaoDich(String maGiaoDich) {
        String sql = "DELETE FROM giao_dich WHERE ma_giao_dich = ?";
        
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, maGiaoDich);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
