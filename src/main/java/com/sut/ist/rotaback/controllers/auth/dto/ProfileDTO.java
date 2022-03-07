package com.sut.ist.rotaback.controllers.auth.dto;

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
}
