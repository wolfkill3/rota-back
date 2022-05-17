package com.sut.ist.rotaback.controllers.auth.dto;

import java.util.*;

import com.sut.ist.rotaback.controllers.register.request.RegisterRequest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class ProfileDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String city;
    private int age;
    private int rating;
    private Date dateOfBirth;


    public static ProfileDTO buildFromRequest(RegisterRequest request) {
        var profile = new ProfileDTO();
        profile.setFirstName(request.firstName);
        profile.setMiddleName(request.middleName);
        profile.setLastName(request.lastName);
        profile.setCity(request.city);
        profile.setDateOfBirth(request.dateOfBirth);
        return profile;
    }
}
