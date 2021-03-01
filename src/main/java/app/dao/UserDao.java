package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao{

    void setDefaultRole(User user);

    List<User> getUsers();
    void saveUser(User user);
    void delete(int id);
    void update(int id, String updateName, int updateAge, String updateEmail, String password);
    User getOne(int id);
    User getUserByName(String username);

    void createTable();
    void dropTable();
    void cleanTable();
}
