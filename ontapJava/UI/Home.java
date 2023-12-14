package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String DatabaseHelper = null;
	private JPanel contentPane;
	 private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setTitle("TRANG CHỦ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btnHome);
		
		
		JButton btnInsert = new JButton("Insert Student");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btnInsert);
		
		JButton btnShow = new JButton("Show Student");
		btnShow.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btnShow);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btnDelete);
		
		JLabel lblHome = new JLabel("HELLO!");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblHome, BorderLayout.CENTER);
		
		btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị giao diện cập nhật sinh viên (cần thêm giao diện nhập liệu)
                Update_Student updateStudentFrame = new Update_Student();
                updateStudentFrame.setVisible(true);

                updateStudentFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // Cập nhật hiển thị sau khi cập nhật sinh viên
                        showAllStudents();
                        setVisible(true);
                    }
                });
            }
        });
		btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị giao diện xóa sinh viên (cần thêm giao diện nhập liệu)
                Delete_Student deleteStudentFrame = new Delete_Student();
                deleteStudentFrame.setVisible(true);

                deleteStudentFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // Cập nhật hiển thị sau khi xóa sinh viên
                        showAllStudents();
                        setVisible(true);
                    }
                });
            }
        });
    

		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Insert_Student insertStudentFrame = new Insert_Student();
				insertStudentFrame.setVisible(true);
				
			insertStudentFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					setVisible(true);
				}
			});
			}
			
		});
		
    lblData = new JLabel();
    contentPane.add(lblData, BorderLayout.CENTER);

    btnShow.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Gọi phương thức để hiển thị dữ liệu từ cơ sở dữ liệu
            showAllStudents();
        }
    });
}

private void showAllStudents() {
    try {
        // Kết nối cơ sở dữ liệu sử dụng lớp conn_DB
        Connection connection = conn_DB.getConnection();

        // Thực hiện truy vấn để lấy tất cả sinh viên
        String query = "SELECT * FROM student";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        // Hiển thị kết quả trong JLabel
        StringBuilder data = new StringBuilder("<html>");
        while (resultSet.next()) {
            int idStudent = resultSet.getInt("StudentID");
            String fullName = resultSet.getString("name");
            java.sql.Date birthday = resultSet.getDate("birthday");
            String gender = resultSet.getString("gender");
            int phoneNumber = resultSet.getInt("phonenumber");

            // Thêm thông tin sinh viên vào StringBuilder
            data.append(idStudent).append(", ").append(fullName).append(", ").append(birthday).append(", ").append(gender).append(", ").append(phoneNumber).append("<br>");
        }
        data.append("</html>");

        // Cập nhật nội dung của JLabel
        lblData.setText(data.toString());

        // Đóng các tài nguyên
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}



}
