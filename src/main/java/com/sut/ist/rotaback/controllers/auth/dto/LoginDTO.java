package com.sut.ist.rotaback.controllers.auth.dto;

public class LoginDTO {
    private final String login;
    private final String token;
    private final int rulesLevel;

    public LoginDTO(final String login, final String token, final int rulesLevel) {
        this.login = login;
        this.token = token;
        this.rulesLevel = rulesLevel;
    }

    public String getLogin() {
        return login;
    }

    public String getToken() {
        return token;
    }

    public int getRulesLevel() {
        return rulesLevel;
    }
}
