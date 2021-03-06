package ui.tui;

import ui.libTUI.*;

import model.*;

public class ProductConverter implements ConverterIF<Product>  {

	@Override
	public String convertToString(Product o) {
		if(! (o instanceof Product)) {
			return "[Sorry, not a Product object]";
		}
		Product p = (Product)o;
		return p.getDescription() + "| qty: " +(p.getMaxAmount() - p.getQuantity()) + "| pris pr stk: " + p.getPurchasePrice() + " pris toal: " + ((p.getMaxAmount() - p.getQuantity()) * p.getPurchasePrice());
	}
}
