package com.sut.ist.rotaback.controllers.test;

import java.io.*;
import java.util.*;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.controllers.auth.dto.ProfileDTO;
import com.sut.ist.rotaback.controllers.auth.dto.RulesLevel;
import com.sut.ist.rotaback.controllers.auth.request.LoginRequest;
import com.sut.ist.rotaback.controllers.auth.request.TokenRequest;
import com.sut.ist.rotaback.controllers.profile.dto.ProfileTableRowDTO;
import com.sut.ist.rotaback.controllers.profile.request.ProfileTableRequest;
import com.sut.ist.rotaback.entity.Profile;
import com.sut.ist.rotaback.entity.ProfileLogin;
import com.sut.ist.rotaback.entity.ProfilePhoto;
import com.sut.ist.rotaback.entity.ProfileRating;
import com.sut.ist.rotaback.mapper.ProfileMapper;
import com.sut.ist.rotaback.repository.LoginRepository;
import com.sut.ist.rotaback.repository.PhotoRepository;
import com.sut.ist.rotaback.repository.ProfileRepository;
import com.sut.ist.rotaback.repository.RatingRepository;
import com.sut.ist.rotaback.services.analyze.AnalyzeService;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class TestRest {
    private final AnalyzeService analyzeService;
    private final ProfileRepository profileRepository;
    private final LoginRepository loginRepository;
    private final ProfileMapper profileMapper;
    private final PhotoRepository photoRepository;
    private final RatingRepository ratingRepository;

    @Autowired
    TestRest(final AnalyzeService analyzeService,
             final ProfileRepository ProfileRepository,
             final LoginRepository LoginRepository,
             final ProfileMapper profileMapper,
             final PhotoRepository PhotoRepository,
             final RatingRepository RatingRepository) {
        this.analyzeService = analyzeService;
        this.profileRepository = ProfileRepository;
        this.loginRepository = LoginRepository;
        this.profileMapper = profileMapper;
        this.photoRepository = PhotoRepository;
        this.ratingRepository = RatingRepository;
    }

    @PostMapping(value = "/login")
    public @ResponseBody
    LoginDTO getLogin(@RequestBody LoginRequest request) {
        if (StringUtils.isBlank(request.getLogin()) || StringUtils.isBlank(request.getPassword())) {
            throw new RuntimeException("Login or password is empty");
        }
        return new LoginDTO("Admin", UUID.randomUUID().toString(), RulesLevel.ADMIN.value);
    }

    @PostMapping(value = "/profile")
    public @ResponseBody
    ProfileDTO getProfile(@RequestBody TokenRequest request) {
        if ("Admin".equalsIgnoreCase(request.getLogin())) {
            var profile = new ProfileDTO();
            profile.setRating(100);
            profile.setAge(25);
            profile.setFirstName("Вадим");
            profile.setMiddleName("Мельников");
            profile.setLastName("Александрович");
            profile.setCity("Санкт-Петербург");
            return profile;
        }
        return new ProfileDTO();
    }

    @GetMapping(value = "/profile/photo")
    public @ResponseBody
    byte[] getProfilePhoto() {
        try (var fos = new FileInputStream("src/main/resources/static/testProfile.jpg")) {
            Base64 encoder = new Base64();
            return encoder.encode(fos.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/header/photo")
    public @ResponseBody
    byte[] getHeaderPhoto() {
        try (var fos = new FileInputStream("src/main/resources/static/headerIcon.jpg")) {
            Base64 encoder = new Base64();
            return encoder.encode(fos.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value = "/profile/table")
    public @ResponseBody
    ResponseEntity<ProfileTableRowDTO[]> getProfileTableRows(ProfileTableRequest request) {
        ProfileTableRowDTO[] rows = analyzeService.getTableRows(10);
        return ResponseEntity.ok(rows);
    }

    @GetMapping("/create")
    public @ResponseBody
    String test() {
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

    @GetMapping("/get/{id}")
    public @ResponseBody
    ProfileDTO getProfileById(@PathVariable final String id) {
        Profile profile = profileRepository.getByProfileId(id);
        if (profile.getId() != null) {
            return profileMapper.toDto(profile);
        } else {
            throw new HibernateException("Profile[" + id + "] does not exist!");
        }
    }
}
