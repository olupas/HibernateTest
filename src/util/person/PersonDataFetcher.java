package util.person;

import my.model.Address;
import my.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author olupas
 * @since 15.08.2014
 */
public class PersonDataFetcher implements Serializable {
    public static void main(String[] args) {
        SessionFactory fact = HibernateUtil.getSessionFactory();
        Session session = fact.openSession();
        System.out.println("--------------Loading Person Data----------------");

        Person p = (Person) session.get(Person.class, 1);
        System.out.println(p);
        List<Address> pAddresses = p.getAddresses();
        System.out.println("# of addresses: " + pAddresses.size());
        for (Address address : pAddresses) {
            System.out.println(address);
        }
        System.out.println("--------------------------------------------------");
        session.close();

        session = fact.openSession();

        System.out.println("--------------Retrieving Persons Data-------------");
        Query q = session.createQuery(" FROM Person p ");
        List<Person> l = q.list();
        System.out.println("Data retrieved: " + l.size());
        for (Person person : l) {
            System.out.println("--->" + person);
            List<Address> addresses = person.getAddresses();
            System.out.println("Address retrieval complete.");
            int i = 1;
            for (Address address : addresses) {
                System.out.println(address);
                i++;
            }
        }

    }
}
