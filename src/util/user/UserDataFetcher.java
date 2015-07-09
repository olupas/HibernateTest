package util.user;

import my.model.Profile;
import my.model.User;
import org.hibernate.Criteria;
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
public class UserDataFetcher implements Serializable {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        User user = (User) session.get(User.class, 1);
        System.out.println(user);
        System.out.println("Profiles initialized: " + Hibernate.isInitialized(user.getProfiles()));
        Set<Profile> profiles = user.getProfiles();
        System.out.println("# of profiles: " + profiles.size());
        for (Profile profile : profiles) {
            System.out.println(profile);
        }

//        session.close();
//        session = factory.openSession();
//        System.out.println("Loading user again from second level cache...");
//        user = (User) session.get(User.class, 1);
//        System.out.println(user);
        session.close();
        session = factory.openSession();
        System.out.println("Loading user and profiles");
        Criteria c = session.createCriteria(User.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        //c.setFetchMode("profiles", FetchMode.JOIN);

        List<User> users = c.list();
        System.out.println("Number of users: " + users.size());
        System.out.println(users);
        for (User u : users) {
            System.out.println(u.getFullName() + " # profiles: " + u.getProfiles().size());

        }

//        session.close();
//        session = factory.openSession();
//        c = session.createCriteria(Profile.class);
//        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//        // c.setFetchMode("profiles", FetchMode.JOIN);
//
//        List<Profile> allprofiles = c.list();
//        for (Object o : allprofiles) {
//            Profile profile = (Profile) o;
//            System.out.println(profile + " for user:" + profile.getUser().getFullName());
//        }


        HibernateUtil.shutdown();


    }
}
