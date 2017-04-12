import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JEditorPane;
import java.awt.TextArea;


@SuppressWarnings({ "serial", "unused" })
public class Admin extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/login";
    static final String USER = "root";
	static final String PASS = "student";
	static Connection conn = null;
	PreparedStatement stmt = null;
	String un, pwd, xyz=null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "deprecation" })
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		textArea.appendText("Username" + "\t" +"Password\n");
			try{			
			Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql="SELECT * FROM Bank";
			stmt = conn.prepareStatement(sql);
		    ResultSet rs = stmt.executeQuery();
		     while (rs.next()) {
		            String username = rs.getString("username");
		            textArea.appendText(username+"\t");
		            String password = rs.getString("password");
		            textArea.appendText(password+"\n");
		    	}
		      }
		      catch(SQLException e){
		         System.out.println("SQL exception occured" + e);
		      } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
