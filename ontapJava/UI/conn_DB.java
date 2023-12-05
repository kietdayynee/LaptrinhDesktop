package UI;
import java.sql.*;
public class conn_DB {
	
	    public static void main(String[] args) throws SQLException {
	        // Tạo một đối tượng `Connection` để kết nối với database
	        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.4:3306/student", "root", "admin1234");

	        // Thực hiện một truy vấn SQL
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

	        // Duyệt qua các hàng trong kết quả truy vấn
	        while (resultSet.next()) {
	            // Lấy giá trị của các cột trong hàng hiện tại
	            int idStudent = resultSet.getInt("idStudent");
	            String fullName = resultSet.getString("fullName");
	            Date birthday = resultSet.getDate("birthday");
	            String gender = resultSet.getString("gender");
	            int phonenumber = resultSet.getInt("phonenumber");

	            // In ra các giá trị của các cột
	            System.out.println(idStudent + ", " + fullName + ", " + birthday + ", " + gender+", "+phonenumber);
	        }

	        // Đóng kết nối với database
	        connection.close();
	    }
	}

