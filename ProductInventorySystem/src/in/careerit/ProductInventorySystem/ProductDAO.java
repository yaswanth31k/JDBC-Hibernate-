package in.careerit.ProductInventorySystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public static final Connection con = DBConnection.getConnection();
	//private static List<Product> productById, productByCategory, getAllProducts;

	static boolean addProduct(Product product) {
		boolean isAdded = false;
		try {

			System.out.println("connected successfully");
			String insertQuery = "INSERT INTO Product VALUES(?,?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getUnitprice());
			pstmt.setInt(4, product.getQtyOnHand());
			pstmt.setString(5, product.getCategory());
			pstmt.setString(6, product.getDescription());

			int rowAffected = pstmt.executeUpdate();

			isAdded = rowAffected > 0;

		} catch (SQLException e) {
			System.out.println("exception occured : " + e);
		}
		return isAdded;
	}

	static List<Product> getProductById(Product product) {
		String Query = "SELECT * FROM Product WHERE productId = ?";
		List<Product> productById = new ArrayList<>();

		try {
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, product.getProductId());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setUnitprice(rs.getInt(3));
				p.setQtyOnHand(rs.getInt(4));
				p.setCategory(rs.getString(5));
				p.setDescription(rs.getString(6));
				productById.add(p);
				// System.out.println(p);

			}

		} catch (SQLException e) {
			System.out.println("exception occured : " + e);
		}
		// System.out.println(productById);
		return productById;
	}

	static List<Product> getProductByCategory(Product product) {
		List<Product> productByCategory = new ArrayList<>();
		try {
			String Query = "SELECT * FROM Product WHERE Category = ?";
			
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setString(1, product.getCategory());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setUnitprice(rs.getInt(3));
				p.setQtyOnHand(rs.getInt(4));
				p.setCategory(rs.getString(5));
				p.setDescription(rs.getString(6));
				productByCategory.add(p);

			}

		} catch (SQLException e) {
			System.out.println("exception occured : " + e);
		}
		return productByCategory;
	}

	static boolean removeProduct(Product product) {
		boolean IsRemove = false;
		try {
			String insertQuery = "DELETE FROM Product WHERE productId = (?)";

			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, product.getProductId());
			int rowAffected = pstmt.executeUpdate();
			IsRemove = rowAffected > 0;

		} catch (SQLException e) {
			System.out.println("exception occured : " + e);
		}
		return IsRemove;
	}

	static boolean updateProduct(int productId, String description) {
		boolean isUpdate = false;
		try {

			String insertQuery = "UPDATE Product SET description = ? WHERE productId = ? ";

			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, description);
			pstmt.setInt(2, productId);
			int rowAffected = pstmt.executeUpdate();

			isUpdate = rowAffected > 0;

		} catch (SQLException e) {
			System.out.println("exception occured : " + e);
		}
		return isUpdate;
	}

	static List<Product> allProducts() {
		List<Product> getAllProducts = new ArrayList<>();
		try {
			String insertQuery = "SELECT * FROM Product";
			

			PreparedStatement pstmt = con.prepareStatement(insertQuery);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product p2 = new Product();
				p2.setProductId(rs.getInt(1));
				p2.setProductName(rs.getString(2));
				p2.setUnitprice(rs.getInt(3));
				p2.setQtyOnHand(rs.getInt(4));
				p2.setCategory(rs.getString(5));
				p2.setDescription(rs.getString(6));
				getAllProducts.add(p2);
				//System.out.println(getAllProducts);
			}

		} catch (SQLException e) {
			System.out.println("exception occured : " + e);
		}
		//System.out.println("Products are: " + getAllProducts);
		return getAllProducts;
	}

}