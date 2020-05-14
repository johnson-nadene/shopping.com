package application;

public class Process {
	double price;
	double taxable;
	int qty;
	double shipping;
	
	public Process() {
	}
	public Process(double price, double taxable, int qty, double shipping) { // constructor
		this.price = price;
		this.taxable = taxable;
		this.qty = qty;
		this.shipping = shipping;
	}
	
	public double getPrice() { //Get price
		return price;
	}
	public double isTaxable() { //Get taxable
		return taxable;
	}
	public int getQty() { //Get qty
		return qty;
	}
	public double getShippig() { //Get shipping
		return qty;
	}
	public void setPrice(double price) { //Set price
		this.price = price;
	}
	public void setTaxable(double taxable) { //Set taxable
		this.taxable = taxable;
	}
	public void setQty(int qty) { //Set qty
		this.qty = qty;
	}
	public void setShippig(double shipping) { //Set Shipping
		this.shipping = shipping;
	}
	public double getTotalDue() { // method to get the future value
		double totalDue = (price * qty * taxable) + (price * qty) + shipping; 
		return totalDue;
	}
}
