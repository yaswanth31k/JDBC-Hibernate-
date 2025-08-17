package in.careerit.ProductInventorySystem;

import java.util.ArrayList;
import java.util.List;

public class ProductClint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int choice;
		do{
			System.out.println("M  E  N  U");
			System.out.println("1: Add new product");
			System.out.println("2: search a product by ID");
			System.out.println("3: search a product by category");
			System.out.println("4: remove a product");
			System.out.println("5: update a product");
			System.out.println("6: list all the products");
			System.out.println("7:exit");
			System.out.println("read the choice");
			
			choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("add new product");
					
					System.out.println("enter productId");
					int productId = sc.nextInt();
					sc.nextLine();
					System.out.println("enter productName");
					String productName = sc.nextLine();

					System.out.println("enter unitPrice");
					int unitPrice = sc.nextInt();

					System.out.println("enter qtyOnHand");
					int qtyOnHand = sc.nextInt();

					System.out.println("enter category");
					String category = sc.next();
					sc.nextLine();
					System.out.println("enter descrition");
					String description = sc.nextLine();

					Product product = new Product(productId,productName,unitPrice,qtyOnHand,category,description);
					
					boolean isAdded = ProductDAO.addProduct(product);
					
					if(isAdded){
						System.out.println(" record(s) insert successfully");
					}else{
						System.out.println("failed to insert the record");
					}

					break;
				case 2:
					System.out.println("search a product by ID");

					int Id = sc.nextInt();
					Product p1 = new Product(Id);
					
					List<Product> result = ProductDAO.getProductById(p1);
					if(result.isEmpty()){
						System.out.println("no such data is available on productId");
					}else{
						for(Product a : result){
							System.out.println(a);
						}
					}
					break;
				case 3:
					System.out.println("search a product by category");
				
					String inputCategory = sc.next();
					
					Product p2 = new Product(inputCategory);
					
					List<Product> result2 = new ArrayList();
					result2 = ProductDAO.getProductByCategory(p2);
					if(result2.isEmpty()){
						System.out.println("no such data is  available on category");
					}else{
						for(Product re : result2){
							System.out.println(re);
						}
					}	
					
					break;
				case 4:
					System.out.println("remove a product by Id ");
					int removeId = sc.nextInt();
					Product p3 = new Product(removeId);
					boolean isRemove  = ProductDAO.removeProduct(p3);
					if(isRemove){
						System.out.println(" record(s) removed  successfully");
					}else{
						System.out.println("failed to remove the record");
					}
					
					break;
					
				case 5:
					System.out.println("update a product");
					
					System.out.print("enter productId to update : ");
					int updateId = sc.nextInt();
					sc.nextLine();
					System.out.println("enter category  to update : ");
					String updateCategory = sc.nextLine();
					
					boolean isUpdate = ProductDAO.updateProduct(updateId,updateCategory);
					if(isUpdate){
						System.out.println(" record(s) update  successfully");
					}else{
						System.out.println("failed to update the record");
					}
					
					break;
					
				case 6:
					System.out.println("list all the products");
					List<Product> allProduct  = ProductDAO.allProducts();
					if(allProduct.isEmpty()){
						System.out.println("no data is available on products");
					}else{
						
						for(Product a : allProduct){
							System.out.println(a);
						}
					}
					break;
				case 7:
					System.out.println("exit");
					break;
				case 8:
					System.out.println("invalid choice , try again......");
					break;
			}
			
		}while(choice != 7);
		System.out.println("End of the Application");
	}

}
