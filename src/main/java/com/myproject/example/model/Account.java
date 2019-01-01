package com.myproject.example.model;

import com.myproject.example.model.enumPackage.UserRole;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by stpl on 1/1/19.
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Column(name = "user_name", length = 55, nullable = false)
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private boolean active;

    @Column(name = "userRole")
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
