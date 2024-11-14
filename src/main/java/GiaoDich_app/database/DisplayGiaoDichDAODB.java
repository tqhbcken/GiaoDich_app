package GiaoDich_app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import GiaoDich_app.database.DBConnector.DatabaseConnector;
import GiaoDich_app.usecase.DisplayGiaoDichDatabaseBoundary;
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;  // Import DatabaseConnector

public class DisplayGiaoDichDAODB implements DisplayGiaoDichDatabaseBoundary {
    private final Connection connection;

    public DisplayGiaoDichDAODB() {
        // Sử dụng DatabaseConnector để lấy kết nối
        this.connection = DatabaseConnector.getConnection();
    }

    @Override
    public List<DisplayGiaoDichOutputDTO> getAllGiaoDich() {
        List<DisplayGiaoDichOutputDTO> giaoDichList = new ArrayList<>();
        String query = "SELECT gd.maGiaoDich, gd.ngayGiaoDich, gd.donGia, gd.dienTich, gd.loaiGD FROM GiaoDich gd";
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
                
            while (rs.next()) {
                DisplayGiaoDichOutputDTO dto = new DisplayGiaoDichOutputDTO();
                dto.setMaGiaoDich(rs.getInt("maGiaoDich"));
                dto.setNgayGiaoDich(rs.getDate("ngayGiaoDich"));
                dto.setDonGia(rs.getDouble("donGia"));
                dto.setDienTich(rs.getDouble("dienTich"));
                
                String loaiGD = rs.getString("loaiGD");
                if ("Dat".equals(loaiGD)) {
                    loadGiaoDichDatDetails(dto);
                } else if ("Nha".equals(loaiGD)) {
                    loadGiaoDichNhaDetails(dto);
                }
                
                giaoDichList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading giao dich data", e);
        }
        
        return giaoDichList;
    }

    private void loadGiaoDichDatDetails(DisplayGiaoDichOutputDTO dto) throws SQLException {
        String query = "SELECT loaiDat FROM GiaoDichDat WHERE maGiaoDich = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getMaGiaoDich());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dto.setLoaiGiaoDich("Đất");
                    dto.setLoaiDat(rs.getString("loaiDat"));
                }
            }
        }
    }

    private void loadGiaoDichNhaDetails(DisplayGiaoDichOutputDTO dto) throws SQLException {
        String query = "SELECT diaChi, loaiNha FROM GiaoDichNha WHERE maGiaoDich = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getMaGiaoDich());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dto.setLoaiGiaoDich("Nhà");
                    dto.setLoaiNha(rs.getString("loaiNha"));
                    dto.setDiaChi(rs.getString("diaChi"));
                }
            }
        }
    }
}
