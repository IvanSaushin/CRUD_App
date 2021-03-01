package app.service;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserService{

    void setDefaultRole(User user);

    List<User> getUsers();
    void save(User user);
    void delete(int id);
    void update(int id, String updateName, int updateAge, String updateEmail, String password);
    User getOne(int id);
    User getUserByName(String username);


    void createTable();
    void dropTable();
    void cleanTable();
}
