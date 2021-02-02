package main.java.com.gildedrose;

import java.util.Arrays;
import java.util.stream.Stream;


public class GildedRose {
    private Item[] items;
    public static final int REDUCING_FACTOR = 2; //added by kirti
    public static final int MAX_QUALITY_FACTOR = 50; //added by kirti
    public static final int SULFURAS_MAX_QUALITY_FACTOR = 80; //added by kirti --it never changes
    
    public GildedRose(Item[] items) {
        this.setItems(items);
    }
/* Commented by Kirti
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    } */
    
    public void updateQuality()  {   	
    	
        for (int i = 0; i < items.length; i++) 
        {
        	
        	try {
				reduceSellIndayByOne(items[i]);
			} catch (ItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							             
        	if( eligibleToReduceQuality(items[i]) )
        	{            	             	
        		reduceQuality(items[i]);    	       //reduce quality by 1 or 2                            
            }
            else //aged item increase quality
            {
                if (items[i].getQuality() < MAX_QUALITY_FACTOR) 
                	increaseQuality(items[i]);                       //increase quality of aged items                                       
            }   
        	
        	System.out.println("Item updated " + items[i].getName() + "  SellIn: "+ items[i].getSellIn() + "  Quality: " + items[i].getQuality() );
        }
    }
      
	 /**
	 * @param item
	 * @return
	 */
	private boolean eligibleToReduceQuality(Item item) {
		//if (!isBrie(item) && !isBackstage(item) && !isSulfuras(item) ||  isConjuredItem(item) )
		//if (!isBrie(item) && !isBackstage(item) && !isSulfuras(item) ||  isConjuredItem(item) )
		if (!isBrie(item) && !isSulfuras(item) && isBackstageEligibletoReduce(item) ||  isConjuredItem(item)  )
		return true;
		else return false;
	}

	/**
	 * @return
	 */
	private boolean isBackstageEligibletoReduce(Item item) {
		  if(isBackstage(item) && item.sellIn==0)
		return true;
		  else return false;
		  
	}

	/**
	 * @param item
	 * @return
	 */
	private boolean isConjuredItem(Item item) {
		if(item.getName().contains("Conjured"))
			return true;
			else return false;
	}

	/* @param item
	 */
	private void increaseQuality(Item item) {		
		int qualityval = 0;
		if(!isSulfuras(item)) 
		{			
			if(item.getSellIn()<6 )	 //5 or less days
			qualityval = item.getQuality()+3;
			else {
			if(item.getSellIn()<=10)  //10 or less
			qualityval = item.getQuality()+2; 
			}		
			if(qualityval >  MAX_QUALITY_FACTOR) //if reached MAX
			{
			System.out.println("Error - Max Quality value reached. Setting quality value to 50");
			item.setQuality(MAX_QUALITY_FACTOR);
			}
			else
			{ 
				if(qualityval==0) item.setQuality(item.getQuality() + 1); // any other sellin days increase quality by 1		
			    else item.setQuality(qualityval);
			}
			System.out.println("Qualityval " +  qualityval);
		}	
		
	}
	/**
	 * @param item
	 * @throws ItemException 
	 */
	private void reduceSellIndayByOne(Item item) throws ItemException {
		if(!isSulfuras(item))
		{
			item.setSellIn(item.getSellIn() -1);		
		}		
		else {	
			//System.out.println("Error - Sulfurus item can not be sold.");		
		//	throw new ItemException("Error - Sulfurus item can not be sold");
		}
		
	}
	/**
	 * @param item
	 */
	private void reduceQuality(Item item) {
		
			
		 int qualityval = 0;
		 
		if(isBackstage(item))
		{
				if(item.sellIn==0)
					item.setQuality(0);
		}
		 else{
		  if(isBackstage(item) && item.sellIn==0)
			  qualityval = 0;
		  
		 if (item.getQuality() > 0 && !isSulfuras(item) && item.getSellIn()>0 && !isConjuredItem(item) )    //sellindate not passed           	
			  qualityval = item.getQuality() - 1;		
		  
		  if (item.getQuality() > 0 && !isSulfuras(item) && item.getSellIn()<0 || isConjuredItem(item) )        //sellindate passed      	
			  qualityval = item.getQuality() - item.getQuality()/2 ;
		  
		
		  
		  if( qualityval < 0 ) { //if negative value -- set it to 0 --no value
				item.setQuality(0); //item has no value
				System.out.println("ERROR - Item has negative value " + qualityval );	
			}
			else item.setQuality(qualityval);
		 }
	}
	
	/**
	 * @param item
	 * @return
	 */
	private boolean isSulfuras(Item i) {
		   if (i.getName().contains("Sulfuras"))
		   return true;
		   else return false;		   
	}
	/**
	 * @return
	 */
	private boolean isBackstage(Item i) {
	
		if (i.getName().contains("Backstage Passes"))
		{
			System.out.print("Backstage item received!");
			return true;
		}
			else return false;
	}
	/**
	 * @return
	 */
	private boolean isBrie(Item i) {
		if (i.getName().contains("Aged Brie"))
		return true;
		else return false;
	} 
	
    public Item[] getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Item[] items) {
		this.items = items;
	}
}