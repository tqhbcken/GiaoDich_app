package GiaoDich_app.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import GiaoDich_app.entity.GiaoDich;
import GiaoDich_app.entity.GiaoDichDat;
import GiaoDich_app.entity.GiaoDichNha;
import GiaoDich_app.usecase.AddGiaoDichDatabaseBoundary;




public class AddGiaoDichDAODB implements AddGiaoDichDatabaseBoundary {

    private Connection connection;

    public AddGiaoDichDAODB(Connection connection) {
        this.connection = connection;
    }

    @Override
public int addGiaoDich(GiaoDich giaoDich) {
    int maGiaoDich = -1;
    String queryGiaoDich = "INSERT INTO GiaoDich (ngayGiaoDich, dienTich, donGia, loaiGD) VALUES (?, ?, ?, ?)";
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        conn = connection;
        conn.setAutoCommit(false);
        
        // Insert vào bảng GiaoDich
        ps = conn.prepareStatement(queryGiaoDich, Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1, new java.sql.Date(giaoDich.getNgayGiaoDich().getTime()));
        ps.setDouble(2, giaoDich.getDienTich());
        ps.setDouble(3, giaoDich.getDonGia());
        ps.setString(4, giaoDich.getLoaiGD());
        
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                maGiaoDich = rs.getInt(1);
                
                // Insert vào bảng chi tiết tương ứng
                if (giaoDich instanceof GiaoDichDat) {
                    String queryDat = "INSERT INTO GiaoDichDat (maGiaoDich, loaiDat) VALUES (?, ?)";
                    ps = conn.prepareStatement(queryDat);
                    ps.setInt(1, maGiaoDich);
                    ps.setString(2, ((GiaoDichDat) giaoDich).getLoaiDat());
                    ps.executeUpdate();
                } else if (giaoDich instanceof GiaoDichNha) {
                    String queryNha = "INSERT INTO GiaoDichNha (maGiaoDich, diaChi, loaiNha) VALUES (?, ?, ?)";
                    ps = conn.prepareStatement(queryNha);
                    ps.setInt(1, maGiaoDich);
                    ps.setString(2, ((GiaoDichNha) giaoDich).getDiaChi());
                    ps.setString(3, ((GiaoDichNha) giaoDich).getLoaiNha());
                    ps.executeUpdate();
                }
                
                conn.commit();
            }
        }
    } catch (SQLException e) {
        try {
            if (conn != null) conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    return maGiaoDich;
}

@Override
public GiaoDich findGiaoDichById(int id) {
    GiaoDich giaoDich = null;
    String queryDat = "SELECT g.*, gd.loaiDat FROM GiaoDich g " +
                     "LEFT JOIN GiaoDichDat gd ON g.maGiaoDich = gd.maGiaoDich " +
                     "WHERE g.maGiaoDich = ?";
                     
    String queryNha = "SELECT g.*, gn.loaiNha, gn.diaChi FROM GiaoDich g " +
                     "LEFT JOIN GiaoDichNha gn ON g.maGiaoDich = gn.maGiaoDich " +
                     "WHERE g.maGiaoDich = ?";
                     
    try (PreparedStatement psDat = connection.prepareStatement(queryDat);
         PreparedStatement psNha = connection.prepareStatement(queryNha)) {
        
        psDat.setInt(1, id);
        psNha.setInt(1, id);
        
        ResultSet rsDat = psDat.executeQuery();
        ResultSet rsNha = psNha.executeQuery();
        
        if (rsDat.next()) {
            Date ngayGiaoDich = rsDat.getDate("ngayGiaoDich");
            double dienTich = rsDat.getDouble("dienTich");
            double donGia = rsDat.getDouble("donGia");
            String loaiGD = rsDat.getString("loaiGD");
            
            if ("Dat".equals(loaiGD)) {
                String loaiDat = rsDat.getString("loaiDat");
                giaoDich = new GiaoDichDat(dienTich, donGia, ngayGiaoDich, loaiDat);
                giaoDich.maGiaoDich = id;
            }
        }
        
        if (rsNha.next()) {
            Date ngayGiaoDich = rsNha.getDate("ngayGiaoDich");
            double dienTich = rsNha.getDouble("dienTich");
            double donGia = rsNha.getDouble("donGia");
            String loaiGD = rsNha.getString("loaiGD");
            
            if ("Nha".equals(loaiGD)) {
                String loaiNha = rsNha.getString("loaiNha");
                String diaChi = rsNha.getString("diaChi");
                giaoDich = new GiaoDichNha(diaChi, loaiNha, dienTich, donGia, ngayGiaoDich);
                giaoDich.maGiaoDich = id;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return giaoDich;
}
}
