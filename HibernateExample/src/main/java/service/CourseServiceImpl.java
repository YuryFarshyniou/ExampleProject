package service;

import bean.Course;
import bean.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Override
    public void fillBd(Session session) {
        Student student = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();
        Student student6 = new Student();
        Course course = new Course();
        course.setName("Java Enterprise");
        course.getStudents().addAll(Arrays.asList(student,student2,student6,student5));
        Course course2 = new Course();
        course2.setName("Python for Faggots");
        course.getStudents().addAll(Arrays.asList(student3,student4));
        student.setCourse(course);
        student2.setCourse(course2);
        student3.setCourse(course);
        student4.setCourse(course);
        student5.setCourse(course2);
        student6.setCourse(course);
        student.setGrade(8);
        student2.setGrade(2);
        student3.setGrade(6);
        student4.setGrade(7);
        student5.setGrade(3);
        student6.setGrade(5);

        session.persist(student);
        session.persist(student2);
        session.persist(student3);
        session.persist(student4);
        session.persist(student5);
        session.persist(student6);
        session.persist(course);
        session.persist(course2);

    }

    @Override
    public void getStudentsByCourse(Session session) {
        Query query = session.createQuery("from Student st where st.course.name = :courseName",Student.class);
        query.setParameter("courseName","Java Enterprise");
        query.list().forEach(System.out::println);
    }

    @Override
    public void deleteStudents(Session session) {
        Query query = session.createQuery("delete from Student st where st.grade < :grade ");
        query.setParameter("grade", 6);
        int i = query.executeUpdate();
    }

    @Override
    public void addStudent(Session session) {
        Query query = session.createQuery("from Course c where c.name = :name").setParameter("name", "Java Enterprise");
        List<Course> list = query.list();
        Student student = new Student();
        student.setCourse(list.get(0));
        session.persist(student);
    }

    @Override
    public void deleteCourse(Session session, Session newSessionForDelete) {
        List<Student> list = session.createQuery("from Student st where st.course.name = :courseName")
                .setParameter("courseName", "Java Enterprise")
                .list();
        list.forEach(student ->{
            student.setCourse(null);
            session.persist(student);
        });
        newSessionForDelete.createQuery("delete from Course c where c.name = :name")
                .setParameter("name", "Java Enterprise")
                .executeUpdate();
    }
}
