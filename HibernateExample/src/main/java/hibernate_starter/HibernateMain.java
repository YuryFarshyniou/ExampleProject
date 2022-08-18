package hibernate_starter;

import bean.SpaceMarine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateMain {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = factory.openSession();
        SpaceMarine Loken = new SpaceMarine();
        Loken.setName("Loken");
        session.beginTransaction();
        session.persist(Loken);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
