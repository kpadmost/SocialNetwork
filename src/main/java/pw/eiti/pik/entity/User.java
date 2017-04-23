package pw.eiti.pik.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Konstantin on 14.04.2017.
 */
@Entity
@Table(name = "user", schema = "public")

public class User {

    @Column(name = "id")
    @Id @GeneratedValue
    private  long id;

    @Column(name = "first_name", length = 30)
    @NotNull
    private String firstName;

    @Column(name = "surname", length = 30)
    @NotNull
    private String surname;

    @Column(name = "birthplace", length = 50)
    private String birthplace;

    @Column(name = "residence_place", length = 50)
    private String residencePlace;

    //TODO: datatime
    @Column(name = "birthday")
    private String  birthday;

    @Column(name = "new_notifications_number")
    private int notificationNumber;

    @Column(name = "custom_id", length = 50)
    private String customPersonalId;

    @Column(name = "status")
    private String status;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidencePlace() {
        return residencePlace;
    }

    public void setResidencePlace(String residencePlace) {
        this.residencePlace = residencePlace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getNotificationNumber() {
        return notificationNumber;
    }

    public void setNotificationNumber(int notificationNumber) {
        this.notificationNumber = notificationNumber;
    }

    @Override
    public String toString() {
        return "id: " + id + " " + firstName + " " + surname;
    }
}
