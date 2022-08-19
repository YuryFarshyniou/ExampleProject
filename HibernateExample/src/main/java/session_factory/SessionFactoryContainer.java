package session_factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryContainer {
    private static SessionFactoryContainer sessionFactoryContainer = null;
    private SessionFactory sessionFactory;

    private SessionFactoryContainer() {

    }

    public static SessionFactoryContainer getSessionFactoryContainer() {
        if (sessionFactoryContainer == null) {
            sessionFactoryContainer = new SessionFactoryContainer();
        }
        return sessionFactoryContainer;
    }

    public SessionFactory getSessionFactory() {
        if (this.sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        }
        return sessionFactory;

    }
}











//    Configuration conf = new Configuration();
//            conf.configure();
//                    this.sessionFactory = conf.buildSessionFactory();