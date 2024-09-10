package bean;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<TrainerCourse> trainerCourses;

    public Course() {
        this.students = new ArrayList<>();
        this.trainerCourses = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrainerCourse> getTrainerCourses() {
        return trainerCourses;
    }

    public void setTrainerCourses(List<TrainerCourse> trainerCourses) {
        this.trainerCourses = trainerCourses;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\''+     '}';
    }
}
