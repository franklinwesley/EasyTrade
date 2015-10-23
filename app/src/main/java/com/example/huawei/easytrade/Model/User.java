package com.example.huawei.easytrade.Model;

/**
 * Created by huawei on 21/10/15.
 */
public class User {

    private String name;
    private String email;
    private String phone;
    private String password;
    private String login;
    private String photo;

    public User(String name, String email, String phone, String password, String login, String photo) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.login = login;
        this.photo = photo;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
