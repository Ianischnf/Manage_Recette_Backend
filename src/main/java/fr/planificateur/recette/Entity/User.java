package fr.planificateur.recette.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long UserId;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Password")
    @JsonIgnore
    private String Password;

    public User() {}

    public User(Long userId, String firstName, String lastName, String email, String password) {
        this.UserId     = userId;
        this.FirstName  = firstName;
        this.LastName   = lastName;
        this.Email      = email;
        this.Password   = password;
    }

    public User(String firstName, String lastName, String email, String password) {
        this.FirstName  = firstName;
        this.LastName   = lastName;
        this.Email      = email;
        this.Password   = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
}
