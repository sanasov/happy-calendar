package ru.igrey.dev.domain;

import java.time.LocalDate;
import java.util.List;

public class User {

    private Long id;
    private String login;
    private String password;
    private String username;
    private String lastName;
    private LocalDate birthday;
    private List<String> roles;

    public User() {
    }

    public User(Long id, String login, String password, String username, String lastName, LocalDate birthday, List<String> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
        this.lastName = lastName;
        this.birthday = birthday;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
