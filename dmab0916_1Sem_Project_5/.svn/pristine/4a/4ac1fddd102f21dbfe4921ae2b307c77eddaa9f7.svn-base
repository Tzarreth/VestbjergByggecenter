package ui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ProductCtrl;
import controller.SaveAndLoadFromFile;
import controller.StockCtrl;
import model.Product;
import model.StockProduct;
import model.Supplier;
import ui.libGUI.DropDownList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EditProductView extends JDialog implements KeyListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField beskrivelseTxt;
	private JTextField indkøbsprisTxt;
	private JTextField salgsprisTxt;
	private JTextField varenummerTxt;
	private JTextField varegruppeTxt;
	private JTextField reolTxt;
	private JTextField hyldeTxt;
	private JTextField afdelingTxt;
	private JTextField antalTxt;
	private JTextField minAntalTxt;
	private JTextField maxAntalTxt;
	private JLabel lblSalgspris;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblLokation;
	private JLabel lblAfdeling;
	private JLabel lblNewLabel_2;
	private JLabel lblMinAntal;
	private JLabel lblMaxAntal;
	private JTextField leverandørTxt;
	private JLabel lblLeverandr;
	private JLabel lblNyVare;
	private StockProduct stockproduct;
	private ProductCtrl productCtrl = new ProductCtrl();
	private StockCtrl stockCtrl = new StockCtrl();
	private JButton okButton;
	private JScrollPane scrollPane;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditProductView dialog = new EditProductView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param stockproduct 
	 */
	public EditProductView() {
	
		setBounds(100, 100, 593, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonClicked();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 329, 172, 84);
		contentPanel.add(scrollPane);
		setupPane();
	}

	protected void okButtonClicked() {
		Product product = stockproduct.getProduct();
		product.setDescription(beskrivelseTxt.getText());
		product.setPurchasePrice(Double.parseDouble(indkøbsprisTxt.getText()));
		product.setSalesPrice(Double.parseDouble(salgsprisTxt.getText()));
		product.setProductNumber(varenummerTxt.getText());
		product.setProductGroup(varegruppeTxt.getText());
		product.setMinAmount(Integer.parseInt(minAntalTxt.getText()));
		product.setMaxAmount(Integer.parseInt(maxAntalTxt.getText()));
		product.setSupplier(productCtrl.findSupplierByName(leverandørTxt.getText()));
		product.setQuantity(Integer.parseInt(antalTxt.getText()));
		stockproduct.setQty(Integer.parseInt(antalTxt.getText()));
		stockproduct.setLocation(afdelingTxt.getText());
		stockproduct.setPlacement("Reol: " + reolTxt.getText() + " : Hylde: " + hyldeTxt.getText());
		StockView.myTable.setData(stockCtrl.getAllStockProducts());
		SaveAndLoadFromFile save = new SaveAndLoadFromFile();
		save.saveAll();
		this.setVisible(false);
		this.dispose();
	}

	private void setupPane() {
		beskrivelseTxt = new JTextField();
		beskrivelseTxt.setBounds(94, 69, 147, 22);
		contentPanel.add(beskrivelseTxt);
		beskrivelseTxt.setColumns(10);
		beskrivelseTxt.addKeyListener(this);


		indkøbsprisTxt = new JTextField();
		indkøbsprisTxt.setBounds(94, 124, 147, 22);
		contentPanel.add(indkøbsprisTxt);
		indkøbsprisTxt.setColumns(10);
		indkøbsprisTxt.addKeyListener(this);

		salgsprisTxt = new JTextField();
		salgsprisTxt.setBounds(94, 185, 147, 22);
		contentPanel.add(salgsprisTxt);
		salgsprisTxt.setColumns(10);
		salgsprisTxt.addKeyListener(this);

		varenummerTxt = new JTextField();
		varenummerTxt.setBounds(94, 241, 147, 22);
		contentPanel.add(varenummerTxt);
		varenummerTxt.setColumns(10);
		varenummerTxt.addKeyListener(this);

		varegruppeTxt = new JTextField();
		varegruppeTxt.setBounds(94, 294, 147, 22);
		contentPanel.add(varegruppeTxt);
		varegruppeTxt.setColumns(10);
		varegruppeTxt.addKeyListener(this);

		reolTxt = new JTextField();
		reolTxt.setBounds(397, 69, 38, 22);
		contentPanel.add(reolTxt);
		reolTxt.setColumns(10);
		reolTxt.addKeyListener(this);
		
		hyldeTxt = new JTextField();
		hyldeTxt.setBounds(486, 69, 43, 22);
		contentPanel.add(hyldeTxt);
		hyldeTxt.setColumns(10);
		hyldeTxt.addKeyListener(this);


		afdelingTxt = new JTextField();
		afdelingTxt.setBounds(356, 124, 147, 22);
		contentPanel.add(afdelingTxt);
		afdelingTxt.setColumns(10);
		afdelingTxt.addKeyListener(this);

		antalTxt = new JTextField();
		antalTxt.setBounds(356, 185, 147, 22);
		contentPanel.add(antalTxt);
		antalTxt.setColumns(10);
		antalTxt.addKeyListener(this);

		minAntalTxt = new JTextField();
		minAntalTxt.setBounds(356, 241, 116, 22);
		contentPanel.add(minAntalTxt);
		minAntalTxt.setColumns(10);
		minAntalTxt.addKeyListener(this);

		maxAntalTxt = new JTextField();
		maxAntalTxt.setBounds(356, 294, 116, 22);
		contentPanel.add(maxAntalTxt);
		maxAntalTxt.setColumns(10);
		maxAntalTxt.addKeyListener(this);

		JLabel lblBeskrivelse = new JLabel("Beskrivelse:");
		lblBeskrivelse.setFocusTraversalKeysEnabled(false);
		lblBeskrivelse.setFocusable(false);
		lblBeskrivelse.setBounds(92, 53, 85, 16);
		contentPanel.add(lblBeskrivelse);

		JLabel lblIndkbspris = new JLabel("Indk\u00F8bspris:");
		lblIndkbspris.setFocusTraversalKeysEnabled(false);
		lblIndkbspris.setFocusable(false);
		lblIndkbspris.setBounds(92, 108, 85, 16);
		contentPanel.add(lblIndkbspris);

		lblSalgspris = new JLabel("Salgspris:");
		lblSalgspris.setFocusable(false);
		lblSalgspris.setFocusTraversalKeysEnabled(false);
		lblSalgspris.setBounds(94, 169, 83, 16);
		contentPanel.add(lblSalgspris);

		lblNewLabel = new JLabel("Varenummer:");
		lblNewLabel.setFocusTraversalKeysEnabled(false);
		lblNewLabel.setFocusable(false);
		lblNewLabel.setBounds(94, 227, 103, 16);
		contentPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Varegruppe:");
		lblNewLabel_1.setFocusTraversalKeysEnabled(false);
		lblNewLabel_1.setFocusable(false);
		lblNewLabel_1.setBounds(94, 276, 103, 16);
		contentPanel.add(lblNewLabel_1);

		lblLokation = new JLabel("Lokation:");
		lblLokation.setFocusTraversalKeysEnabled(false);
		lblLokation.setFocusable(false);
		lblLokation.setBounds(356, 53, 56, 16);
		contentPanel.add(lblLokation);

		lblAfdeling = new JLabel("Afdeling:");
		lblAfdeling.setFocusTraversalKeysEnabled(false);
		lblAfdeling.setFocusable(false);
		lblAfdeling.setBounds(356, 108, 56, 16);
		contentPanel.add(lblAfdeling);

		lblNewLabel_2 = new JLabel("Antal:");
		lblNewLabel_2.setFocusTraversalKeysEnabled(false);
		lblNewLabel_2.setFocusable(false);
		lblNewLabel_2.setBounds(356, 169, 56, 16);
		contentPanel.add(lblNewLabel_2);

		lblMinAntal = new JLabel("Min. antal:");
		lblMinAntal.setFocusTraversalKeysEnabled(false);
		lblMinAntal.setFocusable(false);
		lblMinAntal.setBounds(356, 227, 92, 16);
		contentPanel.add(lblMinAntal);

		lblMaxAntal = new JLabel("Max. antal:");
		lblMaxAntal.setFocusTraversalKeysEnabled(false);
		lblMaxAntal.setFocusable(false);
		lblMaxAntal.setBounds(356, 276, 92, 16);
		contentPanel.add(lblMaxAntal);

		leverandørTxt = new JTextField();
		leverandørTxt.setBounds(356, 355, 147, 22);
		contentPanel.add(leverandørTxt);
		leverandørTxt.setColumns(10);
		leverandørTxt.addKeyListener(this);

		lblLeverandr = new JLabel("Leverand\u00F8r:");
		lblLeverandr.setFocusTraversalKeysEnabled(false);
		lblLeverandr.setFocusable(false);
		lblLeverandr.setBounds(356, 337, 116, 16);
		contentPanel.add(lblLeverandr);

		lblNyVare = new JLabel("Rediger vare");
		lblNyVare.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNyVare.setBounds(251, 13, 147, 16);
		contentPanel.add(lblNyVare);
		
		JLabel lblReol = new JLabel("Reol:");
		lblReol.setBounds(356, 72, 38, 16);
		contentPanel.add(lblReol);
		
		JLabel lblHylde = new JLabel("Hylde:");
		lblHylde.setBounds(447, 72, 38, 16);
		contentPanel.add(lblHylde);
		
		DropDownList<Supplier> list = new DropDownList<>(leverandørTxt, scrollPane, productCtrl.getAllSuppliers(), new SupplierAdaptor());
		list.emptyTextEqualsNoList(false);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void loadTextFields(StockProduct stockproduct) {
		Product product = stockproduct.getProduct();
		beskrivelseTxt.setText(product.getDescription());
		indkøbsprisTxt.setText(String.valueOf(product.getPurchasePrice()));
		salgsprisTxt.setText(String.valueOf(product.getSalePrice()));
		varenummerTxt.setText(String.valueOf(product.getProductNumber()));
		varegruppeTxt.setText(product.getProductGroup());
		reolTxt.setText(stockproduct.getPlacement().substring(5, 6));
		hyldeTxt.setText(stockproduct.getPlacement().substring(15,16));
		afdelingTxt.setText(stockproduct.getLocation());
		antalTxt.setText(String.valueOf(stockproduct.getQty()));
		minAntalTxt.setText(String.valueOf(product.getMinAmount()));
		maxAntalTxt.setText(String.valueOf(product.getMaxAmount()));
		leverandørTxt.setText(product.getSupplier().getName());
		this.stockproduct = stockproduct;
	}


	
}
