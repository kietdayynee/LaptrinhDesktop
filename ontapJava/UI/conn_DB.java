package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn_DB {

    public static Connection getConnection() {
        try {
            // Đăng ký driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Thay đổi thông tin kết nối cho phù hợp với cấu hình của bạn
            String url = "jdbc:mysql://192.168.1.177:3306/ontap";
            String user = "ontapuser2";
            String password = "admin1234";

            // Tạo và trả về đối tượng Connection
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi kết nối và trả về null hoặc thực hiện các bước khác cần thiết
            return null;
        }
    }

    // Các phương thức khác nếu cần
}
