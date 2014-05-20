/**     Project 2     Spring 2014
 * Validates the size of the bouquet with the number of flowers ordered and calculates the cost of the bouquet.
 * The cost for an appropriate vase, the accompanying greenery, and the delivery will always be $20.00.  
 * The sales tax on an order is 5.5%.  
 * A <b>tiny</b> vase of flowers will be four flowers or fewer.  
 * A <b>medium</b> vase will hold a maximum of eight flowers.  
 * The <b>big</b> vase will have a maximum of twelve flowers.  
 * The bouquets will consist of roses, lilies, and/or carnations.  
 * <p>Roses are $3.00 each, 
 * <p>Lilies are $2.50 each, and 
 * <p>Carnations are $2.00 each.
 * @author JMYERS
 *
 */
public class BouquetCalculator {
	/** cost for an appropriate vase, the accompanying greenery, and the delivery */
	public static final double baseCost = 20.0;
	/** sales tax on an order is 5.5% */
	public static final double taxRate = .055;
	/** Roses are $3.00 each */
	public static final double roseCost = 3.0;
	/** Lilies are $2.50 each */
	public static final double lilyCost = 2.5;
	/** Carnations are $2.00 each */
	public static final double carnationCost = 2.0;
	/**
	 * A tiny vase of flowers will be four flowers or fewer.  
	 * A medium vase will hold a maximum of eight flowers.  
	 * The big vase will have a maximum of twelve flowers.  
	 */
	public static final int maxTiny = 4, maxMedium = 8, maxBig = 12;
	
	/**
	 * <p>Determines the cost of a bouquet if the size and number of flowers is valid.
	 * <p>Cost consists of $20 for vase, greenery and delivery, $3 for each rose, $2.5 for each lily, 
	 * <p>$2 for each carnation and sales tax of 5.5%
	 * <p>numRoses, numLilies, and numCarnations MUST BE GREATER THAN OR EQUAL TO 0
	 * @param size size of the bouquet (tiny, medium, big)
	 * @param numRoses number of roses in the bouquet
	 * @param numLilies number of lilies in the bouquet
	 * @param numCarnations number of carnations in the bouquet
	 * @return cost of the bouquet if the bouquet is valid.
	 *         Return -1 if the bouquet is invalid.
	 */
	public static double calculateCost(String size, int numRoses, int numLilies, int numCarnations)
	{
		if(validateBouquet(size, numRoses, numLilies, numCarnations))
		{
		double cost = baseCost + numRoses * roseCost + numLilies * lilyCost + numCarnations * carnationCost;
		double tax = cost * taxRate;
		return cost + tax;
		}
		else return -1;
	}
	
	/**
	 * <p>Determines if the size of the bouquet is valid - "tiny", "medium", or "big" and
	 * if the number of roses + lilies + carnations is less than the maximum for the bouquet size.
	 * <p>numRoses, numLilies, and numCarnations MUST BE GREATER THAN OR EQUAL TO 0
	 * @param size size of the bouquet (tiny, medium, big)
	 * @param numRoses number of roses in the bouquet
	 * @param numLilies number of lilies in the bouquet
	 * @param numCarnations number of carnations in the bouquet
	 * @return true if the number of roses + lilies + carnations is less than the maximum for the bouquet size.
	 *         false if the number of roses + lilies + carnations is greater than the maximum for the bouquet size,
	 *         false if the size is not "tiny", "medium", or "big"
	 */
	public static boolean validateBouquet(String size, int numRoses, int numLilies, int numCarnations)
	{
		// check for valid number of flowers for tiny bouquet
		if(size.equals("tiny"))
		{
			if((numLilies + numRoses + numCarnations) <= maxTiny)
				return true;
			else return false;
		}
		// check for valid number of flowers for medium bouquet
		else if(size.equals("medium"))
		{
			if((numLilies + numRoses + numCarnations) <= maxMedium)
				return true;
			else return false;
		}
		// check for valid number of flowers for big bouquet
		else if(size.equals("big"))
		{
			if((numLilies + numRoses + numCarnations) <= maxBig)
				return true;
			else return false;
		}
		else return false;
			
	}
	
	/**
	 * <p>Determines if the size of the bouquet is valid - "tiny", "medium", or "big".
	 * @param size size of the bouquet
	 * @return true if the size is not "tiny", "medium", or "big", false if not
	 */
	public static boolean validateBouquetSize(String size)
	{
		if((size.equals("tiny"))||(size.equals("medium"))||(size.equals("big")))
			return true;
		else
			return false;
	}
}