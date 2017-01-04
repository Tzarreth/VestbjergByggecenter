package ui.gui;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Main{

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private MainMenuView mainMenuView;
	private ArrayList<Component> panels = new ArrayList<>();
	
	public static void main (String[] args){
		new Main();
	}
	
	public Main(){
		JFrame frame = new JFrame("Main");
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		mainMenuView = new MainMenuView();
		mainMenuView.setBounds(0, 0, 794, 565);
		frame.getContentPane().add(mainMenuView);
		frame.setVisible(true);
	}
	
}





/*
public class Main implements ui.IMainMenuUI {
	private JFrame frame;
	private JPanel panelMainMenu;
	private JPanel panelOrderMenu;
	private JPanel panelSupplyOrderMenu;
	private JPanel panelCreateOrder;
	private JPanel panelShowAllOrders;
	private ArrayList<JPanel> panels = new ArrayList<>();
	private JButton btnShowAllOrders;
	private JButton btnBack;
	private JButton btnCreateOrderBack;
	private JButton btnShowAllOrdersBack;
	private JButton btnSaveOrder;

	private SaveAndLoadFromFile saveAndLoad = new SaveAndLoadFromFile();

	/**
 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setup();
					new Main().run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void run() {
		saveAndLoad.loadAll();
		Main window = new Main();
		window.frame.setVisible(true);
	}

	/**
 * Create the application.

	public Main() {
		initialize();
		addPanelsToList();
	}

	private void addPanelsToList(){
		panels.add(panelMainMenu);
		panels.add(panelOrderMenu);
		panels.add(panelSupplyOrderMenu);
		panels.add(panelCreateOrder);
		panels.add(panelShowAllOrders);
	}

	/**
 * Initialize the contents of the frame.

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panelMainMenu = new JPanel();
		frame.getContentPane().add(panelMainMenu, "name_10930597007731");
		panelMainMenu.setLayout(null);

		createBtnOrder();
		createBtnSupplier();

		panelOrderMenu = new JPanel();
		frame.getContentPane().add(panelOrderMenu, "name_10933055581982");
		panelOrderMenu.setLayout(null);

		btnCreateOrder();
		btnShowAllOrders();
		btnOrderBack();

		panelCreateOrder = new JPanel();
		frame.getContentPane().add(panelCreateOrder, "name_13064687373850");
		panelCreateOrder.setLayout(null);

		btnSaveOrder();
		btnCreateOrderMenuBack();

		panelShowAllOrders = new JPanel();
		frame.getContentPane().add(panelShowAllOrders, "name_13101855859892");
		panelShowAllOrders.setLayout(null);

		btnShowAllOrdersBack = new JButton("Tilbage");
		btnShowAllOrdersBack.setBounds(673, 515, 97, 25);
		panelShowAllOrders.add(btnShowAllOrdersBack);

		panelSupplyOrderMenu = new JPanel();
		frame.getContentPane().add(panelSupplyOrderMenu, "name_10968216089168");
		panelSupplyOrderMenu.setLayout(null);
	}

	private void createBtnOrder() {
		ImageIcon iconOrder = new ImageIcon(getClass().getClassLoader().getResource("images/cart.png"));
		JButton btnOrder = new JButton(iconOrder);
		btnOrder.setFocusPainted(false);
		btnOrder.setText("Ordrer");
		btnOrder.setMnemonic(KeyEvent.VK_O);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsToInvisible();
				panelOrderMenu.setVisible(true);
			}
		});

		btnOrder.setBackground(SystemColor.menu);
		btnOrder.setBorder(null);
		btnOrder.setBounds(132, 173, 172, 172);
		panelMainMenu.add(btnOrder);
	}

	private void createBtnSupplier() {
		ImageIcon iconSupplier = new ImageIcon(getClass().getClassLoader().getResource("images/dolly.png"));
		JButton btnLager = new JButton(iconSupplier);
		btnLager.setFocusPainted(false);
		btnLager.setText("Lager");
		btnLager.setMnemonic(KeyEvent.VK_L);
		btnLager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsToInvisible();
				panelSupplyOrderMenu.setVisible(true);
			}
		});

		btnLager.setBackground(new Color(240, 240, 240));
		btnLager.setBorder(null);
		btnLager.setBounds(419, 173, 172, 172);
		panelMainMenu.add(btnLager);
	}

	private void btnCreateOrder() {

		JButton btnCreateOrder = new JButton("Opret ny ordre");
		btnCreateOrder.setFocusPainted(false);
		btnCreateOrder.setMnemonic(KeyEvent.VK_O);
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsToInvisible();
				panelCreateOrder.setVisible(true);
			}
		});

		btnCreateOrder.setBackground(SystemColor.menu);
		btnCreateOrder.setBorder(null);
		btnCreateOrder.setBounds(152, 206, 117, 50);
		panelOrderMenu.add(btnCreateOrder);

	}

	private void btnShowAllOrders() {
		btnShowAllOrders = new JButton("Vis alle ordre");
		btnShowAllOrders.setFocusPainted(false);
		btnShowAllOrders.setMnemonic(KeyEvent.VK_O);
		btnShowAllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsToInvisible();
				panelShowAllOrders.setVisible(true);
			}
		});

		btnShowAllOrders.setBackground(SystemColor.menu);
		btnShowAllOrders.setBorder(null);
		btnShowAllOrders.setBounds(398, 206, 117, 50);		
		panelOrderMenu.add(btnShowAllOrders);
	}

	private void btnOrderBack(){
		btnBack = new JButton("Tilbage");
		btnBack.setFocusPainted(false);
		btnBack.setMnemonic(KeyEvent.VK_B);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsToInvisible();
				panelMainMenu.setVisible(true);
			}
		});

		btnBack.setBackground(SystemColor.menu);
		btnBack.setBorder(null);
		btnBack.setBounds(673, 515, 97, 25);
		panelOrderMenu.add(btnBack);

	}

	private void btnCreateOrderMenuBack(){
		btnCreateOrderBack = new JButton("Tilbage");
		btnCreateOrderBack.setFocusPainted(false);
		btnCreateOrderBack.setMnemonic(KeyEvent.VK_B);
		btnCreateOrderBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsToInvisible();				
				panelOrderMenu.setVisible(true);
			}
		});

		btnCreateOrderBack.setBackground(SystemColor.menu);
		btnCreateOrderBack.setBorder(null);
		btnCreateOrderBack.setBounds(673, 515, 97, 25);
		panelCreateOrder.add(btnCreateOrderBack);
	}

	private void btnSaveOrder(){
		btnSaveOrder = new JButton("Opret ordre");
		btnSaveOrder.setFocusPainted(false);
		btnSaveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAndLoad.saveAll();
			}
		});
		btnSaveOrder.setBackground(SystemColor.menu);
		btnSaveOrder.setBorder(null);
		btnSaveOrder.setBounds(406, 441, 111, 25);
		panelCreateOrder.add(btnSaveOrder);
	}

	private void setPanelsToInvisible(){
		for (JPanel panel : panels) {
			panel.setVisible(false);
		}
	}

	public static void setup() throws CustomerDoesNotExistsException{
		Supplier s1, s2, s3;
		Product p1, p2, p3, p4, p5, p6, p7, p8, p9;
		StockProduct sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9;
		ProductContainer pCon;
		Stock stock;
		Customer c1, c2, c3;
		CustomerContainer cCon;

		s1 = new Supplier("Bauhaus");
		s2 = new Supplier("Silvan");
		s3 = new Supplier("Jem og Fix");
		p1 = new Product(1500, 2000, "1", "snescooter", "vinter", "Hylde 1", 10, 4, 15, s3);
		p2 = new Product(800, 1000, "2", "k�lk", "vinter", "hylde4", 5, 20, 30, s3);
		p3 = new Product(1000, 1200, "3", "hurtig k�lk", "vinter", "hylde 5", 3, 4, 25, s1);
		p4 = new Product(100, 300, "4", "kaffemaskine", "hvidevarer", "hylde 17", 5, 6, 10, s2);
		p5 = new Product(1300, 1500, "5", "vaskemaskine", "h�rdeHvidevarer", "hylde 19", 4, 4, 5, s1);
		p6 = new Product(3000, 3200, "6", "den sl�r h�rdt", "v�rkt�j", "Hylde 52", 10, 2, 15, s3);
		p7 = new Product(20, 30, "102", "Sp�r - 4Meter", "ByggeMaterialer", "r�kke 16", 16, 40, 100, s1);
		p8 = new Product(450, 899, "140", "H�ndvask, hvid, 40cm", "K�kken", "Hylde 74", 4, 10, 15, s2);
		p9 = new Product(120, 250, "13", "Sneskovl - 35cm", "vinter", "Hylde 6", 29, 40, 65, s3);

		pCon = ProductContainer.getInstance();
		pCon.addProduct(p1);
		pCon.addProduct(p2);
		pCon.addProduct(p3);
		pCon.addProduct(p4);
		pCon.addProduct(p5);
		pCon.addProduct(p6);
		pCon.addProduct(p7);
		pCon.addProduct(p8);
		pCon.addProduct(p9);

		sp1 = new StockProduct(p1, "Reol A : Hylde 1", "Afd: 1");
		sp2 = new StockProduct(p2, "Reol B : Hylde 2", "Afd: 1");
		sp3 = new StockProduct(p3, "Reol B : Hylde 3", "Afd: 1");
		sp4 = new StockProduct(p4, "Reol F : Hylde 6", "Afd: 2");
		sp5 = new StockProduct(p5, "Reol D : Hylde 5", "Afd: 1");
		sp6 = new StockProduct(p6, "Reol C : Hylde 4", "Afd: 1");
		sp7 = new StockProduct(p7, "Reol E : Hylde 2", "Afd: 2");
		sp8 = new StockProduct(p8, "Reol D : Hylde 4", "Afd: 1");
		sp9 = new StockProduct(p9, "Reol E : Hylde 6", "Afd: 2");

		stock = Stock.getInstance();
		stock.addStockProduct(sp1);
		stock.addStockProduct(sp2);
		stock.addStockProduct(sp3);
		stock.addStockProduct(sp4);
		stock.addStockProduct(sp5);
		stock.addStockProduct(sp6);
		stock.addStockProduct(sp7);
		stock.addStockProduct(sp8);
		stock.addStockProduct(sp9);

		c1 = new Customer("Jakob Jakobsen", "Sofiendalsvej 60", "jakob@jakobsen.com", "12345678", "privat");
		c2 = new Customer("T�mrermester", "L�gtevej 4", "hej@t�mreren.dk", "12121212", "erhverv");
		c3 = new Customer("Hans Hansen", "Birkevej 10", "hans@gmail.com", "77778888", "privat");

		cCon = CustomerContainer.getInstance();
		cCon.addCustomer(c1);
		cCon.addCustomer(c2);
		cCon.addCustomer(c3);


		Order order1 = new Order();
		Order order2 = new Order();

		order1.addCustomerToOrder("12345678");
		order2.addCustomerToOrder("12121212");

		order1.addProductToOrder(p1, 6);
		order1.addProductToOrder(p2, 2);
		order1.addProductToOrder(p5, 1);

		order2.addProductToOrder(p4, 1);
		order2.addProductToOrder(p6, 3);
		order2.addProductToOrder(p7, 5);
		order2.addProductToOrder(p8, 2);
	}
}
 */
