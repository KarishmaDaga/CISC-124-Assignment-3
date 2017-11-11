import java.io.Serializable;

public class LineItem implements Comparable<LineItem>, Serializable {
	/**
	 * A class to store the methods and constructors for LineItem, which represents a single Pizza order.
	 * 
	 * This version demonstrates the implementation of Serializable (for filing) and Comparable (for sorting). 
	 * 
	 * @author Karishma Daga
	 */
	private static final long serialVersionUID = -34501450671151163L;
	
	private Pizza aPizza; //Pizza object ordered
	private int numOrdered; //Number of those Pizza objects ordered
	
	/**
	 * Full parameter constructor for a single LineItem (Pizza order).
	 * @param numOrdered The number of identical pizzas ordered.
	 * @param pizza The pizza object that is ordered.
	 * @throws IllegalPizza if an illegal line item is created
	 */
	public LineItem(int numOrdered, Pizza pizza) throws IllegalPizza{
		setNumber(numOrdered);
		setPizza(pizza);
	}
	/**
	 * One parameter constructor for a LineItem with a single pizza ordered 
	 * @param pizza The pizza ordered
	 * @throws IllegalPizza if an illegal line item is created
	 */
	public LineItem(Pizza pizza) throws IllegalPizza {
		numOrdered = 1; //sets amount of Pizzas ordered to 1
		setPizza(pizza);
	}
	
	/**
	 * Mutator to set the number of Pizza objects ordered.
	 * @param num The number of identical pizzas ordered.
	 * @throws IllegalPizza if an illegal line item is created.
	 */
	public void setNumber(int num) throws IllegalPizza {
		// Checks if the number of Pizzas ordered is greater than 100 or less than 1
		if ((num > 100) || (num < 1)) {
			throw new IllegalPizza("Illegal Number: " + num);
		// Checks if the number of Pizzas ordered is 0/null
		} else if (num == 0){
			throw new IllegalPizza("Illegal Number: " + num);
		} else {
			this.numOrdered = num;
		}
	}
	
	/**
	 * Mutator to set the Pizza object ordered.
	 * @param pizza The Pizza object ordered
	 * @throws IllegalPizza if an illegal line item is created
	 */
	private void setPizza(Pizza pizza) throws IllegalPizza{
		// Checks if the Pizza object is null
		if (pizza == null) {
			throw new IllegalPizza("Illegal Pizza: " + pizza);
		} else {
			this.aPizza = pizza;
		}
	}
	/**
	 * Getter for the number of Pizzas ordered
	 * @return numOrdered
	 */
	public int getNumber() {
		return numOrdered;
	}
	
	/**
	 * Getter for the Pizza ordered
	 * @return
	 */
	public Pizza getPizza() {
		return aPizza;
	}
	
	/**
	 * Getter for the cost of the LineItem order.
	 * @return the total cost for the order, including discounts for certain orders depending on the number of Pizzas ordered.
	 */
	public double getCost() {
		// Standard total cost
		double totalCost = (aPizza.getCost()) * numOrdered ;
		// Discounts 15% if the number of Pizzas ordered is greater than 20
		if (numOrdered > 20) {
			totalCost = totalCost*0.85;
		// Discounts 10% if the number of Pizzas ordered is greater than or equal to 10 and less than or equal to 20 
		} else if (numOrdered >= 10 && numOrdered <= 20) {
			totalCost = totalCost*0.9;
		} else {
		}
		return totalCost;
	}
	
	/**
	 *  Compares the price of two orders. If the difference is around a dollar, 
	 *  the difference is considered to be negligible/zero
	 */
	public int compareTo(LineItem otherLine) {
		// Calculates the difference
		double difference = otherLine.getCost() - this.getCost();
		// Checks if the difference is negligible
		if ( (difference < 1) && (difference > 0)) {
			difference = 0;
		} else {
			difference = (int)(difference);
		}
		return (int) difference;
	}
	
	/**
	 * toString returns the cost of the order and the information about the Pizza and individual cost
	 * @return lineOrderInformation: the information about the order
	 */
	public String toString() {
		// Standard information of an order
		String lineOrderInformation = numOrdered + " " + aPizza.toString();
		// To account for the missing space in order numbers less than 10, a additional space is added before the order number
		if (numOrdered < 10) {
			lineOrderInformation = " " + lineOrderInformation;
		}
		return lineOrderInformation;
	}
	
	
  }
