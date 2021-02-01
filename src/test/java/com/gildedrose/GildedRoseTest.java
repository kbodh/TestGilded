package test.java.com.gildedrose;
import main.java.com.gildedrose.Item;
import main.java.com.gildedrose.ItemException;
import main.java.com.gildedrose.SulfurasItem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.com.gildedrose.GildedRose;

// public Item(String name, int sellIn, int quality) {

public class GildedRoseTest {
/* commented by Kirti
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
	*/
		
	@Test
	public void testDecreaseQuality() throws ItemException //decrease quality test
	{
		 
		 Item[] items = new Item[] { new Item("Cheese",10,20) };// quality 20 sellin 10 days normal item
		   GildedRose app = new GildedRose(items); 
		   app.updateQuality();
		   assertEquals(19,app.getItems()[0].quality);
	}
	
	@Test
	public void testIncreaseQualityBrie() //to increase quality test
	{
		
		 Item[] items = new Item[] { new Item("Aged Brie",15, 20) };// quality 20 sellin 10 days
		 GildedRose app = new GildedRose(items); 
		 app.updateQuality();
		 assertEquals(21,app.getItems()[0].quality);
		   
		items = null; app= null;
		
		items = new Item[] { new Item("Aged Brie",10, 20) };// quality 20 sellin 10 days
		app = new GildedRose(items);	 
		 app.updateQuality();
		assertEquals(22,app.getItems()[0].quality);
		 
		items = null; app= null;
		
		items = new Item[] { new Item("Aged Brie",5, 20) };// quality 20 sellin 10 days
		app = new GildedRose(items);	 
		 app.updateQuality();
		assertEquals(23,app.getItems()[0].quality);
		   
		items = null; app= null;
		
		items = new Item[] { new Item("Aged Brie",5, 49) };// quality 20 sellin 10 days
		app = new GildedRose(items); 
		 app.updateQuality();
		assertEquals(50,app.getItems()[0].quality);
		items = null; app= null;		   
	}
	
	@Test 
	public void testSulfurasItem() //to increase quality test
	{ 
		Item[] items = null;		   
		items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",15, 80) };	// quality 20 sellin 10 days
		 GildedRose app = new GildedRose(items); 
		 app.updateQuality();
		 assertEquals(80,app.getItems()[0].quality);	 
				
			items = null; app= null;			   
			items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",15, 40) };	// Should we allow this ?
			app = new GildedRose(items); 
			app.updateQuality();
			assertEquals(40,app.getItems()[0].quality);	  
			
			items = null; app= null;			
			items = new Item[] { new SulfurasItem("Sulfuras, Hand of Ragnaros") };	// This should be right way
			app = new GildedRose(items); 
			app.updateQuality();
			assertEquals(80,app.getItems()[0].quality);	  
	}	
	
	//@Test(expected = ItemException.class)
	@Test
	public void testUpdateItems() throws ItemException //Test all
	{
		 Item[] items = new Item[] {
	                new Item("+5 Dexterity Vest", 10, 20), //
	                new Item("Aged Brie", 2, 0), // 
	                new Item("Elixir of the Mongoose", 5, 7), //
	         
	                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
	                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
	                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),	                
	                new Item("Conjured Mana Cake", 3, 6) , //reduced quality by half
		 			new Item("Sulfuras, Hand of Ragnaros", 0, 80)} ; //
         //   new Item("Sulfuras, Hand of Ragnaros", -1, 80),
	        GildedRose app = new GildedRose(items);
	        app.updateQuality();
	} 
	
}