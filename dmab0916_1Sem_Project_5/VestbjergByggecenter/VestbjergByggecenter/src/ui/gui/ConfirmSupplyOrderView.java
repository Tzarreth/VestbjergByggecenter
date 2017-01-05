package ui.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SupplyOrderCtrl;
import model.Product;
import model.Supplier;
import model.SupplyOrder;
import model.SupplyOrderLine;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class ConfirmSupplyOrderView extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> listModel = new DefaultListModel();
	private ArrayList<Product> products = new ArrayList<>();
	private JList list;
	private SupplyOrderLineConverter sc = new SupplyOrderLineConverter();
	private HashMap<Supplier, SupplyOrder> so = new HashMap<>();
	private SupplyOrderCtrl sCtrl = new SupplyOrderCtrl();
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmSupplyOrderView frame = new ConfirmSupplyOrderView();
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
	public ConfirmSupplyOrderView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		list.setBounds(180, 105, 477, 358);
		contentPane.add(list);
		list.setModel(listModel);

		JButton btnConfirmSupplyOrder = new JButton("Godkend bestilling");
		btnConfirmSupplyOrder.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
		btnConfirmSupplyOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConfirmSupplyOrderClicked();
			}
		});
		btnConfirmSupplyOrder.setBounds(415, 500, 185, 25);
		contentPane.add(btnConfirmSupplyOrder);

		btnCancel = new JButton("Annuller");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancelClicked();
			}
		});
		btnCancel.setBounds(Constants.btnBackXCoordinate, Constants.btnBackYCoordinate, Constants.btnBackHeight, Constants.btnBackWidth);
		contentPane.add(btnCancel);
	}

	protected void btnCancelClicked() {
		MainMenuView.getInstance().goBack();
	}

	protected void btnConfirmSupplyOrderClicked() {
		sCtrl.addHashMapToContainer(so);

		this.setVisible(false);
		this.dispose();
		MainMenuView.getInstance().goBack();
	}

	public void printProductsToOrder(HashMap<Supplier, SupplyOrder> map){
		Set<Supplier> suppliers = map.keySet();
		for (Supplier s : suppliers){
			listModel.addElement("*****************************************" + map.get(s).getSupplier().getName()+"*****************************************");
			ArrayList<SupplyOrderLine> sol = map.get(s).getSupplyOrderLines();

			for (SupplyOrderLine sl : sol){

				listModel.addElement(sc.convertToString(sl));
			}
		}
		so = map;
	}
}
