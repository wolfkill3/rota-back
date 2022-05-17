package com.sut.ist.rotaback.entity;

import java.util.*;

import com.sut.ist.rotaback.RotaBackApplication;
import com.sut.ist.rotaback.controllers.auth.dto.ProfileDTO;
import com.sut.ist.rotaback.mapper.ProfileMapper;
import com.sut.ist.rotaback.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RotaBackApplication.class})
class ProfileTest {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileMapper profileMapper;

    @Test
    void createProfileTest() {
        var profile = new ProfileDTO();
        profile.setDateOfBirth(new Date());
        profile.setFirstName("Вадим");
        profile.setMiddleName("Мельников");
        profile.setLastName("Александрович");
        profile.setCity("Санкт-Петербург");
        profileRepository.save(profileMapper.toEntity(profile));
        System.out.println(profileRepository.findAll());
    }
}