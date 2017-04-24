package pw.eiti.pik.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.eiti.pik.dao.UserDAO;
import pw.eiti.pik.entity.User;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by Konstantin on 14.04.2017.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public ArrayList<User> getAllPersons() {
        ArrayList<User> users = new ArrayList<>();

        userDAO.findAll().forEach(users::add);
        return users;
    }

    public void addPerson(User p) {
        //TODO: unique person email support
        userDAO.save(p);

    }

    public User findPersonById(long id) {
        return userDAO.findOne(id);
    }

    public void updatePerson(User p) {
        addPerson(p);
    }

    public void removePerson(long id) {
        userDAO.delete(id);
    }

    public long isPersonExist(User p){
        Optional<User> us = StreamSupport.stream(userDAO.findAll().spliterator(), false)
                .filter(u -> u.getEmail().equals(p.getEmail()) && u.getPassword().equals(p.getPassword()))
                .findFirst();
        return us.isPresent() ? us.get().getId() : -1;
    }
}
