package util.user;

import my.model.Profile;
import my.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author olupas
 * @since 15.08.2014
 */
public class UserDataFetcherFromEhCache implements Serializable {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.io.tmpdir"));
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        System.out.println("Loading user.....");
        User user = (User) session.get(User.class, 1);
        System.out.println(user);
        System.out.println("Profiles initialized: " + Hibernate.isInitialized(user.getProfiles()));
        Set<Profile> profiles = user.getProfiles();
        System.out.println("# of profiles: " + profiles.size());
        for (Profile profile : profiles) {
            System.out.println(profile);
        }
        System.out.println(factory.getStatistics().getSecondLevelCacheStatistics("my.model.User"));
        System.out.println("Loading user from first level cache...");
        user = (User) session.load(User.class, 1);
        System.out.println(user);
        System.out.println(factory.getStatistics().getSecondLevelCacheStatistics("my.model.User"));
        session.close();


        System.out.println("Loading user from second level cache...");
        for (int i = 0; i < 2; i++) {
            session = factory.openSession();
            user = (User) session.get(User.class, 1);
            System.out.println(user);
            session.close();
        }

        System.out.println("Loading users...");
        session = factory.openSession();
        user = (User) session.createQuery("from User where id=1").list().get(0);
        System.out.println(user);
        List<User> allusers = session.createQuery("from User where firstName='Ovidiu'").setCacheable(true).list();
        for (User user1 : allusers) {
            System.out.println(user1);
        }
        session.close();

        session = factory.openSession();
//        user = (User) session.createQuery("from User where id=1").list().get(0);
//        System.out.println(user);
        allusers = session.createQuery("from User where firstName='Ovidiu'").setCacheable(true).list();
        for (User user1 : allusers) {
            System.out.println(user1);
        }
        session.close();

        System.out.println(factory.getStatistics().getSecondLevelCacheHitCount());
        System.out.println(factory.getStatistics().getSecondLevelCacheStatistics("my.model.User"));

        HibernateUtil.shutdown();


    }
}
