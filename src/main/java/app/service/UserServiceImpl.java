package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;
//    UserDao userDao = new UserDaoImpl();

    @Override
    @Transactional
    public void createTable() {
        userDao.createTable();
    }

    @Override
    @Transactional
    public void dropTable() {
        userDao.dropTable();
    }

    @Override
    @Transactional
    public void save(String name, int age, String email) {
        userDao.save(name, age, email);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(int id, String updateName, int updateAge, String updateEmail) {
        userDao.update(id, updateName, updateAge, updateEmail);
    }

    @Override
    @Transactional
    public User getOne(int id) {
        return userDao.getOne(id);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void cleanTable() {
        userDao.cleanTable();
    }

//    @Override
//    @Transactional
//    public void save(String name, int age, String email) {
//        userDao.save(name, age, email);
//    }
//
//    @Override
//    @Transactional
//    public void update(long id, String updateName, int updateAge, String updateEmail) {
//        userDao.update(id, updateName, updateAge, updateEmail);
//    }
//
//    @Override
//    @Transactional
//    public User getOne(long id) {
//        return userDao.getOne(id);
//    }
//
//    @Override
//    @Transactional
//    public List<User> getUsers() {
//        return userDao.getUsers();
//    }
//
//    @Override
//    @Transactional
//    public void delete(long id) {
//        userDao.delete(id);
//    }

//    @Override
//    @Transactional
//    public void cleanTable() {
//        userDao.cleanTable();
//    }
}
