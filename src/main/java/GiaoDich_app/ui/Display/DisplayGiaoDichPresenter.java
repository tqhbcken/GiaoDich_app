package GiaoDich_app.ui.Display;

import java.util.List;

import javax.swing.JOptionPane;

import GiaoDich_app.database.DisplayGiaoDichDAODB;
import GiaoDich_app.usecase.DisplayGiaoDichOutputBoundary;  // Lớp DAO dùng để lấy dữ liệu từ database
import GiaoDich_app.usecase.dto.DisplayGiaoDichOutputDTO;

public class DisplayGiaoDichPresenter implements DisplayGiaoDichOutputBoundary {
    private final DisplayGiaoDichView view;
    private final DisplayGiaoDichDAODB dao;  // Lớp DAO dùng để lấy dữ liệu từ DB

    public DisplayGiaoDichPresenter(DisplayGiaoDichView view) {
        this.view = view;
        this.dao = new DisplayGiaoDichDAODB();  // Khởi tạo DAO để lấy dữ liệu từ DB
    }

    public void loadGiaoDichData() {
        // Gọi phương thức lấy dữ liệu từ DAO
        List<DisplayGiaoDichOutputDTO> giaoDichList = dao.getAllGiaoDich();
        // Gọi phương thức present() để xử lý dữ liệu trước khi hiển thị lên View
        present(giaoDichList);
    }

    @Override
    public void displayGiaoDichList(List<DisplayGiaoDichOutputDTO> giaoDichList) {
        // Cập nhật bảng trong View
        view.updateTable(giaoDichList);
    }

    @Override
    public void present(List<DisplayGiaoDichOutputDTO> giaoDichList) {
        // Hiển thị danh sách giao dịch lên view
        displayGiaoDichList(giaoDichList);
    }

    @Override
    public void showError(String errorMessage) {
        // Hiển thị thông báo lỗi lên view (có thể là một popup hoặc một label)
        JOptionPane.showMessageDialog(view, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // Khởi tạo view và presenter
        DisplayGiaoDichView view = new DisplayGiaoDichView();
        DisplayGiaoDichPresenter presenter = new DisplayGiaoDichPresenter(view);
        
        // Hiển thị giao diện và tải dữ liệu
        view.setVisible(true);
        presenter.loadGiaoDichData();
    }
}
