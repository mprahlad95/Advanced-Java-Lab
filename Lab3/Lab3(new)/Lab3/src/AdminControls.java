import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AdminControls extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControls frame = new AdminControls();
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
	public AdminControls() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewDetails = new JButton("View Details");
		btnViewDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin1 frame = new Admin1();
				frame.setVisible(true);
			}
		});
		btnViewDetails.setBounds(46, 89, 122, 42);
		contentPane.add(btnViewDetails);
		
		
		
		
		JButton btnBlockAccount = new JButton("Block Account");
		btnBlockAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteAccount frame = new DeleteAccount();
				frame.setVisible(true);
			}
		});
		
		
		btnBlockAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBlockAccount.setBounds(176, 89, 122, 42);
		contentPane.add(btnBlockAccount);
		
		JLabel lblHiPrahlad = new JLabel("Administrator controls");
		lblHiPrahlad.setBounds(112, 26, 135, 14);
		contentPane.add(lblHiPrahlad);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bank1 frame = new Bank1();
				frame.setVisible(true);
			}
		});
		btnHome.setBounds(131, 142, 89, 23);
		contentPane.add(btnHome);
	}
}
