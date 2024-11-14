package GiaoDich_app.ui.MainMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import GiaoDich_app.database.DisplayGiaoDichDAODB;
import GiaoDich_app.ui.AddGiaoDichController;
import GiaoDich_app.ui.AddGiaoDichView;
import GiaoDich_app.ui.Delete.DeleteGiaoDichView;
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;

public class MainMenu extends JFrame {
    private JTable giaoDichTable;
    private DefaultTableModel tableModel;  // Sử dụng DefaultTableModel để quản lý dữ liệu trong JTable
    private JButton btnAdd, btnEdit, btnDelete, btnSearch, btnTotalCount, btnAverage, btnFilterByMonth, btnViewTransactions;

    public MainMenu() {
        setTitle("Quản lý Giao dịch Nhà đất");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Đặt cửa sổ vào giữa màn hình

        // Tạo layout chính
        setLayout(new BorderLayout());

        // Tạo bảng hiển thị giao dịch
        String[] columns = {"Mã giao dịch", "Ngày giao dịch", "Đơn giá", "Loại giao dịch", "Diện tích", "Thành tiền"};
        tableModel = new DefaultTableModel(columns, 0);  // Sử dụng DefaultTableModel để quản lý dữ liệu
        giaoDichTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(giaoDichTable);
        add(scrollPane, BorderLayout.CENTER);

        // Tạo các nút chức năng
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());

        btnAdd = new JButton("Thêm Giao dịch");
        btnEdit = new JButton("Sửa Giao dịch");
        btnDelete = new JButton("Xóa Giao dịch");
        btnSearch = new JButton("Tìm kiếm Giao dịch");
        btnTotalCount = new JButton("Tổng Số lượng theo Loại");
        btnAverage = new JButton("Trung bình Thành tiền Đất");
        btnFilterByMonth = new JButton("Lọc Giao dịch theo Tháng");
        btnViewTransactions = new JButton("Xem Giao dịch");

        // Thêm các nút vào panel
        panelButtons.add(btnAdd);
        panelButtons.add(btnEdit);
        panelButtons.add(btnDelete);
        panelButtons.add(btnSearch);
        panelButtons.add(btnTotalCount);
        panelButtons.add(btnAverage);
        panelButtons.add(btnFilterByMonth);
        panelButtons.add(btnViewTransactions);

        // Đặt panel chứa nút ở dưới cửa sổ
        add(panelButtons, BorderLayout.SOUTH);

        // Xử lý sự kiện cho các nút
        btnAdd.addActionListener(e -> openAddDialog());
        btnEdit.addActionListener(e -> openEditDialog());
        btnDelete.addActionListener(e -> deleteSelectedTransaction());
        btnSearch.addActionListener(e -> openSearchDialog());
        btnTotalCount.addActionListener(e -> showTotalCount());
        btnAverage.addActionListener(e -> showAveragePrice());
        btnFilterByMonth.addActionListener(e -> filterByMonth());
        
        // Xử lý sự kiện cho nút "Xem Giao dịch"
        btnViewTransactions.addActionListener(e -> openDisplayGiaoDichView());

        // Hiển thị giao diện
        setVisible(true);

        // Lấy dữ liệu từ DB và cập nhật bảng
        loadDataFromDatabase();
    }

    // Phương thức lấy dữ liệu từ database và cập nhật bảng
    private void loadDataFromDatabase() {
        DisplayGiaoDichDAODB dao = new DisplayGiaoDichDAODB();
        List<DisplayGiaoDichOutputDTO> giaoDichList = dao.getAllGiaoDich(); // Lấy tất cả giao dịch từ DB
        updateTable(giaoDichList); // Cập nhật bảng
    }

    // Phương thức cập nhật bảng giao dịch
    private void updateTable(List<DisplayGiaoDichOutputDTO> giaoDichList) {
        tableModel.setRowCount(0); // Xóa tất cả dữ liệu trong bảng
        for (DisplayGiaoDichOutputDTO giaoDich : giaoDichList) {
            tableModel.addRow(new Object[]{
                giaoDich.getMaGiaoDich(),
                giaoDich.getNgayGiaoDich(),
                giaoDich.getDonGia(),
                giaoDich.getLoaiGiaoDich(),
                giaoDich.getDienTich(),
                // giaoDich.getThanhTien()
            });
        }
    }

    // Các phương thức xử lý khác
    private void openDisplayGiaoDichView() {
        JOptionPane.showMessageDialog(this, "Mở cửa sổ hiển thị giao dịch");
       
    }

    private void openAddDialog() {
    AddGiaoDichController controller = new AddGiaoDichController(null);
    AddGiaoDichView addGiaoDichView = new AddGiaoDichView();
    addGiaoDichView.setVisible(true);
        
        
    }

    private void openEditDialog() {
        JOptionPane.showMessageDialog(this, "Mở cửa sổ sửa giao dịch");
    }

    private void deleteSelectedTransaction() {
        int selectedRow = giaoDichTable.getSelectedRow();
        if (selectedRow != -1) {
            DeleteGiaoDichView v = new DeleteGiaoDichView(null);
            JOptionPane.showMessageDialog(this, "Đã xóa giao dịch đã chọn");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một giao dịch để xóa.");
        }
    }

    private void openSearchDialog() {
        JOptionPane.showMessageDialog(this, "Mở cửa sổ tìm kiếm giao dịch");
    }

    private void showTotalCount() {
        JOptionPane.showMessageDialog(this, "Hiển thị tổng số lượng giao dịch theo loại");
    }

    private void showAveragePrice() {
        JOptionPane.showMessageDialog(this, "Hiển thị trung bình thành tiền của giao dịch đất");
    }

    private void filterByMonth() {
        JOptionPane.showMessageDialog(this, "Mở cửa sổ lọc giao dịch theo tháng");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
