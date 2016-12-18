package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		createBtnOrder();
		createBtnSupplier();
		
	}



	private void createBtnOrder() {
		ImageIcon iconOrder = new ImageIcon(getClass().getClassLoader().getResource("images/cart.png"));
		JButton btnOrder = new JButton(iconOrder);
		btnOrder.setText("Ordrer");
		btnOrder.setMnemonic(KeyEvent.VK_O);
		btnOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Order clicked");
			}
		});
		
		btnOrder.setBackground(UIManager.getColor("Button.background"));
		btnOrder.setBorder(null);
		btnOrder.setBounds(67, 74, 172, 172);
		contentPane.add(btnOrder);
		
		
	}
	
	private void createBtnSupplier() {
		ImageIcon iconSupplier = new ImageIcon(getClass().getClassLoader().getResource("images/dolly.png"));
		JButton btnSupplier = new JButton(iconSupplier);
		btnSupplier.setText("Lager");
		btnSupplier.setMnemonic(KeyEvent.VK_L);
		btnSupplier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Supplier clicked");
				
			}
		});
		
		btnSupplier.setBackground(UIManager.getColor("Button.background"));
		btnSupplier.setBorder(null);
		btnSupplier.setBounds(357, 74, 172, 172);
		contentPane.add(btnSupplier);
		
	}
}
