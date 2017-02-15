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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

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

		JButton btnConfirmSupplyOrder = new JButton("Godkend bestilling");
		btnConfirmSupplyOrder.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
		btnConfirmSupplyOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConfirmSupplyOrderClicked();
			}
		});
		btnConfirmSupplyOrder.setBounds(Constants.btnRightXCoordinate, Constants.btnRightYCoordinate, Constants.btnMenuRightWidth, Constants.btnRightHeight);
		contentPane.add(btnConfirmSupplyOrder);

		btnCancel = new JButton("Annuller");
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancelClicked();
			}
		});
		btnCancel.setBounds(30, 500, 165, 30);
		contentPane.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 758, 352);
		contentPane.add(scrollPane);

		list = new JList();
		list.setFont(new Font("Consolas", Font.PLAIN, 14));
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		list.setModel(listModel);
		
	}

	protected void btnCancelClicked() {
		MainMenuView.getInstance().goBack();
	}

	protected void btnConfirmSupplyOrderClicked() {
		sCtrl.addHashMapToContainer(so);
		JOptionPane op = new JOptionPane();
		op.showMessageDialog(contentPane, "               Varene er bestilt", "Bekræftelse", JOptionPane.INFORMATION_MESSAGE);
		MainMenuView.getInstance().goBack();
		MainMenuView.getInstance().goBack();
	}

	public void printProductsToOrder(HashMap<Supplier, SupplyOrder> map){
		double total = 0;
		double deltotal = 0;
		Set<Supplier> suppliers = map.keySet();
		listModel.addElement("--------------------------------------  GENBESTILLINGER  ----------------------------------");
		listModel.addElement("                                                                                           ");
		for (Supplier s : suppliers){
			listModel.addElement("*************************************** " + map.get(s).getSupplier().getName()+" **************************************");
			ArrayList<SupplyOrderLine> sol = map.get(s).getSupplyOrderLines();
			deltotal = 0;
			for (SupplyOrderLine sl : sol){
				deltotal += (sl.getProduct().getPurchasePrice() * sl.getAmount());
				total += (sl.getProduct().getPurchasePrice() * sl.getAmount());
				listModel.addElement(sc.convertToString(sl));
			}
			listModel.addElement("                                                                                       ");
			listModel.addElement("                                                                Deltotal:   " + deltotal + " kr." );
			listModel.addElement("****************************************************************************************");
			listModel.addElement("");
		}
		listModel.addElement("TOTAL:____________________________________________________________________  " + total + " kr. ");
		so = map;
	}
}
