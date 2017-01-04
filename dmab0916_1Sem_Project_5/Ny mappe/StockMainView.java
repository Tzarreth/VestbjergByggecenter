package gui;

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
		
		JButton btnGenbestilVare = new JButton("Genbestil vare");
		btnGenbestilVare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGenbestilVareClicked();
			}
		});
		btnGenbestilVare.setBounds(54, 101, 131, 25);
		contentPane.add(btnGenbestilVare);
		
		JButton btnModtagVare = new JButton("Modtag vare");
		btnModtagVare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnModtagVareClicked();
			}
		});
		btnModtagVare.setBounds(242, 101, 131, 25);
		contentPane.add(btnModtagVare);
		
		JButton btnLageroversigt = new JButton("Lageroversigt");
		btnLageroversigt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLageroversigtClicked();
			}
		});
		btnLageroversigt.setBounds(54, 161, 131, 25);
		contentPane.add(btnLageroversigt);
		
		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTilbageClicked();
			}
		});
		btnTilbage.setBounds(54, 452, 97, 25);
		contentPane.add(btnTilbage);
	}

	protected void btnLageroversigtClicked() {
		StockView sv = new StockView();
		sv.setVisible(true);
		
	}

	protected void btnModtagVareClicked() {
		RecieveSupplyOrderView rsov = new RecieveSupplyOrderView();
		rsov.setVisible(true);
		this.setVisible(false);
		
	}

	protected void btnTilbageClicked() {
		this.setVisible(false);
		this.dispose();
		Main m = new Main();
		
		
		
	}

	protected void btnGenbestilVareClicked() {
		SupplyOrderView sov = new SupplyOrderView();
		sov.setVisible(true);
		
		this.setVisible(false);
		
	}
}
