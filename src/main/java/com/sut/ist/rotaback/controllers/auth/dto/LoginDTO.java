package com.sut.ist.rotaback.controllers.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String login;
    private String token;
    private RulesLevel rulesLevel;
}
