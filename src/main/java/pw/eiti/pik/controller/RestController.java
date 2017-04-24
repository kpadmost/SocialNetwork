package pw.eiti.pik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pw.eiti.pik.entity.User;
import pw.eiti.pik.service.UserService;

import java.util.List;

/**
 * Created by PAVEL-PC on 24.04.2017.
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        long tmp = Long.valueOf(id).longValue();
        return userService.findPersonById(tmp);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public void addUser(@RequestBody User user){
        userService.addPerson(user);
        userService.getAllPersons().stream().forEach(System.out::println);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/login")
    public long checkUser(@RequestBody User user){
        return userService.isPersonExsist(user);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody User user){
        userService.updatePerson(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable String id){
        long tmp = Long.valueOf(id).longValue();
        userService.removePerson(tmp);
    }
}
