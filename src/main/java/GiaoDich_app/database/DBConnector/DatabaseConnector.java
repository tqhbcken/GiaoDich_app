package GiaoDich_app.database.DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/QuanLyGiaoDichNhaDat";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "15022004";
    private static Connection connection;

    // Phương thức kết nối tới cơ sở dữ liệu
    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("conn Sucess");
            }
        } catch (SQLException e) {
            System.out.println("conn Fail");
            e.printStackTrace();
        }
        return connection;
    }
    
    // Ngắt kết nối với cơ sở dữ liệu
    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Đã ngắt kết nối CSDL.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đóng kết nối CSDL.");
            e.printStackTrace();
        }
    }
    
    // Phương thức getConnection sẽ tự động gọi connect() nếu connection chưa được thiết lập
    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }
}
