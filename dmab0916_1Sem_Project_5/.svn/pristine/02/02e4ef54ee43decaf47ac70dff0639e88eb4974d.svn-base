package ui.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class OrderMenuView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMenuView frame = new OrderMenuView();
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
	public OrderMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Constants.backgroundColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCreateOrderMenu();
		btnAllOrders();

	}

	private void btnAllOrders() {
		ImageIcon iconAllOrders = new ImageIcon(getClass().getClassLoader().getResource("images/orderList.png"));
		JButton btnAllOrders = new JButton(iconAllOrders);
		btnAllOrders.setFocusPainted(false);
		btnAllOrders.setText("Se Alle Ordrer");
		btnAllOrders.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
		btnAllOrders.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnSeeAllOrdersClicked();
			}

		});
		contentPane.setLayout(null);


		btnAllOrders.setBackground(Constants.backgroundColor);
		btnAllOrders.setBorder(null);
		btnAllOrders.setBounds(Constants.btnMenuLeftXCoordinate, Constants.btnMenuLeftYCoordinate, Constants.btnMenuLeftWidth, Constants.btnMenuLeftHeight);
		contentPane.add(btnAllOrders);
		{
			JButton btnBack = new JButton("Tilbage");
			btnBack.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenuView.getInstance().goBack();
				}
			});
			btnBack.setBounds(Constants.btnBackXCoordinate, Constants.btnBackYCoordinate, Constants.btnBackWidth, Constants.btnBackHeight);
			contentPane.add(btnBack);
		}
	}

	public void btnCreateOrderMenu(){

		ImageIcon iconCreateOrder = new ImageIcon(getClass().getClassLoader().getResource("images/createOrder1.png"));
		JButton btnCreateOrderView = new JButton(iconCreateOrder);
		btnCreateOrderView.setFocusPainted(false);
		btnCreateOrderView.setMnemonic(KeyEvent.VK_O);
		btnCreateOrderView.setText("Opret Ordre");
		btnCreateOrderView.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
		btnCreateOrderView.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnCreateBtnCreateOrderMenu();

			}

		});
		contentPane.setLayout(null);


		btnCreateOrderView.setBackground(Constants.backgroundColor);
		btnCreateOrderView.setBorder(null);
		btnCreateOrderView.setBounds(Constants.btnMenuRightXCoordinate, Constants.btnMenuRightYCoordinate, Constants.btnMenuRightWidth, Constants.btnMenuRightHeight);
		contentPane.add(btnCreateOrderView);
	}

	public void btnCreateBtnCreateOrderMenu(){
		CreateOrderView cov = new CreateOrderView();
		MainMenuView.getInstance().activateContentPane((JPanel) cov.getContentPane(), contentPane);
	}

	public void btnSeeAllOrdersClicked(){
		ShowAllOrdersView saov = new ShowAllOrdersView();
		MainMenuView.getInstance().activateContentPane((JPanel) saov.getContentPane(), contentPane);
	}
}
