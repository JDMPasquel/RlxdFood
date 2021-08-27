package co.edu.unicauca.restaurantshandlersevice.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */

@Entity
@Table(name = "restaurant_numbers")
public class RestaurantNumber implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nmb_id")
    private Long id;
    @Column(name = "nmb_number", nullable = false, unique = true)
    private String number;
    
    public RestaurantNumber() {}

    public RestaurantNumber(Long id, String number, Restaurant restaurant) {
        this.id = id;
        this.number = number;
    }

    //Getters and Setters mutators

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
