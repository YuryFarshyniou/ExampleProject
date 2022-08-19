package hibernate_starter;

import bean.SpaceMarine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session_factory.SessionFactoryContainer;

public class HibernateMain {
    public static void main(String[] args) {

        SessionFactoryContainer builder = SessionFactoryContainer.getSessionFactoryContainer();

        SessionFactory sessionFactory = builder.getSessionFactory();

        Session session = sessionFactory.openSession();
        SpaceMarine Loken = new SpaceMarine();
        Loken.setName("Loken");
        session.beginTransaction();
       session.merge(Loken);
        System.out.println(session.contains(Loken));
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
