package app.dao;

import app.model.Role;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public User getUserByName(String username) {
        TypedQuery<User> user = entityManager.createQuery("from User where name =:name", User.class)
                .setParameter("name", username);
        return user.getSingleResult();
    }

    @Override
    @Transactional
    public void setDefaultRole(User user) {
        Set<Role> roles = new HashSet<>();
        Role role = (Role) entityManager.createQuery("from Role where name =:roleName")
                .setParameter("roleName", "USER").getSingleResult();
        roles.add(role);
        user.setRoles(roles);
        entityManager.merge(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public void saveUser(User user) { entityManager.persist(user);}


    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public void update(int id, String updateName, int updateAge, String updateEmail, String password) {
        User user = getOne(id);
        user.setName(updateName);
        user.setAge(updateAge);
        user.setEmail(updateEmail);
        user.setPassword(password);
        entityManager.merge(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public User getOne(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public void delete(int id) {
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
    @Override
    @SuppressWarnings("unchecked")
    public void cleanTable() {
        entityManager.createQuery("delete from User").executeUpdate();
    }
    @Override
    @SuppressWarnings("unchecked")
    public void createTable() {
        String sqlCreateTable = "CREATE TABLE if not exists User (\n" +
                "  `id` INT NOT NULL auto_increment,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  `email` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));\n";
        entityManager.createNativeQuery(sqlCreateTable).executeUpdate();
    }
    @Override
    @SuppressWarnings("unchecked")
    public void dropTable() {
        entityManager.createNativeQuery("drop table User").executeUpdate();
    }
}
