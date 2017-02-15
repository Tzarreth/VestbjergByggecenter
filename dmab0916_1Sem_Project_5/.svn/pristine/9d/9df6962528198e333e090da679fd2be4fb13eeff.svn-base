package ui.gui;

import model.Product;
import model.SupplyOrderLine;
import ui.libTUI.ConverterIF;

public class SupplyOrderLineConverter implements ConverterIF<SupplyOrderLine> {

	@Override
	public String convertToString(SupplyOrderLine sl) {
		if(! (sl instanceof SupplyOrderLine)) {
			return "[Sorry, not a Product object]";
		}
		Product p = sl.getProduct();
		return "-Vare:  " + p.getDescription()  + tab(20,p.getDescription()) + "Orderantal:  " + (p.getMaxAmount() - p.getQuantity()) + tab(5, String.valueOf(p.getMaxAmount() - p.getQuantity()))  + "Stk-pris:  " + p.getPurchasePrice()  + tab(7,Double.toString(p.getPurchasePrice()))+  "Totalpsris: " + ((p.getMaxAmount()-p.getQuantity()) * p.getPurchasePrice()); 
	
	}
	
	public String tab(int tabLength, String word){
		int spaceLength = tabLength - word.length();
		String res = "";
		for (int i = 0; i < spaceLength; i++){
			res += " ";
		}
		return res;
	}
}
