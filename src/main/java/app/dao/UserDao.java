package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao{

    List<User> getUsers();
    void save(String name, int age, String email);
    void saveUser(User user);
    void delete(int id);
    void update(int id, String updateName, int updateAge, String updateEmail);
    User getOne(int id);
    User getUserByName(String username);

    void createTable();
    void dropTable();
    void cleanTable();
}
