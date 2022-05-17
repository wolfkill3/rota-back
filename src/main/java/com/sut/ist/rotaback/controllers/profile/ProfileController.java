package com.sut.ist.rotaback.controllers.profile;

import java.io.*;

import com.sut.ist.rotaback.controllers.auth.dto.ProfileDTO;
import com.sut.ist.rotaback.controllers.auth.request.TokenRequest;
import com.sut.ist.rotaback.controllers.profile.dto.ProfileTableRowDTO;
import com.sut.ist.rotaback.controllers.profile.request.ProfileTableRequest;
import com.sut.ist.rotaback.services.AnalyzeService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {
    private final AnalyzeService analyzeService;

    @Autowired
    ProfileController(AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }

    @PostMapping
    public @ResponseBody
    ProfileDTO getProfile(@RequestBody TokenRequest request) {
        if ("Admin".equalsIgnoreCase(request.login)) {
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

    @PostMapping(value = "/table")
    public @ResponseBody
    ResponseEntity<ProfileTableRowDTO[]> getProfileTableRows(@RequestBody ProfileTableRequest request) {
        ProfileTableRowDTO[] rows = analyzeService.getTableRows(10);
        return ResponseEntity.ok(rows);
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
}
