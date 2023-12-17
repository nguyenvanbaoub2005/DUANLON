package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.security.auth.spi.LoginModule;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class ViewSignUp extends JFrame {
	StringBuilder stb = new StringBuilder();
	private JTextField txtUserName;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JTextField nation;
	private JTextField txtphone;
	private JTextField gmail;

	public static void main(String[] args) {
		// Thay thế thông tin kết nối của bạn

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSignUp frame = new ViewSignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewSignUp() {
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JButton đăngkys = new JButton("Sign Up");

		//////////// controller
		đăngkys.addActionListener(new ActionListener() {
			StringBuilder stb = new StringBuilder();

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				/////////////////

				if (gmail.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					gmail.setBackground(Color.RED);
				} else {
					gmail.setBackground(Color.WHITE);
				}
				if (nation.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					nation.setBackground(Color.RED);
				} else {
					nation.setBackground(Color.WHITE);
				}
				if (txtphone.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					txtphone.setBackground(Color.RED);
				} else {
					txtphone.setBackground(Color.WHITE);
				}
				if (txtUserName.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					txtUserName.setBackground(Color.RED);
				} else {
					txtUserName.setBackground(Color.WHITE);
				}
				if (passwordField_2.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					passwordField_2.setBackground(Color.RED);
				} else {
					passwordField_2.setBackground(Color.WHITE);
				}
				if (passwordField_3.getText().equals("")) {
					stb.append("Vui long nhap thong tin !\n");
					passwordField_3.setBackground(Color.RED);
				} else {
					passwordField_3.setBackground(Color.WHITE);
				}
				
				
				
				
				// kiem tra co chuoi nhap vao hay khong
// hien thi thong bao khi an vao nut dang ky
				int Dk = JOptionPane.showConfirmDialog(đăngkys, "Would you like to register?", "",
						JOptionPane.YES_NO_OPTION);
				if (Dk != JOptionPane.YES_OPTION) {
					return;
				}

// kết nối cơ sở dữ liệu
				try {
					// Load JDBC driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/ACCOUNT";
					String username = "baobeo";
					String password = "vanbaoub123";
					// Kết nối đến cơ sở dữ liệu

					Connection connection = DriverManager.getConnection(url, username, password);

					String sql = "INSERT INTO DANGKY(UserName, Gmail, NationID, PhoneNumber, PassWord, ConfirmPassword) VALUES (?, ?, ?, ?, ?, ?)";// câu kết nối qua bên tê
					PreparedStatement ps = connection.prepareStatement(sql);// cho phép chỉ định tham số đầu vào khi chạy

					ps.setString(1, txtUserName.getText());
					ps.setString(2, gmail.getText());
					ps.setString(3, nation.getText());
					ps.setString(4, txtphone.getText());
					ps.setString(5, passwordField_2.getText());
					ps.setString(6, passwordField_3.getText());

					int n = ps.executeUpdate(); // update dữ liệu lên
				    if (txtUserName.getText().isEmpty() || gmail.getText().isEmpty() || nation.getText().isEmpty()
				            || txtphone.getText().isEmpty() || passwordField_2.getText().isEmpty()
				            || passwordField_3.getText().isEmpty()) {
				        JOptionPane.showMessageDialog(đăngkys, "Không để trống thông tin");
				    } else if (n != 0) {
				        JOptionPane.showMessageDialog(đăngkys, "Bạn đã đăng kí thành công");
				    } else {
				        JOptionPane.showMessageDialog(đăngkys, "Đăng kí thất bại");
				    }

				} catch (ClassNotFoundException | SQLException e) {
					System.out.println(e);
					;
				}

			}
		});
		đăngkys.setBounds(625, 466, 117, 29);
		getContentPane().add(đăngkys);

		JButton thoát = new JButton("Cancel");
		thoát.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);

			}
		});
		thoát.setBounds(450, 466, 117, 29);
		getContentPane().add(thoát);

		txtUserName = new JTextField();
		txtUserName.setBackground(Color.WHITE);
		txtUserName.setBounds(6, 130, 725, 26);
		getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		JLabel undo = new JLabel("Undol");
		undo.setFont(new Font("Mali", Font.PLAIN, 20));
		undo.setBounds(27, 6, 61, 29);
		getContentPane().add(undo);

		JLabel paywithundol = new JLabel("Pay with UnDol");
		paywithundol.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		paywithundol.setBounds(302, 35, 230, 29);
		getContentPane().add(paywithundol);

		JLabel lblNewLabel_1 = new JLabel(
				"With a UnDol account, you're eligible for free return shipping, Purchase Protection, and more.");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(129, 62, 613, 16);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(27, 112, 61, 16);
		getContentPane().add(lblNewLabel);

		JCheckBox Stayloggedinforfaster = new JCheckBox("Stay logged in for faster purchases");
		Stayloggedinforfaster.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		Stayloggedinforfaster.setBounds(6, 492, 230, 29);
		getContentPane().add(Stayloggedinforfaster);

		JLabel UserName = new JLabel("User Name");
		UserName.setBounds(6, 108, 105, 16);
		getContentPane().add(UserName);

		JLabel lblNewLabel_2 = new JLabel("Gmail");
		lblNewLabel_2.setBounds(6, 168, 61, 16);
		getContentPane().add(lblNewLabel_2);

		JLabel NationID = new JLabel("Nation ID");
		NationID.setBounds(6, 224, 134, 16);
		getContentPane().add(NationID);

		JLabel Password = new JLabel("Password");
		Password.setBounds(6, 356, 100, 16);
		getContentPane().add(Password);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBackground(Color.WHITE);
		passwordField_2.setBounds(6, 384, 725, 16);
		getContentPane().add(passwordField_2);

		passwordField_3 = new JPasswordField();
		passwordField_3.setBackground(Color.WHITE);
		passwordField_3.setBounds(6, 438, 725, 16);
		getContentPane().add(passwordField_3);

		JLabel confirmpassss = new JLabel("confirmpassss");
		confirmpassss.setBounds(6, 412, 105, 14);
		getContentPane().add(confirmpassss);

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewLogIn vlg = new viewLogIn();
				vlg.setVisible(true);// hieen thi man hinh log in
				 dispose();
				
			}
		});
		btnNewButton.setBounds(667, 10, 117, 29);
		getContentPane().add(btnNewButton);

		nation = new JTextField();
		nation.setBounds(6, 252, 725, 29);
		getContentPane().add(nation);
		nation.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setBounds(6, 293, 105, 16);
		getContentPane().add(lblNewLabel_4);

		txtphone = new JTextField();
		txtphone.setBounds(6, 307, 725, 26);
		getContentPane().add(txtphone);
		txtphone.setColumns(10);

		gmail = new JTextField();
		gmail.setColumns(10);
		gmail.setBounds(6, 183, 725, 29);
		getContentPane().add(gmail);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 558);

		this.setVisible(true);
	}
}
