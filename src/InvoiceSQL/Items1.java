package InvoiceSQL;

import java.io.Serializable;

public class Items1 implements Serializable{

	/**
 * 
 */
private static final long serialVersionUID = 1L;
	private String itemName;
	private Integer itemId;
	private double itemprice;
	private Integer stock;
	private Integer quantity;


	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public double getitemPrice() {
		return itemprice;
	}
	public void setitemPrice(double itemprice) {
		this.itemprice = itemprice;
	}	
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}

