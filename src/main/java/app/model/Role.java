package app.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table
public class Role implements GrantedAuthority {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name = "name")
    private String role;

    public Role() {}

    public Role(String role) {
        this.role = role;
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long longId = Double.doubleToLongBits(getId());
        long longRole = Double.doubleToLongBits(Double.parseDouble(getRole()));
        result = 17 * result + (int) longId;
        result = 17 * result + (int) longRole;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (getClass() != obj.getClass() || obj==null) {return false;}

        Role role = (Role) obj;
        return (role.getId() == this.getId() && role.getRole()==((Role) obj).getRole());
    }

    @Override
    public String toString() {
        return "Role: " + id + ", role: " + getRole();
    }
}
