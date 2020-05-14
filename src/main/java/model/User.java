package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")

public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(long id, String name, String password, String email) {
        this(name, email, password);
        this.id = id;
    }

    public User(String name, String email, String password, String role) {
        this(name, email, password);
        this.role=role;
    }

    public User(long id, String name, String email, String password, String role) {
        this(id, name, password, email);
        this.role=role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String workplace) {
        this.password = workplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
