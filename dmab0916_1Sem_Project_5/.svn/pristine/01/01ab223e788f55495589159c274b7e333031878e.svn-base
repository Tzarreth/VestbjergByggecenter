package ui;
import ui.libTUI.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import controller.*;
import model.*;

public class SupplyOrderUI {
	private ProductConverter pc = new ProductConverter();
	private SupplyOrderLineConverter sc = new SupplyOrderLineConverter();
	private SupplyOrderCtrl soCtrl;
	private HelpText help;
	private TextInput ti = new TextInput();


	public SupplyOrderUI(){
		soCtrl = new SupplyOrderCtrl();
		help = new HelpText();
	}

	/**
	 * Starts the SupplyOrderUI when initiated by the MainMenuUI.
	 */
	public void SupplyOrderMainMenu(){
		boolean running = true;

		while (running) {
			System.out.println("--- Leverandør bestilling ---");
			System.out.println("1. Tjek lager for genbestillinger ");
			System.out.println("2. Varemodtagelse");
			System.out.println("3. Afslut");

			String choice = ti.promptString("Vælg menu: ");
			switch (choice) {
			case "1":
				restockStorage();
				break;
			case "2":
				recieveSupplyOrder();
				break;
			case "3":
				running = false;
				break;
			default:
				help.notExistingCommand();
				break;
			}
		}
	}

	/**
	 * Print a list for the user, which shows the products that needs restocking.
	 * this is all the products that in the inventory is under the minimum amount,
	 * set by an employee on Product class.
	 * @return list of Products that needs restocking.
	 */
	public void restockStorage(){
		TextChoice<Product> tc = new TextChoice<Product>(pc);
		ArrayList<Product> possibleRestockProducts = soCtrl.findPossibleRestockProducts();
		ArrayList<Product> productsToOrder = new ArrayList<>();
		for (Product p : possibleRestockProducts){
			tc.addOption(p);
		}

		boolean selecting = true;
		while(selecting){
			Product p = tc.promptChoiceValidOnly("*******Vare der skal genbestilles:********" + "\n" + "Vælg vare:", "");
			if (p != null){
				productsToOrder.add(p);
				tc.removeOption(p);
			}
			else if (p == null){
				selecting = false;
			}
			else {
				System.out.println("Please enter valid number");
			}

			System.out.println("__________Tilføjet til bestilling:___________ ");
			printProducts(productsToOrder);
			System.out.println("______________________________________________");
		}
		approveOrder(productsToOrder);	
	}

	/**
	 * Shows the user an Order of the product which the user has chosen. Prompts the user for confirmation
	 * that the chosen and shown Products is to be ordered.
	 * @param ArrayList<ProductsToOrder> is a list of the Products the user has chosen for restocking.
	 */
	public void approveOrder(ArrayList<Product> productsToOrder){
		System.out.println("-----------------BESTILLINGS ORDER ------------------");
		HashMap<Supplier, SupplyOrder> map = soCtrl.sendApprovedProductsToOrder(productsToOrder); //TODO 
		printSupplyOrders(map);
		System.out.println("-----------------------------------------------------");
		boolean confirmed = false;
		while(!confirmed){
		String answer = ti.promptString("Bekræft Order(y/n)");
		if (answer.equals("y")){
			System.out.println("****************************************");
			System.out.println("*****      Order er afsendt       ******");
			System.out.println("****************************************");
			confirmed = true;
		}
		else if (answer.equals("n")){
			System.out.println("Order er afbrudt");
			confirmed  = true;
		}
		else{
			System.out.println("Tast y eller n");
		}
		}
	}

	/**
	 * prints the Products, sorted by Supplier, that the user chose in the method approveOrder().
	 * This prints a good overview of the Products that the user needs to confirm for order.
	 * @HashMap<Supplier, SupplyOrder> 	
	 */
	private void printSupplyOrders(HashMap<Supplier, SupplyOrder> map) {
		Set<Supplier> suppliers = map.keySet();
		int y= 1;
		int i = 1;
		for (Supplier s : suppliers){
			System.out.println(i + ")**********" + map.get(s).getSupplier().getName()+"************");
			ArrayList<SupplyOrderLine> sol = map.get(s).getSupplyOrderLines();

			for (SupplyOrderLine sl : sol){
				Product p = sl.getProduct();
				System.out.println(y + sc.convertToString(sl));
				y++;
			}
			i++;
		}
	}

	/**
	 * print the individual products for the user to view, so its easier to see every needed information
	 * about how many items is being ordered, and the deltotal for that product
	 * @param ArrayList<array> is the array of products.
	 */
	public void printProducts(ArrayList<Product> array){
		int total = 0;
		for (Product p : array){
			System.out.println("-" + pc.convertToString(p) );
			total += (p.getPurchasePrice() * (p.getMaxAmount() - p.getQuantity()));
		}
		System.out.println("____________________");
		System.out.println("DelTotal:  " +total);

	}

	/**
	 * Gives the user an interface, where the user can see a list of orders that have not yet
	 * been recieved.
	 * This interface gives the options for the user to mark orders as recieved, when they 
	 * recieve them for stock.
	 */
	public void recieveSupplyOrder(){
		boolean running = true;
		while(running){
			TextChoice<SupplyOrderLine> tc = new TextChoice<SupplyOrderLine>(sc);
			ArrayList<SupplyOrderLine> sol = soCtrl.getNotRecievedSupplyOrderLines();
			for (SupplyOrderLine s : sol){
				tc.addOption(s);
			}

			SupplyOrderLine tempS = tc.promptChoiceValidOnly("*********** Varemodtagelse **********", "Vælg vare");
			if (tempS == null){
				running = false;
			}
			else{	
				soCtrl.setSOLToRecieved(tempS);

			}
		}
	}
}
