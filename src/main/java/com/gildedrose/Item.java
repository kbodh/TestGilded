/**
 * added by kirti
 */
package main.java.com.gildedrose;

/**
 * @author Kirti
 *
 */
public abstract class Item {
	 
	public String name = ""; //name
	public int sellIn =0; //no of days
	public int quality =0; //value
	public abstract void updateQuality();
	public abstract Boolean isEligibleToUpdate();
	/**
	 * @return 
	 * 
	 */
	public abstract void reduceSellIndayByOne() ;
		// TODO Auto-generated method stub
	
	
}
