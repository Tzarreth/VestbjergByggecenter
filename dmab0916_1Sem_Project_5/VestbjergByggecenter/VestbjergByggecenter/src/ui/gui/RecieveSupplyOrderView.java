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
import java.awt.Font;

public class RecieveSupplyOrderView extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTable table;
	private TableModelRecieveSupplyOrder myTable = new TableModelRecieveSupplyOrder();
	private SupplyOrderCtrl sCtrl = new SupplyOrderCtrl();
	private JCheckBox cb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Setup.setup();
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 77, 635, 335);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(myTable);
		myTable.setData(sCtrl.getNotRecievedSupplyOrderLines());

		JLabel lblRecieveOrder = new JLabel("Varemodtagelse");
		lblRecieveOrder.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
		lblRecieveOrder.setBounds(320, 55, 140, 20);
		contentPane.add(lblRecieveOrder);

		JButton btnRegisterRecieveOrder = new JButton("Registrer modtagelse");
		btnRegisterRecieveOrder.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));

		btnRegisterRecieveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegisterRecieveOrderClicked();
			}
		});
		btnRegisterRecieveOrder.setBounds(Constants.btnRightXCoordinate, Constants.btnRightYCoordinate, Constants.btnRightWidth, Constants.btnRightHeight);
		contentPane.add(btnRegisterRecieveOrder);

		JButton btnBack = new JButton("Tilbage");
		btnBack.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTilbageClicked();
			}
		});
		btnBack.setBounds(Constants.btnBackXCoordinate, Constants.btnBackYCoordinate, Constants.btnBackWidth, Constants.btnBackHeight);
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


	}

	protected void btnTilbageClicked() {
		MainMenuView.getInstance().goBack();
	}
}
