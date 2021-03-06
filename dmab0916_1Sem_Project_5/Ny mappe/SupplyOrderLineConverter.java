package gui;

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
		return " Vare:  " + p.getDescription() + "  Orderantal: " + (p.getMaxAmount() - p.getQuantity()) + " Stk-pris: " + p.getPurchasePrice() + " Totalpsris :" + ((p.getMaxAmount()-p.getQuantity()) * p.getPurchasePrice()) + sl.isRecieved();
	}
}
