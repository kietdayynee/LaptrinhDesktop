package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_Student extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;
    private JTextField textFieldFullName;
    private JTextField textFieldBirthday;
    private JTextField textFieldGender;
    private JTextField textFieldPhoneNumber;

    public Update_Student() {
        setTitle("Update Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(6, 2, 0, 10));

        JLabel lblId = new JLabel("Student ID:");
        panel.add(lblId);

        textFieldId = new JTextField();
        panel.add(textFieldId);
        textFieldId.setColumns(10);

        JLabel lblFullName = new JLabel("Full Name:");
        panel.add(lblFullName);

        textFieldFullName = new JTextField();
        panel.add(textFieldFullName);
        textFieldFullName.setColumns(10);

        JLabel lblBirthday = new JLabel("Birthday:");
        panel.add(lblBirthday);

        textFieldBirthday = new JTextField();
        panel.add(textFieldBirthday);
        textFieldBirthday.setColumns(10);

        JLabel lblGender = new JLabel("Gender:");
        panel.add(lblGender);

        textFieldGender = new JTextField();
        panel.add(textFieldGender);
        textFieldGender.setColumns(10);

        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        panel.add(lblPhoneNumber);

        textFieldPhoneNumber = new JTextField();
        panel.add(textFieldPhoneNumber);
        textFieldPhoneNumber.setColumns(10);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Thực hiện chức năng cập nhật sinh viên ở đây
                updateStudent();
            }
        });
        panel.add(btnUpdate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnCancel);
    }

    private void updateStudent() {
        try {
            // Kết nối cơ sở dữ liệu sử dụng lớp conn_DB
            Connection connection = conn_DB.getConnection();

            // Thực hiện truy vấn cập nhật sinh viên
            String query = "UPDATE student SET name = ?, birthday = ?, gender = ?, phonenumber = ? WHERE StudentID = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Lấy thông tin từ các trường nhập liệu
            int idStudent = Integer.parseInt(textFieldId.getText());
            String fullName = textFieldFullName.getText();
            String birthday = textFieldBirthday.getText();
            String gender = textFieldGender.getText();
            String phoneNumber = textFieldPhoneNumber.getText();

            // Đặt các tham số cho truy vấn
            statement.setString(1, fullName);
            statement.setString(2, birthday);
            statement.setString(3, gender);
            statement.setString(4, phoneNumber);
            statement.setInt(5, idStudent);

            // Thực hiện cập nhật
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Student updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update student. Please check the ID.");
            }

            // Đóng các tài nguyên
            statement.close();
            connection.close();
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
