package ui.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import controller.*;
import model.Product;

import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class SupplyOrderView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private TabelModelSupplyOrder myModel = new TabelModelSupplyOrder();
	private TableModelCheckbox myTable = new TableModelCheckbox();

	private SupplyOrderCtrl sCtrl = new SupplyOrderCtrl();
	private JCheckBox cb1 = new JCheckBox("V\u00E6lg alle");
	private JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainGUI.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyOrderView frame = new SupplyOrderView();
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
	public SupplyOrderView() {
		setTitle("Genbestil Vare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Genbestillingsvare");
		lblNewLabel.setBounds(296, 86, 111, 14);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 104, 578, 93);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(myModel);
		table.setAutoCreateRowSorter(true);
		myModel.setData(sCtrl.findPossibleRestockProducts());

		JButton btnConfirmRestockOrder = new JButton("Godkend Bestilling");
		btnConfirmRestockOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmRestockOrderClicked();
			}
		});
		btnConfirmRestockOrder.setBounds(521, 416, 137, 23);
		contentPane.add(btnConfirmRestockOrder);

		JButton btnBack = new JButton("Tilbage");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBackClicked();
			}
		});
		btnBack.setBounds(80, 415, 97, 25);
		contentPane.add(btnBack);
		
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb1Clicked();
			}
		});
		cb1.setBounds(561, 81, 113, 25);
		contentPane.add(cb1);

		internalFrame.setBounds(168, 210, 239, 135);
		contentPane.add(internalFrame);

		JLabel lblError = new JLabel("FEJL!");
		internalFrame.getContentPane().add(lblError, BorderLayout.CENTER);
		internalFrame.setVisible(false);
	}

	protected void cb1Clicked() {
		if (cb1.isSelected()){
			myModel.setAllSelected();
		}
		else {
			myModel.SetAllUnselected();
		}
	}

	protected void btnBackClicked() {
		StockMainView smv = new StockMainView();
		smv.setVisible(true);
		this.dispose();
	}

	protected void btnConfirmRestockOrderClicked() {
		ArrayList<Product> approvedProducts = new ArrayList<>();
		for (int i = 0; i<table.getRowCount(); i++){
			if ((boolean) myModel.getValueAt(i, 5)){
				approvedProducts.add(myModel.getData(i));
				ConfirmSupplyOrderView csov = new ConfirmSupplyOrderView();
				csov.setVisible(true);
				csov.printProductsToOrder(sCtrl.sendApprovedProductsToOrder(approvedProducts));
				this.setVisible(false);
				this.dispose();
			}
		}
		if (approvedProducts.size() == 0){
			JOptionPane op = new JOptionPane();
			op.showMessageDialog(contentPane, "Der er ikke valgt nogen vare.", "Fejl", JOptionPane.WARNING_MESSAGE);
		}
	}
}
