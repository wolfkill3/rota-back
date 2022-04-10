package com.sut.ist.rotaback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sut.ist.rotaback.controllers.auth.dto.RulesLevel;

@Entity
public class ProfileLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
    @Column(nullable = false, unique = true)
    private String login;
    private String password;
    private String email;
    @Column(name = "permission")
    private RulesLevel permission;

    public Long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(final Profile profile) {
        this.profile = profile;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public RulesLevel getPermission() {
        return permission;
    }

    public void setPermission(final RulesLevel permission) {
        this.permission = permission;
    }
}
