package com.sut.ist.rotaback.controllers.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class LoginDTO {
    private final String login;
    private final String token;
    private final int rulesLevel;
}
