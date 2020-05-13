package model;

import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String workplace;
    private String email;

    public User() {
    }

    public User(String name, String email, String workplace) {
        this.name = name;
        this.workplace = workplace;
        this.email=email;
    }

    public User(long id, String name, String workplace, String email) {
        this.id = id;
        this.name = name;
        this.workplace = workplace;
        this.email=email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
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
