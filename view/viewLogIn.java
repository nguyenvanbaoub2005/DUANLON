package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class viewLogIn extends JFrame {

	// Kết nối đến cơ sở dữ liệu

	private JPanel contentPane;
	private JTextField txtnation;
	private JTextField txtpass;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogIn frame = new viewLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public viewLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel undo = new JLabel("Undol");
		undo.setBounds(18, 6, 54, 26);
		undo.setFont(new Font("Mali", Font.PLAIN, 20));
		contentPane.add(undo);

		JLabel paywithundol = new JLabel("Pay with UnDol");
		paywithundol.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		paywithundol.setBounds(173, 28, 230, 29);
		contentPane.add(paywithundol);

		txtnation = new JTextField();
		txtnation.setColumns(10);
		txtnation.setBackground(Color.WHITE);
		txtnation.setBounds(0, 120, 536, 26);
		contentPane.add(txtnation);

		txtpass = new JTextField();
		txtpass.setColumns(10);
		txtpass.setBackground(Color.WHITE);
		txtpass.setBounds(0, 178, 536, 26);
		contentPane.add(txtpass);

		JLabel nation = new JLabel("Nation ID");
		nation.setBounds(6, 106, 98, 16);
		contentPane.add(nation);

		JLabel lblPassWord = new JLabel("PassWord");
		lblPassWord.setBounds(6, 158, 98, 16);
		contentPane.add(lblPassWord);

		JButton login = new JButton("Log In");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/ACCOUNT";
					String username = "baobeo";
					String password = "vanbaoub123";
					ResultSet rs;

					// Kết nối đến cơ sở dữ liệu

					Connection connection = DriverManager.getConnection(url, username, password);
					String sql = "SELECT* FROM DANGKY WHERE NationID=? and PassWord=?";// truy vấn đến sql
					PreparedStatement ps = connection.prepareCall(sql);// cho phép chỉ định tham số đầu vào khi run
					ps.setString(1, txtnation.getText());// nhận vào 1 tham số khi ai nhập vào
					ps.setString(2, txtpass.getText());// nhap apk mk
					rs = ps.executeQuery();// executeQuery tra về thằng ResultSet khi thực hiện câu lệnh sellec

					if (txtnation.getText().isEmpty() | txtpass.getText().isEmpty()) {
						JOptionPane.showMessageDialog(login, "Vui lòng không để trống");
					}
					else if (rs.next())
						
						
						
						
						
						
						
					// có dữ liệu
					{
						JOptionPane.showMessageDialog(login, "Đăng nhập thành công");
					} else {
						JOptionPane.showMessageDialog(login, "Đăng nhập thất bại");
					}

				} catch (Exception e2) {
					System.out.println(e2);

				}

			}
		});
		login.setBounds(400, 239, 117, 29);
		contentPane.add(login);

		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSignUp bv = new ViewSignUp();
				bv.setVisible(true);
				dispose();

			}
		});
		signup.setBounds(18, 239, 117, 29);
		contentPane.add(signup);

		JLabel r = new JLabel("Full wealth and good luck for you");
		r.setFont(new Font("Mali", Font.PLAIN, 13));
		r.setBounds(159, 293, 237, 16);

		contentPane.add(r);
	}
}
