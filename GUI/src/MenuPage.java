import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class MenuPage {

	private JFrame menuframe;
	private final JPanel panel = new JPanel();
	private JPanel parent;
	private JTextField idtext;
	private JTextField nametext;
	private JTextField emailtext;
	private JTextField positiontext;
	
	public void menu() {
		MenuPage m = new MenuPage();
		m.menuframe.setVisible(true);
	}
	
	static boolean isValid(String email) {
		   String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		   return email.matches(regex);
		}
	
	public MenuPage() {
		panel.setLayout(null);
		
		menuframe = new JFrame("EMP Management System");
		menuframe.getContentPane().setBackground(Color.BLACK);
		menuframe.setSize(975, 688);
		menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuframe.getContentPane().setLayout(null);
		
		CardLayout c = new CardLayout();
		
		parent = new JPanel();
		parent.setBounds(188, 0, 773, 651);
		menuframe.getContentPane().add(parent);
		parent.setLayout(c);
		
		JPanel home = new JPanel();
		home.setBackground(SystemColor.activeCaption);
		parent.add(home, "home");
		home.setLayout(null);
		
		JLabel homehead = new JLabel("Employee Management System");
		homehead.setHorizontalAlignment(SwingConstants.CENTER);
		homehead.setBounds(90, 35, 597, 60);
		homehead.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		home.add(homehead);
		
		JLabel totalnumber = new JLabel("Total Number Of Employee - 0");
		totalnumber.setHorizontalAlignment(SwingConstants.CENTER);
		totalnumber.setFont(new Font("Yu Gothic Medium", Font.BOLD, 30));
		totalnumber.setBounds(158, 225, 467, 47);
		home.add(totalnumber);
		
		JPanel register = new JPanel();
		register.setBackground(new Color(204, 204, 153));
		parent.add(register, "register");
		register.setLayout(null);
		
		JLabel reghead = new JLabel("Employee Management System");
		reghead.setHorizontalAlignment(SwingConstants.CENTER);
		reghead.setBounds(82, 32, 596, 54);
		reghead.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		register.add(reghead);
		
		JLabel employeeID = new JLabel("Employee ID :");
		employeeID.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 20));
		employeeID.setBounds(161, 150, 153, 17);
		register.add(employeeID);
		
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 20));
		name.setBounds(161, 230, 153, 17);
		register.add(name);
		
		JLabel email = new JLabel("Email :");
		email.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 20));
		email.setBounds(161, 310, 153, 17);
		register.add(email);
		
		JLabel position = new JLabel("Position : ");
		position.setFont(new Font("UD Digi Kyokasho N-R", Font.PLAIN, 20));
		position.setBounds(161, 390, 153, 17);
		register.add(position);
		
		idtext = new JTextField();
		idtext.setBounds(360, 137, 202, 40);
		register.add(idtext);
		idtext.setColumns(10);
		
		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setBounds(360, 215, 202, 40);
		register.add(nametext);
		
		emailtext = new JTextField();
		emailtext.setColumns(10);
		emailtext.setBounds(360, 296, 202, 40);
		register.add(emailtext);
		
		positiontext = new JTextField();
		positiontext.setColumns(10);
		positiontext.setBounds(360, 377, 202, 40);
		register.add(positiontext);
		
		JPanel display = new JPanel();
		display.setBackground(new Color(255, 204, 153));
		parent.add(display, "display");
		display.setLayout(null);
		
		JLabel dishead = new JLabel("Employee Management System");
		dishead.setHorizontalAlignment(SwingConstants.CENTER);
		dishead.setBounds(99, 20, 578, 62);
		dishead.setBackground(Color.WHITE);
		dishead.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		display.add(dishead);
		
		JTable table = new JTable();
		Object[] columns = {"ID", "Name", "Email", "Position"};
		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.white);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(Color.red);
		pane.setBackground(Color.white);
		pane.setBounds(40, 104, 698, 435);
		display.add(pane);
		
        Object[] row = new Object[4];
		
		JButton savebtn = new JButton("Save");
		savebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		savebtn.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e) {
				String id = idtext.getText();
				String name = nametext.getText();
				String email = emailtext.getText();
				String position = positiontext.getText();
				
				if (id.equals("") || name.equals("") || email.equals("") || position.equals("")) {
					JOptionPane.showMessageDialog(menuframe, "Please insert answers correctly in all boxes!");
				}else if(!isValid(email)) {
					JOptionPane.showMessageDialog(menuframe, "Please insert valid email!");
				}else if(Integer.parseInt(id) <= 0) {
					JOptionPane.showMessageDialog(menuframe, "Please insert valid ID!");
				}else {
					row[0] = id;
					row[1] = name;
					row[2] = email;
					row[3] = position;
					
					model.addRow(row);
					JOptionPane.showMessageDialog(menuframe, "Saved Successfully!");
				}
			}
		});
		savebtn.setBounds(464, 442, 98, 31);
		register.add(savebtn);
		
		JButton removebtn = new JButton("Remove");
		removebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		removebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
				}else {
					JOptionPane.showMessageDialog(menuframe, "Delete Error");
				}
			}
		});
		removebtn.setBounds(623, 559, 115, 32);
		display.add(removebtn);
		
		JButton homebtn = new JButton("Home");
		homebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		homebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(parent, "home");
				totalnumber.setText("Total Number Of Employee - " + table.getRowCount() );
			}
		});
		homebtn.setBounds(45, 200, 100, 28);
		menuframe.getContentPane().add(homebtn);
		
		
		JButton regbtn = new JButton("Register");
		regbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		regbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(parent, "register");
			}
		});
		regbtn.setBounds(45, 270, 100, 28);
		menuframe.getContentPane().add(regbtn);
		
		
		JButton disbtn = new JButton("Display");
		disbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		disbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(parent, "display");
			}
		});
		disbtn.setBounds(45, 340, 100, 28);
		menuframe.getContentPane().add(disbtn);
		
		
	}
}
