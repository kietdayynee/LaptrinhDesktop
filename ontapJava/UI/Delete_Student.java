package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_Student extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;

    public Delete_Student() {
        setTitle("Delete Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 150);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2, 2, 0, 10));

        JLabel lblId = new JLabel("Student ID:");
        panel.add(lblId);

        textFieldId = new JTextField();
        panel.add(textFieldId);
        textFieldId.setColumns(10);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Thực hiện chức năng xóa sinh viên ở đây
                deleteStudent();
            }
        });
        panel.add(btnDelete);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnCancel);
    }

    private void deleteStudent() {
        try {
            // Kết nối cơ sở dữ liệu sử dụng lớp conn_DB
            Connection connection = conn_DB.getConnection();

            // Thực hiện truy vấn xóa sinh viên
            String query = "DELETE FROM student WHERE StudentID = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Lấy ID từ trường nhập liệu
            int idStudent = Integer.parseInt(textFieldId.getText());

            // Đặt tham số cho truy vấn
            statement.setInt(1, idStudent);

            // Thực hiện xóa
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Student deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete student. Please check the ID.");
            }
            statement.close();
            connection.close();
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
