package ui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import controller.ProductCtrl;
import controller.SaveAndLoadFromFile;
import controller.StockCtrl;
import model.Product;
import model.Supplier;
import ui.libGUI.DropDownList;
import java.awt.event.KeyAdapter;

public class NewProductView extends JDialog implements KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField beskrivelseTxt, indkøbsprisTxt, salgsprisTxt, varenummerTxt, varegruppeTxt, reolTxt, hyldeTxt, afdelingTxt, antalTxt, minAntalTxt, maxAntalTxt, leverandørTxt;
	private JLabel lblSalgspris, lblNewLabel, lblNewLabel_1, lblLokation, lblAfdeling, lblNewLabel_2, lblMinAntal, lblMaxAntal, lblLeverandr, lblNyVare;

	private ProductCtrl pCtrl = new ProductCtrl();
	private StockCtrl sCtrl = new StockCtrl();
	private JButton okButton;
	private JScrollPane scrollPane;
	private JPanel buttonPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewProductView dialog = new NewProductView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewProductView() {
		frameSetup();
		paneSetup();
		buttonSetup();
	}
	
	private void paneSetup() {
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

		lblNyVare = new JLabel("Ny vare");
		lblNyVare.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNyVare.setBounds(251, 13, 147, 16);
		contentPanel.add(lblNyVare);
		
		JLabel lblReol = new JLabel("Reol:");
		lblReol.setBounds(356, 72, 38, 16);
		contentPanel.add(lblReol);
		
		JLabel lblHylde = new JLabel("Hylde:");
		lblHylde.setBounds(447, 72, 38, 16);
		contentPanel.add(lblHylde);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(201, 324, 144, 79);
		contentPanel.add(scrollPane);
		
		DropDownList<Supplier> list = new DropDownList<Supplier>(leverandørTxt, scrollPane, pCtrl.getAllSuppliers(), new SupplierAdaptor());
		
			buttonPane = new JPanel();
			buttonPane.setBounds(12, 425, 536, 35);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				okButton = new JButton("OK");
				okButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER && okButton.hasFocus()){
							okButtonClicked();
						}
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonClicked();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				//getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		list.emptyTextEqualsNoList(false);
		contentPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{beskrivelseTxt, indkøbsprisTxt, salgsprisTxt, varenummerTxt, varegruppeTxt, reolTxt, hyldeTxt, afdelingTxt, antalTxt, minAntalTxt, maxAntalTxt, leverandørTxt, okButton, }));
	}

	private void buttonSetup() {

	}

	protected void okButtonClicked() {
		try{
			String description = beskrivelseTxt.getText();
			double purchasePrice = Double.parseDouble(indkøbsprisTxt.getText());
			double salePrice = Double.parseDouble(salgsprisTxt.getText());
			String productNumber = varenummerTxt.getText();
			String productGroup = varegruppeTxt.getText();
			int quantity = Integer.parseInt(antalTxt.getText());
			int minAmount = Integer.parseInt(minAntalTxt.getText());
			int maxAmount = Integer.parseInt(maxAntalTxt.getText());
			Supplier supplier = pCtrl.findSupplierByName(leverandørTxt.getText());
			String placement = "Reol " + reolTxt.getText() + " : Hylde " + hyldeTxt.getText();
			String location = afdelingTxt.getText();
			
			if (supplier != null){
			Product p = pCtrl.createProduct(purchasePrice, salePrice, productNumber, description, productGroup, location, quantity, minAmount, maxAmount, supplier);
			sCtrl.createStockProduct(p, placement, location);
			SaveAndLoadFromFile save = new SaveAndLoadFromFile();
			save.saveAll();
			this.setVisible(false);
			this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(contentPanel, "Leverandør ikke kendt!");
			}
			

		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(contentPanel, "Felter ikke udfyld korrekt!  (" + e.getMessage() +")");
		}
		StockView.myTable.setData(sCtrl.getAllStockProducts());
	}


	private void frameSetup() {
		setBounds(100, 100, 593, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			getFocusOwner().transferFocus();
		}

	}
	
	
}
