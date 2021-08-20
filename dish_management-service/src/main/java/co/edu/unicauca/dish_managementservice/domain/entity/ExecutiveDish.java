package co.edu.unicauca.dish_managementservice.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "executive_dish")
public class ExecutiveDish implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    private String description;
    @Column(name = "Image")
    private String urlImg;

    public ExecutiveDish() {}

    public ExecutiveDish(Long id, String name, String description, String urlImg) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "ExecutiveDish [description=" + description + ", id=" + id + ", name=" + name + ", urlImg=" + urlImg+ "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
