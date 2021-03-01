package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void save(String name, int age, String email) {
        userDao.save(name, age, email);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.saveUser(user);
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
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByName(username);
    }

    @Override
    @Transactional
    public void cleanTable() {
        userDao.cleanTable();
    }
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
}
