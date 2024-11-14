package GiaoDich_app.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import GiaoDich_app.database.AddGiaoDichDAODB;
import GiaoDich_app.database.DBConnector.DatabaseConnector;
import GiaoDich_app.usecase.AddGiaoDichUseCase;
import GiaoDich_app.usecase.dto.AddGiaoDichInputDTO;

public class AddGiaoDichView extends JFrame {

    private JTextField diaChiField, ngayGiaoDichField, dienTichField, donGiaField;
    private JComboBox<String> loaiGDComboBox, loaiDatComboBox, loaiNhaComboBox;
    private JButton addButton, resetButton;
    private JPanel datPanel, nhaPanel, dynamicPanel;
    private AddGiaoDichController controller = null;

    public AddGiaoDichView() {
        
        setTitle("Giao Dịch Bất Động Sản");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null); // Center the window on the screen
        initializeComponents();
        configureLayout();
        attachListeners();
    }

    private void initializeComponents() {
        diaChiField = new JTextField(15);
        ngayGiaoDichField = new JTextField(15);
        dienTichField = new JTextField(15);
        donGiaField = new JTextField(15);

        loaiGDComboBox = new JComboBox<>(new String[]{"Chọn loại giao dịch", "Dat", "Nha"});
        loaiDatComboBox = new JComboBox<>(new String[]{"Chọn loại đất", "A", "B", "C"});
        loaiNhaComboBox = new JComboBox<>(new String[]{"Chọn loại nhà", "CaoCap", "Thuong"});

        addButton = new JButton("Thêm Giao Dịch");
        resetButton = new JButton("Reset");

        // Tooltips
        diaChiField.setToolTipText("Nhập địa chỉ bất động sản");
        ngayGiaoDichField.setToolTipText("Nhập ngày giao dịch (dd/MM/yyyy)");
        dienTichField.setToolTipText("Nhập diện tích bất động sản");
        donGiaField.setToolTipText("Nhập đơn giá bất động sản");

        loaiGDComboBox.setSelectedIndex(0); // Default to "Chọn loại giao dịch"
    }

    private void configureLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Common fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Thông Tin Giao Dịch"), gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Ngày Giao Dịch (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1;
        add(ngayGiaoDichField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Diện Tích:"), gbc);
        gbc.gridx = 1;
        add(dienTichField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Đơn Giá:"), gbc);
        gbc.gridx = 1;
        add(donGiaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Loại Giao Dịch:"), gbc);
        gbc.gridx = 1;
        add(loaiGDComboBox, gbc);

        // Dynamic panel for Land and House
        dynamicPanel = new JPanel(new CardLayout());
        configureMajorPanels();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(dynamicPanel, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(resetButton);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
    }

    private void configureMajorPanels() {
        // Panel for Land Transactions
        datPanel = new JPanel(new GridLayout(2, 2));
        datPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin Đất"));
        datPanel.add(new JLabel("Loại Đất:"));
        datPanel.add(loaiDatComboBox);
    
        // Panel for House Transactions
        nhaPanel = new JPanel(new GridLayout(3, 2));
        nhaPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin Nhà"));
        nhaPanel.add(new JLabel("Loại Nhà:"));
        nhaPanel.add(loaiNhaComboBox);
        nhaPanel.add(new JLabel("Địa Chỉ:")); // Add label for "Địa Chỉ"
        nhaPanel.add(diaChiField); // Add diaChiField to the panel for House
    
        // Add both panels to the dynamic panel
        dynamicPanel.add(datPanel, "Dat");
        dynamicPanel.add(nhaPanel, "Nha");
    
        CardLayout cl = (CardLayout) (dynamicPanel.getLayout());
        cl.show(dynamicPanel, "Dat");
    
        loaiGDComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMajor = (String) loaiGDComboBox.getSelectedItem();
                if (selectedMajor.equals("Dat")) {
                    cl.show(dynamicPanel, "Dat");
                    diaChiField.setEnabled(false); // Disable diaChiField for "Dat"
                } else {
                    cl.show(dynamicPanel, "Nha");
                    diaChiField.setEnabled(true); // Enable diaChiField for "Nha"
                }
            }
        });
    }
    

    private void handleAddGiaoDich() throws NumberFormatException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayGiaoDich = dateFormat.parse(ngayGiaoDichField.getText());
        double dienTich = Double.parseDouble(dienTichField.getText());
        double donGia = Double.parseDouble(donGiaField.getText());
        String loaiGD = (String) loaiGDComboBox.getSelectedItem();
    
        if ("Dat".equals(loaiGD)) {
            String loaiDat = (String) loaiDatComboBox.getSelectedItem();
            AddGiaoDichInputDTO addGiaoDichInputDTO = new AddGiaoDichInputDTO(
                ngayGiaoDich, dienTich, donGia, loaiGD, loaiDat
            );
            controller.execute(addGiaoDichInputDTO);
        } else if ("Nha".equals(loaiGD)) {
            String loaiNha = (String) loaiNhaComboBox.getSelectedItem();
            String diaChi = diaChiField.getText();
    
            // Kiểm tra nếu người dùng chưa chọn loại nhà hoặc loại nhà không hợp lệ
            if (!"CaoCap".equals(loaiNha) && !"Thuong".equals(loaiNha)) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn loại nhà hợp lệ (CaoCap hoặc Thuong)!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Kiểm tra nếu trường địa chỉ trống
            if (diaChi == null || diaChi.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            AddGiaoDichInputDTO addGiaoDichInputDTO = new AddGiaoDichInputDTO(
                ngayGiaoDich, dienTich, donGia, loaiGD, loaiNha, diaChi
            );
            controller.execute(addGiaoDichInputDTO);
        }
    
        JOptionPane.showMessageDialog(this, "Giao dịch đã được thêm thành công!");
    }
    
    

    private void attachListeners() {
        addButton.addActionListener(e -> {
            try {
                handleAddGiaoDich();
            } catch (NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(AddGiaoDichView.this, "Có lỗi xảy ra, vui lòng kiểm tra lại dữ liệu!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        resetButton.addActionListener(e -> resetForm());
    }

    private void resetForm() {
        ngayGiaoDichField.setText("");
        dienTichField.setText("");
        donGiaField.setText("");
        loaiGDComboBox.setSelectedIndex(0);
        loaiDatComboBox.setSelectedIndex(0);
        loaiNhaComboBox.setSelectedIndex(0);
        diaChiField.setText("");
        diaChiField.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddGiaoDichView form = new AddGiaoDichView();
            try {
                Connection connection = DatabaseConnector.getConnection();
                AddGiaoDichDAODB addGiaoDichDAODB = new AddGiaoDichDAODB(connection); // Truyền kết nối vào constructor
                AddGiaoDichPresenter addGiaoDichPresenter = new AddGiaoDichPresenter();
                AddGiaoDichUseCase addGiaoDichUseCase = new AddGiaoDichUseCase(addGiaoDichPresenter, addGiaoDichDAODB); // Khởi tạo đúng AddGiaoDichUseCase
                AddGiaoDichController addGiaoDichController = new AddGiaoDichController(addGiaoDichUseCase); // Truyền AddGiaoDichUseCase cho controller
                form.setController(addGiaoDichController);
                form.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Không thể kết nối cơ sở dữ liệu!");
            }
        });
    }  
    public void setController(AddGiaoDichController controller) {
        this.controller = controller;
    }

}
