package ui.gui;

import model.Customer;
import model.Product;
import ui.libGUI.DropDownListAdaptorIF;


public class ProductAdaptor implements DropDownListAdaptorIF<Product> {


	@Override
	public String displayObjectInList(Product p) {

		return p.getProductNumber() + "  -  " + p.getDescription();
		
	}

	@Override
	public String getIdentifier(Product p) {
		return p.getProductNumber();
		
	}

	@Override
	public String displaySelectedObjectInTextfield(Product p) {
		return p.getProductNumber();
	}

}
