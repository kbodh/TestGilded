package main.java.com.gildedrose;

public class Item {

	 
    public String name;

    public int sellIn;

    public int quality; 
	 
    /* Kirti changes
     *  this needs to be public for the testing	 
	private String name; //name
    private int sellIn; //no of days
    private int quality; //value */
	
    public Item(String name, int sellIn, int quality) {  
    	if(name.contains("Sulfuras"))
    	{        	
        this.name = name;
        this.sellIn = 0;
        this.quality = 80;
    	}
    	else {
    		this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
    	}
    		
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

public String getName() {
	return name;
}

public int getSellIn() {
	return sellIn;
}

public int getQuality() {
	return quality;
}

public void setName(String name) {
	this.name = name;
}

public void setSellIn(int sellIn) {
	this.sellIn = sellIn;
}

public void setQuality(int quality) {
	this.quality = quality;
}


}
