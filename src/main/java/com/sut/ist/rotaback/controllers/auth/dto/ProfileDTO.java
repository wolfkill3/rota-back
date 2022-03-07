package com.sut.ist.rotaback.controllers.auth.dto;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Setter
public class ProfileDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String city;
    private int age;
    private int rating;
}
