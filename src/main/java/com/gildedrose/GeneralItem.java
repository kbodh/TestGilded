/**
 * added by kirti
 */
package main.java.com.gildedrose;

/**
 * @author Kirti
 *
 */
public class GeneralItem extends Item {
	
	public GeneralItem(String name, int sellIn, int quality) {
		this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
	}	

	/* (non-Javadoc)
	 * @see main.java.com.gildedrose.Item#updateQuality()
	 */
	@Override
	public void updateQuality() {
		if (this.quality >0 && this.quality <50)
			 this.quality = this.quality -1;
		System.out.println("General Item quality updated " + this.quality);
	}

	/* (non-Javadoc)
	 * @see main.java.com.gildedrose.Item#isEligibleToReduce()
	 */
	@Override
	public Boolean isEligibleToUpdate() {
		if( this.sellIn >0)
		return true;
		else return false;		
	}

	/* (non-Javadoc)
	 * @see main.java.com.gildedrose.Item#reduceSellIndayByOne()
	 */
	@Override
	public void reduceSellIndayByOne() {
		 this.sellIn = this.sellIn - 1;       
		
	}
}
