package crud.entity;




import javax.persistence.*;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "")
    @SequenceGenerator(name = "course_generator",
    sequenceName = "course_sequence",
    allocationSize = 1)
    private long id;

    @Column(name = "course_Name")
    private String courseName;

    @Column(name = "duration_Month")
    private String durationMonth;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Course() {
    }

    public Course(String courseName, String durationMonth) {
        this.courseName = courseName;
        this.durationMonth = durationMonth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDurationMonth() {
        return durationMonth;
    }

    public void setDurationMonth(String durationMonth) {
        this.durationMonth = durationMonth;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", durationMonth='" + durationMonth + '\'' +
                '}';
    }
}
