package com.sut.ist.rotaback.controllers.register.request;

import java.util.*;

import com.sut.ist.rotaback.controllers.auth.request.TokenRequest;

public class RegisterRequest extends TokenRequest {
    public String firstName;
    public String middleName;
    public String lastName;
    public String password;
    public String email;
    public String city;
    public Date dateOfBirth;
}
