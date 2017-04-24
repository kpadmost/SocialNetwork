package pw.eiti.pik.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Konstantin on 14.04.2017.
 */
@Entity
@Table(name = "my_user")
public class User {

    public long getId() {
        return id;
    }

    @Column(name = "id")
    @Id @GeneratedValue
    private  long id;

    @Column(name = "first_name", length = 30)
    @NotNull
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "surname", length = 30)
    @NotNull
    @JsonProperty("surname")
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
    @JsonProperty("email")
    private String email;

    @Column(name = "password")
    @NotNull
    @JsonProperty("password")
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
        return "id: " + id + " " + getFirstName() + " " + getSurname();
    }

    public String getCustomPersonalId() {
        return customPersonalId;
    }

    public void setCustomPersonalId(String customPersonalId) {
        this.customPersonalId = customPersonalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
