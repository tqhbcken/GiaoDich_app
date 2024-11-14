package GiaoDich_app.ui.Display;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;  // Đảm bảo import đúng

import GiaoDich_app.database.DBConnector.DatabaseConnector;
import GiaoDich_app.database.DisplayGiaoDichDAODB;
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;

public class DisplayGiaoDichView extends JFrame {
    private DefaultTableModel model;

    public DisplayGiaoDichView() {
        setTitle("Quản lý giao dịch");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"STT", "Mã giao dịch", "Ngày giao dịch", "Đơn giá", "Diện tích", "Loại giao dịch", "Loại đất", "Loại nhà", "Địa chỉ"};
        model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        loadData();  // Gọi hàm để tải dữ liệu từ database
    }

    public void loadData() {
        // Sử dụng DatabaseConnector để lấy kết nối
        DatabaseConnector.connect();
        DisplayGiaoDichDAODB dao = new DisplayGiaoDichDAODB();
        List<DisplayGiaoDichOutputDTO> giaoDichList = dao.getAllGiaoDich();
        updateTable(giaoDichList);
    }

    public void updateTable(List<DisplayGiaoDichOutputDTO> giaoDichList) {
        model.setRowCount(0);  // Xóa dữ liệu cũ
        int stt = 1;
        for (DisplayGiaoDichOutputDTO giaoDich : giaoDichList) {
            model.addRow(new Object[]{
                stt++,
                giaoDich.getMaGiaoDich(),
                giaoDich.getNgayGiaoDich(),
                giaoDich.getDonGia(),
                giaoDich.getDienTich(),
                giaoDich.getLoaiGiaoDich(),
                giaoDich.getLoaiDat() != null ? giaoDich.getLoaiDat() : "",
                giaoDich.getLoaiNha() != null ? giaoDich.getLoaiNha() : "",
                giaoDich.getDiaChi() != null ? giaoDich.getDiaChi() : ""
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DisplayGiaoDichView view = new DisplayGiaoDichView();
            view.setVisible(true);
        });
    }
}
