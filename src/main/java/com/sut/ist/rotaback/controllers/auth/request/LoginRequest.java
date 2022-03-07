package com.sut.ist.rotaback.controllers.auth.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest extends TokenRequest {
    private String password;
}
