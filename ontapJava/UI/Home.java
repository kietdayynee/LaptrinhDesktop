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
public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
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
		
		JButton btnConn = new JButton("Connect DB");
		btnConn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(btnConn);
		
		JLabel lblHome = new JLabel("HELLO!");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblHome, BorderLayout.CENTER);
		
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
	}

}
