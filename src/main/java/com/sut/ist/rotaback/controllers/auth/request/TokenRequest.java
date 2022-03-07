package com.sut.ist.rotaback.controllers.auth.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRequest {
    private String token;
    private String login;
}
