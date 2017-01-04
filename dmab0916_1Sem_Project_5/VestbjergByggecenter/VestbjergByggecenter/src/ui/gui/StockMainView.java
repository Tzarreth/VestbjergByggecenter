package ui.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockMainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainGUI.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockMainView frame = new StockMainView();
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
	public StockMainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReorderProduct = new JButton("Genbestil vare");
		btnReorderProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnReorderProductClicked();
			}
		});
		btnReorderProduct.setBounds(54, 101, 131, 25);
		contentPane.add(btnReorderProduct);
		
		JButton btnRecieveProduct = new JButton("Modtag vare");
		btnRecieveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRecieveProductClicked();
			}
		});
		btnRecieveProduct.setBounds(242, 101, 131, 25);
		contentPane.add(btnRecieveProduct);
		
		JButton btnStockView = new JButton("Lageroversigt");
		btnStockView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStockViewClicked();
			}
		});
		btnStockView.setBounds(54, 161, 131, 25);
		contentPane.add(btnStockView);
		
		JButton btnBack = new JButton("Tilbage");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackClicked();
			}
		});
		btnBack.setBounds(54, 452, 97, 25);
		contentPane.add(btnBack);
	}

	protected void btnStockViewClicked() {
		StockView sv = new StockView();
		JPanel jp = (JPanel) sv.getContentPane();
		contentPane = jp;
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.revalidate();
		//contentPane.repaint();
	}

	protected void btnRecieveProductClicked() {
		RecieveSupplyOrderView rsov = new RecieveSupplyOrderView();
		rsov.setVisible(true);
		this.setVisible(false);
	}

	protected void btnBackClicked() {
		this.setVisible(false);
		this.dispose();
		Main m = new Main();
	}

	protected void btnReorderProductClicked() {
		SupplyOrderView sov = new SupplyOrderView();
		sov.setVisible(true);
		this.setVisible(false);
	}
}