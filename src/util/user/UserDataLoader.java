package util.user;

/**
 * Created with IntelliJ IDEA.
 *
 * @author olupas
 * @since 15.08.2014
 */

import my.model.Profile;
import my.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UserDataLoader {

    public static void main(String[] args) {

        deleteAll();

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        User u1 = new User();
        u1.setId(1);
        u1.setFirstName("Ovidiu");
        u1.setLastName("Lupas");

        Profile p1_u1 = createProfile(1, u1);
        Profile p2_u1 = createProfile(2, u1);
        Profile p3_u1 = createProfile(3, u1);
        Profile p4_u1 = createProfile(4, u1);
        session.save(u1);
        session.save(p1_u1);
        session.save(p2_u1);
        session.save(p3_u1);
        session.save(p4_u1);

        User u2 = new User();
        u2.setId(2);
        u2.setFirstName("Tudor");
        u2.setLastName("Lupas");

        Profile p1_u2 = createProfile(5, u2);
        Profile p2_u2 = createProfile(6, u2);
        session.save(p1_u2);
        session.save(p2_u2);
        session.save(u2);

        User u3 = new User();
        u3.setId(3);
        u3.setFirstName("Iulia");
        u3.setLastName("Lupas");

        Profile p1_u3 = createProfile(7, u3);
        session.save(p1_u3);
        session.save(u3);

        tx.commit();
        session.close();
    }

    public static void deleteAll() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query deleteProfileQuery = session.createQuery("delete from Profile");
        deleteProfileQuery.executeUpdate();

        Query deleteUserQuery = session.createQuery("delete from User");
        deleteUserQuery.executeUpdate();
        tx.commit();
        session.close();

    }

    public static Profile createProfile(int pk, User user) {
        Profile profile = new Profile();
        profile.setId(pk);
        profile.setName("Profile - " + user.getFullName());
        profile.setUser(user);
        return profile;
    }

}