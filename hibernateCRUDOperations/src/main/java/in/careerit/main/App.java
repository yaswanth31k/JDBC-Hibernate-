//package in.careerit.main;
//
//
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import in.careerit.entities.User;
//
//public class App {
//    public static void main( String[] args ){
//        
//    	Configuration cfg = new Configuration();
//    	cfg.configure("/in/careerit/config/hibernate.cfg.xml");
//    	
//    	SessionFactory sf = cfg.buildSessionFactory();
//    	Session session = sf.openSession();
//    	Transaction transaction = session.beginTransaction();    	
//    	User u = new User();
//    	u.setName("yash");
//    	u.setEmail("yash@gmail.com");
//    	u.setPassword("yash123");
//    	u.setGender("male");
//    	u.setCity("hyd");
//    	
//    	try {
//    		session.save(u);
//    		System.out.println("user inserted successfully");
//    		transaction.commit();
//    	}catch(Exception e){
//    		System.out.println("failed to insert user");
//    		e.printStackTrace();
//    		transaction.rollback();
//    	}
//    	
//    }
//}
package in.careerit.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import in.careerit.dao.UserDAO;
import in.careerit.entities.User;
import in.careerit.util.HibernateUtil;

public class App {

    public static void main(String[] args) {
	    UserDAO userDAO = new UserDAO();
	
	try (Session session = HibernateUtil.getSessionFactory().openSession();
		Scanner sc = new Scanner(System.in))  { 
		
		while (true) {
			System.out.println("\n--- MENU ---");
			System.out.println("1. Add User");
		    System.out.println("2. Get User by ID");
		    System.out.println("3. Update User by ID");
		    System.out.println("4. List All Users");
		    System.out.println("5. Filter Users by City");
		    System.out.println("6. Filter Users by Gender");
		    System.out.println("7. Filter Users by City & Gender");
		    System.out.println("8. Sort Users by Name (Asc)");
		    System.out.println("9. Sort Users by City (Desc)");
		    System.out.println("10. Filter by Gender & Sort by Name (Asc)");
		    System.out.println("11. Exit");
		    System.out.println("Enter your choice");
		    int choice = sc.nextInt();
		    sc.nextLine();
    
		    switch (choice) {
		    case 1:
		    	User user = new User();
		    	System.out.print("Enter name: ");
		    	user.setName(sc.nextLine());
		    	System.out.print("Enter email: ");
		    	user.setEmail(sc.nextLine());
		    	System.out.print("Enter password: ");
		    	user.setPassword(sc.nextLine());
		    	System.out.print("Enter gender: ");
		    	user.setGender(sc.nextLine());
		    	System.out.print("Enter city: ");
		    	user.setCity(sc.nextLine());
		    	userDAO.insertUser(session, user);
		       break;
		       
		    case 2:
		    	System.out.print("Enter user ID: ");
		    	Long id = sc.nextLong();
		    	User fetchedUser = userDAO.getUserById(session, id);
		    	if (fetchedUser != null) {
		    		System.out.println(fetchedUser);
		    	} else {
		    		System.out.println("User not found");
		    	}
		    	break;
		    	
		    case 3:
		    	System.out.print("Enter user ID: ");
		    	Long updateId = sc.nextLong();
		    	sc.nextLine(); //consume newLine
		    	System.out.print("Enter new city: ");
		    	String newCity = sc.nextLine();
		    	userDAO.updateUserCity(session, updateId, newCity);
		    	break;
		    	
		    case 4:
		    	List<User> users = userDAO.getAllUsers(session);
		    	if (users.isEmpty()) {
			    	System.out.print("No users found. ");
		    	} else {
		    		for (User u : users) {
		    			System.out.println(u);
		    			System.out.println("----------------");
		    		}
		    	}
		        break;
		        
		    case 5:
		    	System.out.println("Enter city: ");
		        String city = sc.nextLine();
		        List<User> cityUsers = userDAO.getUsersByCity(session, city);
		        cityUsers.forEach(System.out::println);
		        break;
		        
		    case 6:
		        System.out.println("Enter gender: ");
		        String gender = sc.nextLine();
		        List<User> genderUsers = userDAO.getUsersByGender(session, gender);
		        genderUsers.forEach(System.out::println);
		        break;
		        
		    case 7:
		        System.out.println("Enter city: ");
		        String c = sc.nextLine();
		        System.out.print("Enter gender: ");
		        String g = sc.nextLine();
		        List<User> filteredUsers = userDAO.getUsersByCityAndGender(session, c, g);
		        filteredUsers.forEach(System.out::println);
		        break;
		        
		    case 8:
		    	List<User> sortedByName = userDAO.getUsersSortedByName(session, true);
		        sortedByName.forEach(System.out::println);
		        break;
		        
		    case 9:
		    	List<User> sortedByCity = userDAO.getUsersSortedByCity(session, false);
		        sortedByCity.forEach(System.out::println);
		        break;
		        
		    case 10:
		    	System.out.print("Enter gender: ");
		    	String gend = sc.nextLine();
		    	List<User> genderSorted = userDAO.getUsersByGenderSortedByName(session, gend, true);
		        break;    
		       
		    case 11:
		    	System.out.print("Existing...");
		        HibernateUtil.shutdown();
		        return;
		        
		    default:
		    	System.out.print("Invalid choice...");      
	
		}
	}
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}