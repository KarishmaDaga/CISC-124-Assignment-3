import java.io.Serializable;
import java.text.DecimalFormat;

public class Pizza implements Serializable {
	
	/**
	 * A class to store Pizza information (methods and constructors for the Pizza class).
	 * 
	 * This version demonstrates the implementation of Serializable (for filing). 
	 * 
	 * @author Karishma Daga
	 */
	private static final long serialVersionUID = 9061694214731955091L;
	private String sizeOfPizza;
	private String amountOfCheese;
	private String amountOfMushrooms;
	private String amountOfPepperoni;
	
	final double singleTopping = 1.50;
	final double doubleTopping = 3.00;
	
	/**
     * Full parameter constructor.
     * @param sizeOfPizza The size of the pizza. Can only be: "small", "medium", or "large".
     * @param amountOfCheese The amount of cheese on the pizza. Can only be: "single", "double", or "triple".
     * @param amountOfMushrooms The amount of mushrooms on the pizza. Can only be: "none", "single", or "double" if 
     * 							amountOfPepperoni is not none.
     * @param amountOfPepperoni The amount of pepperoni on the pizza. Can only be: "none", "single", or "double".
     * @throws IllegalPizza If the arguments are not legal.
     */
	
    // 4 parameter constructor invokes mutators
	public Pizza(String size, String cheese, String mushrooms, String pepperoni) throws IllegalPizza{
		// Checks for the case of when a Pizza is created with null values for the parameters and 
		// throws an IllegalPizza exception
		if ( (size == null) && (cheese == null) && (mushrooms == null) && (pepperoni == null) ) {
			throw new IllegalPizza("IllegalPizza: " + size);
		} else {
		// The following mutators set the values for the parameters
		setSize(size);
		setCheese(cheese);
		setPepperoni(pepperoni);
		setMushrooms(mushrooms, pepperoni);
		}
	}    // end Pizza 4 parameter constructor
	
	/**
	 *  Creates a standard pizza of size small, single cheese, no mushrooms, and single pepperoni.
	 *  @throws IllegalPizza
	 */
	public Pizza() throws IllegalPizza {
		this("small","single","none","single");
	}
	
	/**
	 *  Mutators for Pizza class parameters
	 */
	
	/**
     * Mutator for the size of the pizza.
     * @param size of the pizza.
     * @throws IllegalPizza if the size of the pizza is null, "", or not small/medium/large
     */
	private void setSize(String size) throws IllegalPizza{
		// Checks if the size parameter is null or ""
		if ( (size == null) || (size.equals(""))) {  
			throw new IllegalPizza("Illegal Pizza: " + size);
		// Checks if the size parameter is not a valid type of size
		} else if ( (!size.equalsIgnoreCase("small")) && (!size.equalsIgnoreCase("medium")) 
				     && (!size.equalsIgnoreCase("large")) ) {  
			throw new IllegalPizza("Illegal Pizza: " + size);
		} else {
			this.sizeOfPizza = size.toLowerCase();
		}
	}
	
	/**
     * Mutator for the amount of cheese on the pizza.
     * @param cheese The parameter for the amount of cheese for the pizza.
     * @throws IllegalPizza if the cheese is null, "", or not single/double/triple.
     */
	private void setCheese(String cheese) throws IllegalPizza{
		// Checks if the cheese parameter is null or "", making it invalid
		if ( (cheese == null) || cheese.equals("")) {
			throw new IllegalPizza("Illegal Pizza: " + cheese);
		// Checks if the cheese parameter is not a valid amount (not single/double/triple)
		} else if ( (!cheese.equalsIgnoreCase("single")) && (!cheese.equalsIgnoreCase("double")) && (!cheese.equalsIgnoreCase("triple")) ) {
			throw new IllegalPizza("IllegalPizza: " + cheese);
		} else {
			this.amountOfCheese = cheese.toLowerCase();
		}
	}
	
	/**
     * Mutator for setting the amount of mushrooms on the pizza.
     * @param mushrooms The parameter for the amount of mushrooms for the pizza.
     * @throws IllegalPizza if the mushrooms parameter is null, "", and not none/single/double if pepperoni is not invalid.
     */
	private void setMushrooms(String mushrooms, String pepperoni) throws IllegalPizza{
		// Checks if mushrooms are null or ""
		if ( (mushrooms == null) || mushrooms.equals("")) {
			throw new IllegalPizza("Illegal Pizza: " + mushrooms);
		
		// Checks if the mushroom value is not valid for single/double/none.
		} else if ( (!mushrooms.equalsIgnoreCase("single")) && 
				    (!mushrooms.equalsIgnoreCase("double")) && 
				    (!mushrooms.equalsIgnoreCase("none")) )  {
						throw new IllegalPizza("IllegalPizza: " + mushrooms);
						
		// Checks if the value for pepperoni is null or "" since the value of a mushroom depends on the amount of pepperoni
		} else if ( (pepperoni.equals("")) || (pepperoni == null) ) {
			throw new IllegalPizza("IllegalPizza: " + mushrooms);
		
		// Checks if pepperoni has value "none" and mushroom is not none. This is an invalid case.
		} else if ( (pepperoni.equalsIgnoreCase("none"))  && (!mushrooms.equalsIgnoreCase("none"))) {
			throw new IllegalPizza("IllegalPizza: " + mushrooms);
		} else {
			this.amountOfMushrooms = mushrooms.toLowerCase();
		}
	}
	
	/**
     * Mutator for setting the amount of mushrooms on the pizza.
     * @param pepperoni The parameter for the amount of pepperoni for the pizza.
     * @throws IllegalPizza if the pepperoni parameter is null, "", and not none/single/double.
     */
	private void setPepperoni(String pepperoni) throws IllegalPizza{
		// Checks if pepperoni parameter is null or ""
		if ( (pepperoni == null) || pepperoni.equals("")) {
			throw new IllegalPizza("Illegal Pizza: " + pepperoni);
			// Checks if the pepperoni parameter is not a valid type (not single/double/none).
		} else if ( (!pepperoni.equalsIgnoreCase("single")) && 
				    (!pepperoni.equalsIgnoreCase("double")) && 
				    (!pepperoni.equalsIgnoreCase("none")) ) {
						throw new IllegalPizza("IllegalPizza: " + pepperoni);
		} else {
			this.amountOfPepperoni = pepperoni.toLowerCase();
		}
	}
	
	
	
	/**`
	 * Gets total cost of an instance of a Pizza
	 * Returns the total cost as a double value using the methods .sizeCost() and toppingCost(topping) 
	 */
	public double getCost() {
		// getSizeCost() returns the cost of the pizza's size and it's amount of cheese
		// getToppingCost(topping) returns the cost of all of the toppings selected (mushrooms and pepperoni)
		double cost = this.sizeCost() + toppingCost(amountOfMushrooms) + toppingCost(amountOfPepperoni);
		return cost;
	}
		
	/**
	 *  Gets the cost for the size of a pizza and it's amount of cheese. Returns the cost as a double.
	 */
	public double sizeCost() {
		double costOfSize = 0.00;
		String size = this.sizeOfPizza;
		String cheese = this.amountOfCheese;
			
		// gets cost of the standard pizza of a certain size, assuming single cheese
			if (size.equals("small")) {
				costOfSize = 7.00;
			} else if (size.equals("medium")) {
				costOfSize = 9.00;
			} else {
				costOfSize = 11.00;
			}
			
		// if the cheese amount is greater than a single, the pizza is charged additional costs
			if (cheese.equals("double")) {
				costOfSize += singleTopping;
			} else if (cheese.equals("triple")) {
				costOfSize += doubleTopping;
			} else {
				costOfSize += 0.00;
			}
			return costOfSize;
	}
	
	/**
	 *  toppingCost sums the topping cost based on the amounts of the topping parameter provided.
	 */
	public double toppingCost(String topping) {
		double toppingCost = 0.00;
		// switches based on the topping parameter's value (single/double/none)
		switch (topping) {
		case "single":
			toppingCost += singleTopping;
			break;
		case "double":
			toppingCost += doubleTopping;
			break;
		default:
			toppingCost += 0.00;
			break;
		}
		return toppingCost;
	}
	
	/**
	 *  toString() retrieves a single line with all of the information concerning the instance of a pizza
	 *  
	 */
	public String toString() {
		// Creates a temporary string to hold all of the information
		String orderInformation = "";
		
		// DecimalFormat creates a formatter so that the cost appears like a decimal
		DecimalFormat df = new DecimalFormat("0.00");
		orderInformation += sizeOfPizza + " pizza, " + amountOfCheese + " cheese, " + toNone(amountOfMushrooms) + " mushrooms, " 
							+ toNone(amountOfPepperoni) + " pepperoni" + ". Cost: $" + df.format(this.getCost()) + " each.";
		return orderInformation;
	}

	/**
	 * If a topping has not been selected for a pizza (so it's value is "none"), the method returns the string "no" in place 
	 * of "none" for toString()
	 * @param topping The amount of a topping (either mushroom or pizza)
	 * @return "no" if the selected topping has the value "none"
	 */
	public String toNone(String topping) {
		String tempString;
		if (topping.equals("none")) {
			tempString = "no";
		} else {
			tempString = topping;
		}
		return tempString;
	}
	
	/**
	 * Boolean method equals compares the equality of two Pizza objects
	 * @param Object otherPizza: The second pizza object to be compared
	 * @return the boolean equal: true if they are equal, and false if they are not equal
	 */
	@Override
	public boolean equals(Object otherPizza) {
	   boolean equal = false;
	   // Checks the equality of the two Pizza object only if the second object is an instance of Pizza
       if (otherPizza instanceof Pizza) {
    	   Pizza otherP = (Pizza)otherPizza;
    	   if ( (sizeOfPizza.equalsIgnoreCase(otherP.sizeOfPizza)) 
    			 && (amountOfCheese.equalsIgnoreCase(otherP.amountOfCheese)) 
    			 && (amountOfMushrooms.equalsIgnoreCase(otherP.amountOfMushrooms))
    			 && (amountOfPepperoni.equalsIgnoreCase(otherP.amountOfPepperoni)) ) {
    		   equal = true;
    	   } else {
    		   equal = false;
    	   }
       }
	   return equal;
	}// end of equals();

	/**
	 *  Clones a Pizza object by creating a new Pizza objects with the same attribute values.
	 *  @exception IllegalPizza if the attribute values are illegal
	 *  @return cloned pizza object.
	 */
	public Pizza clone() {
		// creates a pizza object without setting the attribute values
		Pizza pizzaCopy = null;
		try {
			pizzaCopy = new Pizza(sizeOfPizza, amountOfCheese, amountOfMushrooms, amountOfPepperoni);
		} catch (IllegalPizza e) {
			return null;
		}
		return pizzaCopy;
	}
	
	
}
