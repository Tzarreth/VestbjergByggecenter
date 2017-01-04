package ui.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.SupplyOrderCtrl;
import model.SupplyOrderLine;

public class RecieveSupplyOrderView extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTable table;
	private TabelModelRecieveSupplyOrder myTable = new TabelModelRecieveSupplyOrder();
	private SupplyOrderCtrl sCtrl = new SupplyOrderCtrl();
	private JCheckBox cb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainGUI.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecieveSupplyOrderView frame = new RecieveSupplyOrderView();
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
	public RecieveSupplyOrderView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		//contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 77, 635, 335);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(myTable);
		// Load table
		myTable.setData(sCtrl.getNotRecievedSupplyOrderLines());

		JLabel lblRecieveOrder = new JLabel("Varemodtagelse");
		lblRecieveOrder.setBounds(320, 63, 96, 14);
		contentPane.add(lblRecieveOrder);

		JButton btnRegisterRecieveOrder = new JButton("Registrer modtagelse");
		btnRegisterRecieveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegisterRecieveOrderClicked();
			}
		});
		btnRegisterRecieveOrder.setBounds(534, 442, 174, 23);
		contentPane.add(btnRegisterRecieveOrder);

		JButton btnBack = new JButton("Tilbage");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTilbageClicked();
			}
		});
		btnBack.setBounds(73, 441, 97, 25);
		contentPane.add(btnBack);

		cb2 = new JCheckBox("V\u00E6lg alle");
		cb2.setBounds(595, 43, 113, 25);
		contentPane.add(cb2);
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb2Clicked();
			}
		});

	}

	private void cb2Clicked() {
		if (cb2.isSelected()){
			myTable.setAllSelected();
		}
		else{
			myTable.SetAllUnselected();
		}	
	}

	protected void btnRegisterRecieveOrderClicked() {
		ArrayList<SupplyOrderLine> recievedSOLs = new ArrayList<>();
		for (int i = 0; i<table.getRowCount(); i++){
			if (table.isRowSelected(i)){
				recievedSOLs.add(myTable.getData(i));
			}
		}
		for (SupplyOrderLine sol : recievedSOLs){
			sCtrl.setSOLToRecieved(sol);
		}

		this.setVisible(false);
		this.dispose();
		StockMainView smw = new StockMainView();
		smw.setVisible(true);

	}

	protected void btnTilbageClicked() {
		this.setVisible(false);
		this.dispose();
		StockMainView smw = new StockMainView();
		smw.setVisible(true);

	}
}
