package main.java.com.gildedrose;

import java.util.Arrays;
import java.util.stream.Stream;


public class GildedRose {
    private Item[] items;
    public static final int REDUCING_FACTOR = 2; //added by kirti
    public static final int MAX_QUALITY_FACTOR = 50; //added by kirti
    public static final int SULFURAS_MAX_QUALITY_FACTOR = 80; //added by kirti --it never changes
    
    public GildedRose(Item[] items) {
    	System.out.println("Item updated ");
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
        	Item item = items[i];
        	item.reduceSellIndayByOne();        	
        	if( item.isEligibleToUpdate())
        	{            	             	
        		item.updateQuality();                            
            }          
        	
        	//System.out.println("Item updated " + item.getName() + "  SellIn: "+ item.getSellIn() + "  Quality: " + items.getQuality() );
        }
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