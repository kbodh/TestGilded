/**
 * added by kirti
 */
package main.java.com.gildedrose;

/**
 * @author Kirti
 *
 */
public class ConjuredItem  extends Item {

	/**
	 * @param name
	 * @param sellIn
	 * @param quality
	 */
	public ConjuredItem(String name, int sellIn, int quality) {
		this.name = "Conjured";
        this.sellIn = sellIn;
        this.quality = quality;
	}
	
	public void updateQuality()
	{
		this.quality = this.quality - this.quality/2 ;
	}
	
	public Boolean isEligibleToUpdate()
	{
		//if MIN < quality < MAX
		if( quality < 50 && quality >0)
		return true;
		else return false;
				
	}

	/* (non-Javadoc)
	 * @see main.java.com.gildedrose.Item#reduceSellIndayByOne()
	 */
	@Override
	public void reduceSellIndayByOne() {
		 this.sellIn -= this.sellIn;     
		
	}

}
