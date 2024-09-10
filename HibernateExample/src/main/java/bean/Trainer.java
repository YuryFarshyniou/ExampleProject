package bean;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "trainer")
    private List<TrainerCourse> trainerCourses;

    public Trainer() {
        this.trainerCourses = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TrainerCourse> getTrainerCourses() {
        return trainerCourses;
    }

    public void setTrainerCourses(List<TrainerCourse> trainerCourses) {
        this.trainerCourses = trainerCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
