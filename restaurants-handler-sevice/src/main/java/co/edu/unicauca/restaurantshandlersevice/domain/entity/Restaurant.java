package co.edu.unicauca.restaurantshandlersevice.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */
/**
 * In other version the Loombok dependence is used for simplify the
 * code lines. In this case is not used and the code is writed
 * explicitly because the lack of experience by the writer programmer
 */
@Entity
@Table(name = "restaurants")
public class Restaurant implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rest_nit", nullable = false, unique = true)
    private Long nit;
    @Column(name = "rest_name", length = 100, nullable = false)
    private String name;
    @Column(name = "rest_slogan")
    private String slogan;
    @Column(name = "rest_Owner", nullable = false)
    private String restOwner;
    @Column(name = "rest_Admin", nullable = false)
    private String restAdmin;
    @Column(name = "rest_city", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumRestaurantCity city;
    @Column(name = "rest_address", nullable = false)
    private String address;

    /**
     * A restaruant could has multiple numbers. The numbers attribute is other
     * table (The connection is unidirectional, only by restaurant to numbers).
     * Saved a JSon request list is other way to implements it.
     */
    @OneToMany(targetEntity = RestaurantNumber.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_fk", referencedColumnName = "rest_nit")
    private List<RestaurantNumber> numbers;
    @Column(name = "rest_Img", nullable = false)
    private String imgUrl;

    //Constructors

    public Restaurant() {}

    public Restaurant(Long nit, String name, String slogan, String restOwner, String restAdmin, EnumRestaurantCity city,String address, String imgUrl) {
        this.nit = nit;
        this.name = name;
        this.slogan = slogan;
        this.restOwner = restOwner;
        this.restAdmin = restAdmin;
        this.city = city;
        this.address = address;
        this.imgUrl = imgUrl;
    }
    
    @Override
    public String toString() {
        return "Restaurant [address=" + address + ", city=" + city + ", imgUrl=" + imgUrl + ", name=" + name + ", nit=" + nit + ", numbers=" + numbers + ", restAdmin=" + restAdmin + ", restOwner=" + restOwner + ", slogan=" + slogan + "]";
    }

    //Getters and Setters mutators

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getRestOwner() {
        return restOwner;
    }

    public void setRestOwner(String restOwner) {
        this.restOwner = restOwner;
    }

    public String getRestAdmin() {
        return restAdmin;
    }

    public void setRestAdmin(String restAdmin) {
        this.restAdmin = restAdmin;
    }

    public EnumRestaurantCity getCity() {
        return city;
    }

    public void setCity(EnumRestaurantCity city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<RestaurantNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<RestaurantNumber> numbers) {
        this.numbers = numbers;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
