package pw.eiti.pik.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.eiti.pik.dao.UserDAO;
import pw.eiti.pik.entity.User;


import java.util.ArrayList;

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

    public long isPersonExsist(User p){
        ArrayList<User> l = new ArrayList<>();
        userDAO.findAll().forEach(l::add);
        if(l.stream().anyMatch(usr -> usr.getPassword().equals(p.getPassword()) && usr.getEmail().equals(p.getEmail())))
            return l.stream().filter(usr -> usr.getPassword().equals(p.getPassword()) && usr.getEmail().equals(p.getEmail())).findFirst().get().getId();
        else
            return -1;
    }
}
