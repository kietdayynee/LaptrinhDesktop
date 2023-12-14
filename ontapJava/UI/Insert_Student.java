package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class Insert_Student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Student frame = new Insert_Student();
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
	public Insert_Student() {
		setFont(new Font("Times New Roman", Font.BOLD, 20));
		setTitle("INSERT STUDENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Input Values");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{140, 269, 0};
		gbl_panel.rowHeights = new int[]{19, 31, 0, 0, 27, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblBirth = new JLabel("Birthday");
		lblBirth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBirth = new GridBagConstraints();
		gbc_lblBirth.fill = GridBagConstraints.VERTICAL;
		gbc_lblBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirth.gridx = 0;
		gbc_lblBirth.gridy = 1;
		panel.add(lblBirth, gbc_lblBirth);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 1;
		panel.add(dateChooser, gbc_dateChooser);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 2;
		panel.add(lblGender, gbc_lblGender);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		
		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 3;
		panel.add(lblPhone, gbc_lblPhone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel.add(textField_3, gbc_textField_3);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("Times New Roman", Font.BOLD, 13));
		panel_1.add(btnCancle);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Times New Roman", Font.BOLD, 13));
		panel_1.add(btnDone);
		
		
		btnDone.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        insertData();
		    }

		    private void insertData() {
		        String fullName = textField.getText();
		        java.util.Date birthDate = dateChooser.getDate();
		        String gender = textField_2.getText();
		        String phoneNumber = textField_3.getText();

		        // Kiểm tra xem kết nối đã được thiết lập thành công hay không
		        try {
		            Connection connection = conn_DB.getConnection();

		            if (connection != null) {
		                String query = "INSERT INTO student (name, birthday, gender, phonenumber) VALUES (?, ?, ?, ?)";

		                PreparedStatement statement = connection.prepareStatement(query);
		                statement.setString(1, fullName);
		                statement.setDate(2, new java.sql.Date(birthDate.getTime()));
		                statement.setString(3, gender);
		                statement.setString(4, phoneNumber);

		                int rowsInserted = statement.executeUpdate();
		                if (rowsInserted > 0) {
		                    System.out.println("A new student has been inserted!");
		                    
		                }

		                statement.close();
		                connection.close();
		            } else {
		                System.out.println("Connection is null. Cannot insert data.");
		                
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		

				public void actionPerformed1(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
		btnCancle.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Đóng cửa sổ hiện tại
		        dispose();

		        // Mở cửa sổ Home hoặc làm các bước cần thiết để quay về trang Home
		        openHomePage();
		    }

		    private void openHomePage() {
		        // Thực hiện các bước cần thiết để mở trang Home
		        // Ví dụ: Tạo một đối tượng JFrame mới và hiển thị nó
		        Home home = new Home();
		        home.setVisible(true);
		    }
		});
	}

}
