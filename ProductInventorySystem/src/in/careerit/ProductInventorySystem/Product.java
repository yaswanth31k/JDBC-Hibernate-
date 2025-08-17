//java bean /pojo (palin old java object)
package in.careerit.ProductInventorySystem;

public class Product {
	private int productId ;
	private String productName;
	private int unitprice;
	private int qtyOnHand;
	private String category;
	private String description;
	
	Product (){
		
	}
	
	Product (int productId){
		this.productId = productId;
	}
	
	Product (String category){
		this.category = category;
	}

	
	Product(int productId, String productName, int unitprice, int qtyOnHand, String category, String description) {
		this.productId = productId;
		this.productName = productName;
		this.unitprice = unitprice;
		this.qtyOnHand = qtyOnHand;
		this.category = category;
		this.description = description;
	}

	
	
	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public int getUnitprice() {
		return unitprice;
	}



	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}



	public int getQtyOnHand() {
		return qtyOnHand;
	}



	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "[productId=" + productId + ", productName=" + productName + ", unitprice=" + unitprice
				+ ", qtyOnHand=" + qtyOnHand + ", category=" + category + ", description=" + description + "]";
	}
	

	

}
