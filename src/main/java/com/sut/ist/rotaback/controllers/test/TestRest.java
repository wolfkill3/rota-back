package com.sut.ist.rotaback.controllers.test;

import java.io.*;
import java.util.*;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.sut.ist.rotaback.controllers.auth.request.LoginRequest;
import com.sut.ist.rotaback.controllers.auth.request.TokenRequest;
import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.controllers.auth.dto.ProfileDTO;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/test")
public class TestRest {
    @PostMapping(value = "/login")
    public @ResponseBody
    LoginDTO getLogin(@RequestBody LoginRequest request) {
        if (StringUtils.isBlank(request.login()) || StringUtils.isBlank(request.password())) {
            throw new RuntimeException("Login or password is empty");
        }
        return new LoginDTO("Admin", UUID.randomUUID().toString(), 10);
    }

    @PostMapping(value = "/profile")
    public @ResponseBody
    ProfileDTO getProfile(@RequestBody TokenRequest request) {
        if ("Admin".equalsIgnoreCase(request.login())) {
            var profile = new ProfileDTO();
            profile.rating(100);
            profile.age(25);
            profile.firstName("Вадим");
            profile.middleName("Мельников");
            profile.lastName("Александрович");
            profile.city("Санкт-Петербург");
            return profile;
        }
        return new ProfileDTO();
    }

    @GetMapping(value = "/photo")
    public @ResponseBody
    byte[] getProfilePhoto() {
        try (var fos = new FileInputStream("src/main/resources/static/testProfile.jpg")) {
            Base64 encoder = new Base64();
            return encoder.encode(fos.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping
    public @ResponseBody
    String test() {
        return "success";
    }
}
