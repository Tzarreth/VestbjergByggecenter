package ui.gui;

import controller.*;
import model.*;
import ui.TableModels.TableModelStock;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;

public class StockView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public static  TableModelStock myTable = new TableModelStock();
	private JButton btnClose;
	private JTextField txtQuery;
	private TableRowSorter<TableModelStock> sorter;


	private StockCtrl stockCtrl = new StockCtrl();
	private JButton btnRedigerVare;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockView frame = new StockView();
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
	public StockView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 578);
		contentPane = new JPanel();
		contentPane.setBackground(Constants.backgroundColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtQuery = new JTextField();
		txtQuery.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtQuery.setText("S\u00F8g");
		txtQuery.setToolTipText("s\u00F8g");
		txtQuery.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filter(txtQuery.getText());
			}
		});

		txtQuery.setBounds(19, 24, 254, 22);
		txtQuery.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Click column header to sort");
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(19, 48, 700, 337);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					btnRedigerVareClicked();
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setToolTipText("Click Product to select");
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);

		table.setModel(myTable);
		sorter = new TableRowSorter<TableModelStock>();

		myTable.setData(stockCtrl.getAllStockProducts());
		table.setAutoCreateRowSorter(true);



		btnClose = new JButton("Tilbage");
		btnClose.setFont(new Font(Constants.fontName, Constants.fontStyle, Constants.fontSize));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCloseClicked();
			}
		});
		btnClose.setBounds(30, 488, Constants.btnBackWidth, Constants.btnBackHeight);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(txtQuery);
		contentPane.add(scrollPane);
		contentPane.add(btnClose);

		JButton btnNyVare = new JButton("Ny vare");
		btnNyVare.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNyVare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNyVareClicked();
			}
		});
		btnNyVare.setBounds(465, 490, 100, 27);
		contentPane.add(btnNyVare);

		btnRedigerVare = new JButton("Rediger vare");
		btnRedigerVare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRedigerVareClicked();
			}
		});
		btnRedigerVare.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnRedigerVare.setBounds(291, 491, 162, 25);
		contentPane.add(btnRedigerVare);

		JButton btnFjernVare = new JButton("Fjern vare");
		btnFjernVare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFjernVareClicked();
			}
		});
		btnFjernVare.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnFjernVare.setBounds(577, 491, 128, 25);
		contentPane.add(btnFjernVare);


	}

	protected void btnFjernVareClicked() {
		StockProduct stockproduct = myTable.getData(table.getSelectedRow());
		if(stockproduct != null){
			int response = JOptionPane.showConfirmDialog(null, "Er du sikker på at du vil fjerne vare: " + stockproduct.getProduct().getDescription()+"?", "Fjern vare",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				stockCtrl.removeStockProduct(stockproduct);}
		}
		else{JOptionPane.showMessageDialog(contentPane, "Der er ikke valgt nogen vare");}
		SaveAndLoadFromFile save = new SaveAndLoadFromFile();
		myTable.setData(stockCtrl.getAllStockProducts());
		save.saveAll();
	}

	protected void btnRedigerVareClicked() {
		EditProductView epv = new EditProductView();
		StockProduct stockproduct = myTable.getData(table.getSelectedRow());

		if(stockproduct != null){epv.loadTextFields(stockproduct);
		epv.setVisible(true);}
		else{JOptionPane.showMessageDialog(contentPane, "Der er ikke valgt nogen vare! Fool!!");}
	}

	protected void btnNyVareClicked() {
		NewProductView npv = new NewProductView();
		npv.setVisible(true);

	}

	protected void filter(String query) {

		TableRowSorter<TableModelStock> tr = new TableRowSorter<TableModelStock>(myTable);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));

		myTable.setData(stockCtrl.getAllStockProducts());
	}

	protected void btnCloseClicked() {
		MainMenuView.getInstance().goBack();
	}

	public void setTableData(){
		myTable.setData(stockCtrl.getAllStockProducts());
	}
}
