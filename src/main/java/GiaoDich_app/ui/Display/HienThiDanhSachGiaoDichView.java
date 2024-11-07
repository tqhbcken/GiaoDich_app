package GiaoDich_app.ui.Display;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HienThiDanhSachGiaoDichView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public HienThiDanhSachGiaoDichView() {
        // setTitle("Danh Sách Giao Dịch");
        // setSize(800, 400);
        // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // setLocationRelativeTo(null);

        // // Khởi tạo model bảng
        // String[] columnNames = {"Mã Giao Dịch", "Ngày Giao Dịch", "Diện Tích", "Đơn Giá", "Loại Giao Dịch", "Loại Đất/Nhà", "Địa Chỉ"};
        // tableModel = new DefaultTableModel(columnNames, 0);
        // table = new JTable(tableModel);

        // // Thêm bảng vào ScrollPane
        // JScrollPane scrollPane = new JScrollPane(table);
        // add(scrollPane, BorderLayout.CENTER);

        // Lấy dữ liệu từ cơ sở dữ liệu và hiển thị
        loadData();
    }

    private void loadData() {
        // Kết nối và lấy dữ liệu từ cơ sở dữ liệu
    //     try (Connection conn = DBConnector.getConnection()) {
    //         String sql = "SELECT maGiaoDich, ngayGiaoDich, dienTich, donGia, loaiGiaoDich, loaiDat, loaiNha, diaChi " +
    //                      "FROM giaodichdat LEFT JOIN giaodichnha USING(maGiaoDich)";
    //         PreparedStatement statement = conn.prepareStatement(sql);
    //         ResultSet rs = statement.executeQuery();

    //         // Xóa dữ liệu cũ trong bảng
    //         tableModel.setRowCount(0);

    //         // Thêm dữ liệu vào bảng
    //         while (rs.next()) {
    //             int maGiaoDich = rs.getInt("maGiaoDich");
    //             Date ngayGiaoDich = rs.getDate("ngayGiaoDich");
    //             double dienTich = rs.getDouble("dienTich");
    //             double donGia = rs.getDouble("donGia");
    //             String loaiGiaoDich = rs.getString("loaiGiaoDich");
    //             String loaiDat = rs.getString("loaiDat");
    //             String loaiNha = rs.getString("loaiNha");
    //             String diaChi = rs.getString("diaChi");

    //             // Xử lý loại đất/nhà
    //             String loaiDatNha = loaiGiaoDich.equals("Dat") ? loaiDat : loaiNha;

    //             // Thêm một dòng vào model
    //             tableModel.addRow(new Object[]{maGiaoDich, ngayGiaoDich, dienTich, donGia, loaiGiaoDich, loaiDatNha, diaChi});
    //         }
    //     } catch (SQLException e) {
    //         JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    //     }
    // }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         HienThiDanhSachGiaoDichView view = new HienThiDanhSachGiaoDichView();
    //         view.setVisible(true);
    //     });
    }
}

