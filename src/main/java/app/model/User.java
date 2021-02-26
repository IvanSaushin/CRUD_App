package app.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String email;

//    @ManyToMany
//    @JoinTable(name = "users_roles",
//                joinColumns = @JoinColumn(name = "user_id"),
//                inverseJoinColumns = @JoinColumn(name = "role_id"))
//    public Set<Role> roles;


    public User() {}

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

//    public User(String name, int age, String email, Set<Role> roles) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//        this.roles = roles;
//    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long longId = Double.doubleToLongBits(getId());
       long longEmail = Double.doubleToLongBits(Double.parseDouble(getEmail()));
        result = 17 * result + (int) longId;
        result = 17 * result + (int) longEmail;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (getClass() != obj.getClass() || obj==null) {return false;}

        User user = (User) obj;
        return (user.getId() == this.getId() && user.getName()==((User) obj).getName() &&
                user.getAge() == this.getAge() && user.getEmail() == this.getEmail());
    }

    @Override
    public String toString() {
        return "User " + id + ", name: " + getName() + ", age: " + getAge() + ", Email: " + getEmail();
    }
}
