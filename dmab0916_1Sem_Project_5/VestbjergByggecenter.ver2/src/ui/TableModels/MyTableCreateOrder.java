package ui.TableModels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Order;
import model.OrderLine;
import model.Product;

import model.Order;

public class MyTableCreateOrder extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<OrderLine> orders;
	private ArrayList<Boolean> selections;
	private Order order;
	
	public MyTableCreateOrder(){
		orders = new ArrayList<>();
		selections = new ArrayList<>();
	}

	
	@Override
	public int getColumnCount(){
		return 6;
	}

	@Override
	public int getRowCount(){
		return orders == null ? 0 : orders.size();
	}
	
	@Override
	public String getColumnName(int ix) {
		System.out.print("getColumnName(" + ix + ") ");
		switch(ix) {
		case 0: System.out.println("Beskrivelse");return "Beskrivelse";
		case 1: System.out.println("Varenummer"); return "Varenummer";
		case 2: System.out.println("Pris"); return "Pris";
		case 3: System.out.println("Antal"); return "Antal";
		case 4: System.out.println("Total Pris"); return "Total Pris"; 
		case 5: return "";
		default: System.out.println("???");return "???";
		}
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 3 || column == 5){
			return true;
		}
		return false;
	}


	@Override
	public Object getValueAt(int row, int col){
		switch(col){
		case 0: return orders.get(row).getProduct().getDescription();
		case 1: return orders.get(row).getProduct().getProductNumber();
		case 2: return orders.get(row).getProduct().getSalePrice();
		case 3: return orders.get(row).getAmount();
		case 4: return (orders.get(row).getAmount()) * (orders.get(row).getProduct().getSalePrice());
		case 5: return (boolean)selections.get(row);
		default: return null;
		}
	}

	
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		if(column == 3){
			orders.get(row).setAmount((int) aValue);
		}
		
		if (column == 5){
			selections.set(row, (boolean)aValue);
		}
		setData(orders);
	}
	
	public void setData(ArrayList<OrderLine> data) {
		this.orders = data;
		if (orders != null){
			
		for(int i = 0; i < orders.size(); i++){
			selections.add(false);
		}

		}
		super.fireTableDataChanged();
	}
	
	@Override
	public Class<?> getColumnClass(int column) {
		switch (column) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Double.class;
		case 3:
			return Integer.class;
		case 4: 
			return Double.class;
		case 5:
			return Boolean.class;
		default: return String.class;    
		}
	}

	public OrderLine getData(int selectedRow) {
		if(selectedRow >= 0 && selectedRow < orders.size()) {
			return this.orders.get(selectedRow);
		}
		return null;
	}
	
	@Override
	public void removeRow(int row){
		orders.remove(row);
		setData(orders);
		
	}
	
	public boolean isTableselected(){
		for (boolean b : selections){
			if(b == true){
				return true;
			}
		}
		return false;
	}
	

	
	

}
