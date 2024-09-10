import bean.Course;
import bean.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import session_factory.SessionFactoryContainer;

import java.util.Arrays;

public class HibernateTest {

    @Test
    public void addCoachAndFewCoursesTest() {
        SessionFactory sessionFactory = SessionFactoryContainer.getSessionFactoryContainer().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course course = new Course();
        course.setName("SQL");
        Course course2 = new Course();
        course2.setName("Docker");

        Trainer trainer = new Trainer();

        session.persist(trainer);
        session.persist(course);
        session.persist(course2);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void changeCourseTest() {
        SessionFactory sessionFactory = SessionFactoryContainer.getSessionFactoryContainer().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course course = session.get(Course.class, 3L);
        course.setName("JavaBober");

session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void deleteCourseTest(){
        SessionFactory sessionFactory = SessionFactoryContainer.getSessionFactoryContainer().getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course course = session.get(Course.class, 11L);
        session.remove(course);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

}
