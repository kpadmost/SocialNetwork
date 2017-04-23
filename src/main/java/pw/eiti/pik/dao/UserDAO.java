package pw.eiti.pik.dao;


import org.springframework.data.repository.CrudRepository;
import pw.eiti.pik.entity.User;

/**
 * Created by Konstantin on 14.04.2017.
 */
public interface UserDAO extends CrudRepository<User, Long> {

}


