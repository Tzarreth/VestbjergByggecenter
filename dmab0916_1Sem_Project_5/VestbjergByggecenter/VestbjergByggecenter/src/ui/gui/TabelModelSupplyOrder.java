package ui.gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controller.SupplyOrderCtrl;
import model.Product;

public class TabelModelSupplyOrder extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> products;
	private ArrayList<Boolean> selections;
	private SupplyOrderCtrl sCtrl = new SupplyOrderCtrl();

	public TabelModelSupplyOrder(){
		products = new ArrayList<>();
		selections = new ArrayList<>();
		loadSelections();
	}

	private void loadSelections() {
		for (int i = 0; i < products.size(); i++){
			selections.add(false);
		}
	}

	@Override
	public int getColumnCount(){
		return 6;
	}

	@Override
	public int getRowCount(){
		return products == null ? 0 : products.size();
	}

	@Override
	public String getColumnName(int ix) {
		System.out.print("getColumnName(" + ix + ") ");
		switch(ix) {
		case 0: return "Varenummer";
		case 1: return "Beskrivelse";
		case 2: return "Antal";
		case 3: return "Pris pr. stk";
		case 4: return "Pris total";
		case 5: return "Selection";
		default: System.out.println("???");return "???";
		}
	}

	@Override
	public Object getValueAt(int row, int col){
		switch(col){
		case 0: return products.get(row).getProductNumber();
		case 1: return products.get(row).getDescription();
		case 2: return sCtrl.amountToReorder(products.get(row));
		case 3: return products.get(row).getPurchasePrice();
		case 4: return sCtrl.getTotalPrice(products.get(row));
		case 5: return selections.get(row);
		default: return null;
		}
		/*if (col == 0){
			return Products.get(row).getName();
		}
		else {
			return Products.get(row).getLines().size();
		}*/
	}

	public void setData(ArrayList<Product> data) {
		this.products = data;
		loadSelections();
		super.fireTableDataChanged();
	}

	public Product getData(int selectedRow) {
		if(selectedRow >= 0 && selectedRow < products.size()) {
			return this.products.get(selectedRow);
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 5){
			return true;
		}
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		if (aValue instanceof Boolean && column == 5) {
			selections.set(row, (boolean)aValue);
		}
		/*if (aValue instanceof Boolean && column == 5) {
			System.out.println(aValue);
			@SuppressWarnings("rawtypes")
			Vector rowData = (Vector)getDataVector().get(row);
			rowData.set(5, (boolean)aValue);
			super.fireTableDataChanged();
		}*/
	}

	@Override
	public Class<?> getColumnClass(int column) {
		switch (column) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Integer.class;
		case 3:
			return Double.class;
		case 4: 
			return Double.class;
		case 5:
			return Boolean.class;
		default: return String.class;    
		}
	}

	public void setAllSelected() {
		setData(products);
		for (int i = 0; i < selections.size(); i++){
			setValueAt(true, i, 5);
		}
	}

	public void SetAllUnselected(){
		setData(products);
		for (int i = 0; i < selections.size(); i++){
			setValueAt(false, i, 5);
		}
	}
}