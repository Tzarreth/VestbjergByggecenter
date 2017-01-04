package ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SaveAndLoadFromFile;
import ui.IMainMenuUI;

public class MainMenuView extends JFrame implements IMainMenuUI {

	private JPanel contentPane;
	private SaveAndLoadFromFile saveAndLoad = new SaveAndLoadFromFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainMenuView().run();
	}

	@Override
	public void run() {
		try {
			saveAndLoad.loadAll();
			MainMenuView frame = new MainMenuView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public MainMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		createBtnOrder();
		createBtnSupplier();
	}
	
	private void createBtnOrder() {
		ImageIcon iconOrder = new ImageIcon(getClass().getClassLoader().getResource("images/cart.png"));
		JButton btnOrder = new JButton(iconOrder);
		btnOrder.setFocusPainted(false);
		btnOrder.setText("Ordrer");
		btnOrder.setMnemonic(KeyEvent.VK_O);
		btnOrder.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnCreateBtnOrderClicked();
				System.out.println("Order clicked");
			}

		});
		contentPane.setLayout(null);
		

		btnOrder.setBackground(SystemColor.menu);
		btnOrder.setBorder(null);
		btnOrder.setBounds(174, 185, 172, 172);
		getContentPane().add(btnOrder);
	}

	private void createBtnSupplier() {
		ImageIcon iconSupplier = new ImageIcon(getClass().getClassLoader().getResource("images/dolly.png"));
		JButton btnLager = new JButton(iconSupplier);
		btnLager.setFocusPainted(false);
		btnLager.setText("Lager");
		btnLager.setMnemonic(KeyEvent.VK_L);
		btnLager.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnCreateBtnSupplierClicked();
				System.out.println("Supplier clicked");

			}
		});

		btnLager.setBackground(new Color(240, 240, 240));
		btnLager.setBorder(null);
		btnLager.setBounds(440, 185, 172, 172);
		getContentPane().add(btnLager);
	}

	private void btnCreateBtnOrderClicked() {
		OrderMenuView omv = new OrderMenuView();
		JPanel jp = (JPanel) omv.getContentPane();
		contentPane = jp;
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.revalidate();
	}
	
	private void btnCreateBtnSupplierClicked(){
		StockMainView sv = new StockMainView();
		JPanel jp = (JPanel) sv.getContentPane();
		contentPane = jp;
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.revalidate();
	}
}