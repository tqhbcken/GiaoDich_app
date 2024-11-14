package GiaoDich_app.ui.Delete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteGiaoDichView extends JFrame {
    private JTextField txtMaGiaoDich;
    private JButton btnDelete;
    private DeleteGiaoDichController controller;

    public DeleteGiaoDichView(DeleteGiaoDichController controller) {
        this.controller = controller;
        setTitle("Xóa Giao Dịch");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtMaGiaoDich = new JTextField(20);
        btnDelete = new JButton("Xóa Giao Dịch");

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maGiaoDich = txtMaGiaoDich.getText();
                controller.onDeleteButtonClicked(maGiaoDich); // Gọi controller khi nhấn nút
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Mã Giao Dịch:"));
        panel.add(txtMaGiaoDich);
        panel.add(btnDelete);

        add(panel);
    }

    // Phương thức hiển thị thông báo cho người dùng
    public void showDeleteResult(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
