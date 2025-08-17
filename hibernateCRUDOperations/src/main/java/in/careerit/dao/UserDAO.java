package in.careerit.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.careerit.entities.User;

public class UserDAO {

	// Insert New User
    public void insertUser(Session session, User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("User inserted successfully");
    }

    // Get User by Id
    public User getUserById(Session session, Long id) {
        return session.get(User.class, id);
    }

    // Update User City
    public void updateUserCity(Session session, Long id, String newCity) {
        session.beginTransaction();
        User user = session.get(User.class, id);
        if (user != null) {
            user.setCity(newCity);
            session.getTransaction().commit();
            System.out.println("City updated successfully");
        } else {
            System.out.println("User not found");
            session.getTransaction().rollback();
        }
    }

    // List all users
    public List<User> getAllUsers(Session session) {
        return session.createQuery("from User", User.class).list();
    }

    //  Filter by City
    public List<User> getUsersByCity(Session session, String city) {
        return session.createQuery("from User where city = :city", User.class)
                .setParameter("city", city)
                .list();
    }

    //  Filter by Gender
    public List<User> getUsersByGender(Session session, String gender) {
        return session.createQuery("from User where gender = :gender", User.class)
                .setParameter("gender", gender)
                .list();
    }

    //  Filter by City and Gender
    public List<User> getUsersByCityAndGender(Session session, String city, String gender) {
        return session.createQuery("from User where city = :city and gender = :gender", User.class)
                .setParameter("city", city)
                .setParameter("gender", gender)
                .list();
    }

    //  Sort by Name
    public List<User> getUsersSortedByName(Session session, boolean ascending) {
        String order = ascending ? "asc" : "desc";
        return session.createQuery("from User order by name " + order, User.class)
                .list();
    }

    //  Sort by City
    public List<User> getUsersSortedByCity(Session session, boolean ascending) {
        String order = ascending ? "asc" : "desc";
        return session.createQuery("from User order by city " + order, User.class)
                .list();
    }

    //  Filter by Gender + Sort by Name
    public List<User> getUsersByGenderSortedByName(Session session, String gender, boolean ascending) {
        String order = ascending ? "asc" : "desc";
        Query<User> query = session.createQuery("from User where gender = :gender order by name " + order, User.class);
        query.setParameter("gender", gender);
        return query.list();
    }
}