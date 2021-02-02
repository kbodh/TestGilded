/**
 * added by kirti
 */
package main.java.com.gildedrose;

/**
 * @author Kirti
 *
 */
public class BackStageItem extends Item {

	/**
	 * @param name
	 * @param sellIn
	 * @param quality
	 */
	public BackStageItem(String name, int sellIn, int quality) {		
		this.name = "Backstage Passes";
        this.sellIn = sellIn;
        this.quality = quality;
	}
	
	public void updateQuality()
	{
		int qualityval = 0;
		
		
		
	     if( this.sellIn ==0)
	     this.quality = 0;
	     else{ 	     
			if(sellIn<6)	 //5 or less days
			qualityval =  this.quality+3;
			else
			{
				if( this.sellIn<=10)  //10 or less
					qualityval =  this.quality+2; 
				else 
					qualityval =  this.quality+1; 
			}
			//System.out.println("Qualityval " + qualityval );
			if(qualityval >  50) //if reached MAX
			this.quality = 50;
			else this.quality =  qualityval;
	     }
	     
	     System.out.println(" BackStageItem updateQuality  " + this.quality );
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
