package crud.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "courses")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "")
    @SequenceGenerator(name = "company_generator",
    sequenceName = "company_sequence",
    allocationSize = 1)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "locate_Country")
    private String locateCountry;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
    mappedBy = "company")
    private List<Course> courceList;

    public Company() {
    }

    public Company(String companyName, String locateCountry) {
        this.companyName = companyName;
        this.locateCountry = locateCountry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocateCountry() {
        return locateCountry;
    }

    public void setLocateCountry(String locateCountry) {
        this.locateCountry = locateCountry;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locateCountry='" + locateCountry + '\'' +
                '}';
    }
}
