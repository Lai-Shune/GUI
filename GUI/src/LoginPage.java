import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
	
	private JFrame frame1;
	private static JLabel title;
	private static JLabel label1;
	private static JTextField username;
	private static JLabel label2;
	private static JPasswordField password;
	private static JButton login;
	private static JPanel panel1;

	public static void main(String[] args) {
		
		LoginPage l = new LoginPage();
		l.frame1.setVisible(true);

	}
	
	
	public LoginPage() {
		frame1 = new JFrame("EMP Management System");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(975, 688);
		
		frame1.getContentPane().setLayout(new BorderLayout());
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(18, 43, 85));
		panel1.setPreferredSize(new Dimension(300, 200));
		frame1.getContentPane().add(panel1, BorderLayout.WEST);
		
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\Shune\\Pictures\\Anime\\eren.jpg"));
		frame1.getContentPane().add(label);
		
		title = new JLabel("Welcome Back !");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(65, 83, 165, 30);
		title.setFont(new Font("Poor Richard", Font.PLAIN, 25));
		title.setForeground(Color.white);
		panel1.add(title);
		
		label1 = new JLabel("Username: ");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label1.setBounds(25, 164, 67, 25);
		label1.setForeground(Color.white);
		panel1.add(label1);
		
		username = new JTextField();
		username.setBounds(100, 165, 165, 25);
		panel1.add(username);
		
		label2 = new JLabel("Password: ");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label2.setBounds(25, 217, 58, 25);
		label2.setForeground(Color.white);
		panel1.add(label2);
		
		password = new JPasswordField();
		password.setBounds(100, 218, 165, 25);
		panel1.add(password);

		
		login = new JButton("Login");
		login.setBounds(185, 262, 80, 25);
		login.setBackground(new Color(57, 83, 120));
		login.setForeground(Color.WHITE);
		login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				String pw = password.getText();
				System.out.println(user + ", " + pw);
				
				if (user.equals("laishune") && pw.equals("lai123")){
					JOptionPane.showMessageDialog(null, "Login Successful!");
					MenuPage m = new MenuPage();
					m.menu();
					
				}else if (user.equals("") && pw.equals("")){
					JOptionPane.showMessageDialog(null, "Please insert username and password.");
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Login!");
				}
				
			
			}
		});
		
		
		panel1.add(login);	
		
	}

}
