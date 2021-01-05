/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.RegisterJerseyClient;
import client.UsersJerseyClient;
import entity.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author hi
 */
@Named(value = "registerManagedBean")
@SessionScoped
public class RegisterManagedBean implements Serializable {

    /**
     * Creates a new instance of RegisterManagedBean
     */
    public RegisterManagedBean() {
    }
    RegisterJerseyClient jerseyClient = new RegisterJerseyClient();
    private int userid;
    private String name, email, phno, interest, gender="male", city, password, birthdateString, sessionEmail;
    private Date birthdate;
    private Collection<Users> ulist;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdateString() {
        return birthdateString;
    }

    public void setBirthdateString(String birthdateString) {
        this.birthdateString = birthdateString;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Collection<Users> getUlist() {
        return ulist;
    }

    public void setUlist(Collection<Users> ulist) {
        this.ulist = ulist;
    }

    public String addUser() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String bdate = df.format(birthdate);
        jerseyClient.RegisterUser(name, phno, password, interest, gender, email, city, bdate);
        return "/Login.xhtml?faces-redirect=true";
    }

    public Date getToday() {
        return new Date();
    }

}
