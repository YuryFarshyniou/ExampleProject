package service;


import org.hibernate.Session;

public interface CourseService {
    void fillBd(Session session);

    void getStudentsByCourse(Session session);

    void deleteStudents(Session session);

    void addStudent(Session session);

    void deleteCourse(Session session, Session sessionForDeleteOperation);
}