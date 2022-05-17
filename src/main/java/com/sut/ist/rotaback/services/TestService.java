package com.sut.ist.rotaback.services;

import java.util.*;

import com.sut.ist.rotaback.controllers.auth.dto.ProfileDTO;
import com.sut.ist.rotaback.controllers.auth.dto.RulesLevel;
import com.sut.ist.rotaback.entity.ProfileLogin;
import com.sut.ist.rotaback.entity.ProfilePhoto;
import com.sut.ist.rotaback.entity.ProfileRating;
import com.sut.ist.rotaback.mapper.ProfileMapper;
import com.sut.ist.rotaback.repository.LoginRepository;
import com.sut.ist.rotaback.repository.PhotoRepository;
import com.sut.ist.rotaback.repository.ProfileRepository;
import com.sut.ist.rotaback.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final LoginRepository loginRepository;
    private final PhotoRepository photoRepository;
    private final RatingRepository ratingRepository;

    @Autowired
    public TestService(final ProfileRepository profileRepository, final ProfileMapper profileMapper,
                       final LoginRepository loginRepository, final PhotoRepository photoRepository,
                       final RatingRepository ratingRepository) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
        this.loginRepository = loginRepository;
        this.photoRepository = photoRepository;
        this.ratingRepository = ratingRepository;
    }

    public String addProfile() {
        var profile = new ProfileDTO();
        profile.setDateOfBirth(new Date());
        profile.setFirstName("Вадим");
        profile.setMiddleName("Мельников");
        profile.setLastName("Александрович");
        profile.setCity("Санкт-Петербург");
        var profileEntity = profileMapper.toEntity(profile);
        var afterSave = profileRepository.save(profileEntity);

        var login = new ProfileLogin();
        login.setLogin("admin");
        login.setPassword("1");
        login.setEmail("testEmail@test.com");
        login.setProfile(afterSave);
        login.setPermission(RulesLevel.ADMIN);
        loginRepository.save(login);

        var photo = new ProfilePhoto();
        photo.setPath("src/main/resources/static/testProfile.jpg");
        photo.setProfile(afterSave);
        photoRepository.save(photo);

        var rating = new ProfileRating();
        rating.setRating(100);
        rating.setProfile(afterSave);
        ratingRepository.save(rating);
        return "success";
    }
}
