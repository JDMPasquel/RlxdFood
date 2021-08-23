package co.edu.unicauca.userservice.domain.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clients")
public class UserClient implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cli_name", nullable = false)
    private String name;
    @Column(name =  "cli_biologic_gender")
    @Enumerated(EnumType.STRING)
    private EnumGenderClient biologicGender;
    @Column(name = "cli_birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;
    @Column(name = "cli_number")
    private String phoneNumber;
    @Column(name = "cli_email", nullable = false)
    private String email;
    @Column(name = "cli_pass", nullable = false)
    private String password;

    public UserClient() {}

    public UserClient(Long id, String name, EnumGenderClient biologicGender, Calendar birthDate, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.biologicGender = biologicGender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
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

    public EnumGenderClient getBiologicGender() {
        return biologicGender;
    }

    public void setBiologicGender(EnumGenderClient biologicGender) {
        this.biologicGender = biologicGender;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
