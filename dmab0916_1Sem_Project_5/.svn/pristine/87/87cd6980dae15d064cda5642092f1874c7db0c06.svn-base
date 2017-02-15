package ui.gui;

import controller.CustomerCtrl;
import model.Customer;
import ui.libGUI.DropDownListAdaptorIF;
import ui.libTUI.*;

public class CustomerAdaptor implements DropDownListAdaptorIF<Customer> {

	@Override
	public String displayObjectInList(Customer c) {
		return c.getPhone() + "  -  " + c.getName();
	}

	@Override
	public String getIdentifier(Customer c) {
		return c.getPhone();
	}

	@Override
	public String displaySelectedObjectInTextfield(Customer c) {
		return c.getPhone();
	}
	


}
