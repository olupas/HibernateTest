package util.person;

/**
 * Created with IntelliJ IDEA.
 *
 * @author olupas
 * @since 15.08.2014
 */
import my.model.Address;
import my.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PersonDataLoader {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Person p = new Person();
        p.setId(1);
        p.setFirstName("Bill");
        p.setLastName("Banks");

        Address a1 = new Address();
        a1.setFirstLine("Line 11");
        a1.setSecondLine("Line 12");
        a1.setZipCode("12345");
        a1.setId(1);
        a1.setPerson(p);
        p.addAddress(a1);

        Address a2 = new Address();
        a2.setFirstLine("Line 21");
        a2.setSecondLine("Line 22");
        a2.setZipCode("54321");
        a2.setId(2);
        a2.setPerson(p);
        p.addAddress(a2);

        Address a3 = new Address();
        a3.setFirstLine("Line 31");
        a3.setSecondLine("Line 32");
        a3.setZipCode("11221");
        a3.setId(3);
        a3.setPerson(p);
        p.addAddress(a3);

        Address a4 = new Address();
        a4.setFirstLine("Line 41");
        a4.setSecondLine("Line 42");
        a4.setZipCode("22331");
        a4.setId(4);
        a4.setPerson(p);
        p.addAddress(a4);

        Person p1 = new Person();
        p1.setId(2);
        p1.setFirstName("Steve");
        p1.setLastName("Jobs");

        Address a11 = new Address();
        a11.setFirstLine("Line 111");
        a11.setSecondLine("Line 112");
        a11.setZipCode("12345");
        a11.setId(5);
        a11.setPerson(p1);
        p1.addAddress(a11);

        Address a22 = new Address();
        a22.setFirstLine("Line 221");
        a22.setSecondLine("Line 222");
        a22.setZipCode("54321");
        a22.setId(6);
        a22.setPerson(p1);
        p1.addAddress(a22);

        Address a33 = new Address();
        a33.setFirstLine("Line 331");
        a33.setSecondLine("Line 332");
        a33.setZipCode("11221");
        a33.setId(7);
        a33.setPerson(p1);
        p1.addAddress(a33);

        Address a44 = new Address();
        a44.setFirstLine("Line 441");
        a44.setSecondLine("Line 442");
        a44.setZipCode("22331");
        a44.setId(8);
        a44.setPerson(p1);
        p1.addAddress(a44);

        Person p2 = new Person();
        p2.setId(3);
        p2.setFirstName("Clark");
        p2.setLastName("Jacob");

        Address a111 = new Address();
        a111.setFirstLine("Line 111");
        a111.setSecondLine("Line 112");
        a111.setZipCode("12345");
        a111.setId(9);
        a111.setPerson(p2);
        p2.addAddress(a111);

        Address a222 = new Address();
        a222.setFirstLine("Line 221");
        a222.setSecondLine("Line 222");
        a222.setZipCode("54321");
        a222.setId(10);
        a222.setPerson(p2);
        p2.addAddress(a222);

        session.save(p);
        session.save(p1);
        session.save(p2);

        tx.commit();
    }

}