package app.service;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserService{

    List<User> getUsers();
    void save(String name, int age, String email);
    void save(User user);
    void delete(int id);
    void update(int id, String updateName, int updateAge, String updateEmail);
    User getOne(int id);
    User getUserByName(String username);


    void createTable();
    void dropTable();
    void cleanTable();
}
