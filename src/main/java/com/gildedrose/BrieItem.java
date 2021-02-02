/**
 * added by kirti
 */
package main.java.com.gildedrose;

/**
 * @author Kirti
 *
 */
public class BrieItem extends Item {

	public BrieItem(String name, int sellIn, int quality) {
		this.name = "Old Brie";
        this.sellIn = sellIn;
        this.quality = quality;
	}	
	public void updateQuality()
	{
		int qualityval = 0 ;
		
		if(sellIn<6)	 //5 or less days
		qualityval =  this.quality+3;
		else
		{
			if( this.sellIn<=10)  //10 or less
				qualityval =  this.quality+2; 
			else 
				qualityval =  this.quality+1; 
		}
		
		if(qualityval >  50) //if reached MAX
		this.quality = 50;
		else this.quality =  qualityval;	
		
		System.out.println("BrieItem quality updated " + this.quality);
	}
		
	public Boolean isEligibleToUpdate()
	{
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
