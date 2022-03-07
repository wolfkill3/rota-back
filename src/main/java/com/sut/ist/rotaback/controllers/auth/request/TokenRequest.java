package com.sut.ist.rotaback.controllers.auth.request;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class TokenRequest {
    private String token;
    private String login;
}
