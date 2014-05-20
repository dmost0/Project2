import java.util.Scanner; // Gathers input from the user
import java.text.NumberFormat; // Formats output into currency form
/**
 */
public class FlowerDeliveryService {

	/**
	 * Begins the FlowerDeliveryService program. 
	 * This program gathers input from the user for a bouquet. Afterward the program calculates and prints the cost of this bouquet with included tax and delivery charges.
	 */
	public static void main(String[] args) {
		// Declare variables
		Scanner input = new Scanner(System.in); // Gathers input from the user
		String bouquetSize; // Holds the size of the bouquet
		boolean invalidInput; // true if input is invalid
		boolean keepGoing; // true if user wishes to repeat the program
		int roses; // Holds rose amount
		int lilies; // Holds lily amount
		int carnations; // holds carnation amount
		NumberFormat format = NumberFormat.getCurrencyInstance(); // creates a instance of NumberFormat
		
		// Print header
		System.out.println("\t\tFLOWER DELIVERY SERVICE");
		
		// start main loop at least once
		do{
			keepGoing = false; // Assume user does not wish to repeat the program
			System.out.println("\n");
			// Get input from user for bouquet size
			do{
				invalidInput = false; // assume input is valid
				System.out.println("Bouqet Sizes available:");
				System.out.println("\"tiny\" holds a maximum of 4 flowers. \"medium\" holds a maximum of 8 flowers. \"big\" holds a maximum of 12 flowers\"");
				System.out.print("Please choose a bouquet size (tiny, medium, or big): ");
				bouquetSize = input.next();
				
				// validate that bouquet size is valid
				if(BouquetCalculator.validateBouquetSize(bouquetSize) == false){
					// Invalid data has been entered
					System.out.println("I don't know that size\n");
					invalidInput = true;
				}
			}
			while(invalidInput == true);
			
			// Get input from user for flower amount
			do{
				invalidInput = false; // assume input is valid
				System.out.print("Enter the number of roses @ $3 each: ");
				roses = input.nextInt();
				System.out.print("Enter the number of lilies @ $2.5 each: ");
				lilies = input.nextInt();
				System.out.print("Enter the number of carnations @ $2 each: ");
				carnations = input.nextInt();
				
				// validate that the amount of flowers is > 0
				if(roses <= 0  || lilies <= 0 || carnations <= 0){
					// Invalid input has been entered
					System.out.println("The amount of each flower has to be greater than 0\n");
					invalidInput = true;
				}
			}
			while(invalidInput == true);
			
			// Validate the amount of flowers is compatible with the bouquet size
			if(BouquetCalculator.validateBouquet(bouquetSize, roses, lilies, carnations) == false){
				// Amount of flowers is incompatible with the bouquet size
				System.out.println("The amount of flowers chosen is too great for the bouquet size chosen\n");
				System.out.print("Would you like to calculate another bouquet? (y/n): ");
				keepGoing = input.next().equalsIgnoreCase("y"); // repeat if user enters 'y'
			}
			else{
				// Amount of flowers is compatible with bouquet size
				System.out.println("The cost of the bouquet with tax and delivery is: " + format.format(BouquetCalculator.calculateCost(bouquetSize, roses, lilies, carnations)) + "\n");
				System.out.print("Would you like to calculate another bouquet? (y/n): ");
				keepGoing = input.next().equalsIgnoreCase("y"); // repeat if user enters 'y'
			}
		}
		while(keepGoing == true); // Repeat main while loop if keepGoing == true
		
		// End program and print programmer name
		System.out.println("\n");
		System.out.println("Programmer: Darryl Most");
	}
}
