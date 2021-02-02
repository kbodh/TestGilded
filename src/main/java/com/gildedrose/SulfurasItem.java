/**
 * added by kirti
 */
package main.java.com.gildedrose;

/**
 * @author Kirti
 *
 */
public class SulfurasItem  extends Item {

	/**
	 * @param name
	 * @param sellIn
	 * @param quality
	 */
	public SulfurasItem(String name, int sellIn, int quality) {		
		this.name = "Sulfuras";
        this.sellIn = 0;
        this.quality = 80;
	}	
	
	public void updateQuality() //dont need this
	{
	     
	     this.quality = 80;
	}
	public Boolean isEligibleToUpdate()
	{
		return false;		
	}

	/* (non-Javadoc)
	 * @see main.java.com.gildedrose.Item#reduceSellIndayByOne()
	 */
	@Override
	public void reduceSellIndayByOne() {
		 //this.sellIn -= this.sellIn;     
		
	}
	

}
