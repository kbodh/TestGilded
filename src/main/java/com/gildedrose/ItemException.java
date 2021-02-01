/**
 * added by kirti
 */
package main.java.com.gildedrose;

/**
 * @author Kirti
 *
 */
public class ItemException extends Exception 
{	
    public ItemException() {
        super();
    }
    public ItemException(String message) {
        super(message);
    }
    public ItemException(Throwable cause) {
        super(cause);
    }
    public ItemException(String message, Throwable cause) {
        super(message, cause);
    }
}