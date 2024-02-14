package entities;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "users")
public class User implements Serializable{
    private static final long serialVersionUID = -7244756746427350702L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}