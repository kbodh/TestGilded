package main.java.com.gildedrose;

public class Item {

	 
    public String name;

    public int sellIn;

    public int quality;
	 
    /* Kirti changes
     *  this needs to be public for the testing	
	private String name; //name
    private int sellIn; //no of days
    private int quality; //value
	*/
    public Item(String name, int sellIn, int quality) {    	
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
/*
protected String getName() {
	return name;
}

protected int getSellIn() {
	return sellIn;
}

protected int getQuality() {
	return quality;
}

protected void setName(String name) {
	this.name = name;
}

protected void setSellIn(int sellIn) {
	this.sellIn = sellIn;
}

protected void setQuality(int quality) {
	this.quality = quality;
} */
}
