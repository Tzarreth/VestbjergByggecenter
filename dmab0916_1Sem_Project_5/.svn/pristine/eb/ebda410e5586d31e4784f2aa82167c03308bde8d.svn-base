package ui.gui;

import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;

import model.Order;
import model.Product;
import model.StockProduct;

public class MyTableOrder extends DefaultTableModel {
		private static final long serialVersionUID = 1L;
		private ArrayList<Order> orders;
		private Order order;

		public MyTableOrder(){
			orders = new ArrayList<>();
		}

		@Override
		public int getColumnCount(){
			return 4;
		}

		@Override
		public int getRowCount(){
			return orders == null ? 0 : orders.size();
		}

		@Override
		public String getColumnName(int ix) {
			System.out.print("getColumnName(" + ix + ") ");
			switch(ix) {
		/*	case 0: System.out.println("Registreringsdato"); return "Registreringsdato";
			case 1: System.out.println("Pakke dato");return "Pakke dato";
			case 2: System.out.println("Afsendelse dato");return "Afsendelse dato";
			case 3: System.out.println("Betalings dato");return "Betalings dato"; */
			case 0: System.out.println("Vare");return "Vare";
			case 1: System.out.println("Antal"); return "Antal";
			case 2: System.out.println("Total Pris");return "Total pris";
			case 3 : System.out.println("Kunde");return "Kunde";
			default: System.out.println("???");return "???";
			}
		}

		@Override
		public Object getValueAt(int row, int col){
			
			switch(col){
		/*	case 0: return orders.get(row).getRegDate();
			case 1: return orders.get(row).getPackDate();
			case 2: return orders.get(row).getSendDate();
			case 3: return orders.get(row).getPayDate(); */
			case 0: return orders.get(row).getProducts();
			case 1: return orders.get(row).getAmount();
			case 2: return orders.get(row).getTotalPrice();
			case 3: return orders.get(row).getCustomer().getName();
			default: return null;
			}
		}
		
		
		public void setData(ArrayList<Order> data) {
			this.orders = data;
			super.fireTableDataChanged();
		}

		public Order getData(int selectedRow) {
			if(selectedRow >= 0 && selectedRow < orders.size()) {
				return this.orders.get(selectedRow);
			}
			return null;
		}
}
