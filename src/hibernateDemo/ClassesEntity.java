package hibernateDemo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pxc on 2017/8/21.
 */
@Entity
@Table(name="tab_classes")
public class ClassesEntity {

    private String id;
    private String name;
    private Set<StuEntity> stuEntities = new HashSet<>();

    //
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "classesGenerator")
    @GenericGenerator(name = "classesGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy="classesEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<StuEntity> getStuEntities() {
        return stuEntities;
    }

    public void setStuEntities(Set<StuEntity> stuEntities) {
        this.stuEntities = stuEntities;
    }
}
