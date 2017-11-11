
public class IllegalPizza extends Exception{

	/**
	 * A class to store the IllegalPizza exception.
	 * 
	 * This version demonstrates the implementation of Exception, Serializable (for filing), and is used extensively throughout
	 * the Pizza class and LineItem to catch the illegal formation of Pizza objects. 
	 * 
	 * @author Karishma Daga
	 */
	private static final long serialVersionUID = -5935590159508055457L;

	/** Exception method for an illegal Pizza object
	 *  @return The message that an Illegal parameter was supplied to a Pizza constructor.
	 */
	public IllegalPizza() {
		
		super("Illegal parameter value supplied to Pizza object.");
	}
	
	/** Exception method for an illegal Pizza object
	 *  @return A custom message
	 */
	public IllegalPizza(String message) {
		super(message);
	}
}
