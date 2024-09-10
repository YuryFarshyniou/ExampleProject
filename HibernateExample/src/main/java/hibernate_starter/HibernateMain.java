package hibernate_starter;

import bean.Course;
import bean.SpaceMarine;
import bean.Trainer;
import bean.TrainerCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import service.CourseService;
import service.CourseServiceImpl;
import session_factory.SessionFactoryContainer;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class HibernateMain implements Serializable {
    public static void main(String[] args) {

        SessionFactoryContainer builder = SessionFactoryContainer.getSessionFactoryContainer();

        SessionFactory sessionFactory = builder.getSessionFactory();

        CourseService courseService = new CourseServiceImpl();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        courseService.fillBd(session);
//        courseService.getStudentsByCourse(session);
//        courseService.deleteStudents(session);
//        courseService.addStudent(session);
//        courseService.deleteCourse(session,sessionForDeleteOperation);

//        Course course = session.get(Course.class,3L);
//        Trainer trainer = session.get(Trainer.class,3L);
//
//        TrainerCourse trainerCourse = new TrainerCourse();
//        trainerCourse.setCreatedAt(Instant.now());
//        trainerCourse.setCreatedBy("Yurachel");
//        trainerCourse.setCourse(course);
//        trainerCourse.setTrainer(trainer);
//
//
//session.persist(trainerCourse);

        session.getTransaction().commit();
        sessionFactory.close();
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
// Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
// Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
// Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
// Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
// Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
// Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

}
