package com.sut.ist.rotaback.services;

import java.util.*;
import java.util.stream.Collectors;

import com.sut.ist.rotaback.controllers.rating.dto.RatingProfile;
import com.sut.ist.rotaback.entity.Profile;
import com.sut.ist.rotaback.repository.LoginRepository;
import com.sut.ist.rotaback.repository.ProfileRepository;
import com.sut.ist.rotaback.repository.RatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RatingService {
    private final LoginRepository loginRepository;
    private final ProfileRepository profileRepository;
    private final RatingRepository ratingRepository;

    public RatingService(final LoginRepository loginRepository,
                         final ProfileRepository profileRepository,
                         final RatingRepository ratingRepository) {
        this.loginRepository = loginRepository;
        this.profileRepository = profileRepository;
        this.ratingRepository = ratingRepository;
    }

    public RatingProfile[] getRatingTable(final String login) {
        try {
            List<RatingProfile> profiles = new ArrayList<>();
            RatingProfile currentUserProfile = new RatingProfile();
            var userLogin = loginRepository.findByLogin(login).get();
            var userProfile = userLogin.getProfile();
            var userRating = ratingRepository.findByProfileId(userProfile.getId()).get();
            currentUserProfile.city = userProfile.getCity();
            currentUserProfile.fullName = buildFullName(userProfile);
            currentUserProfile.score = userRating.getRating();
            currentUserProfile.number = getNumber(currentUserProfile.score);
            profiles.add(currentUserProfile);
            return profiles.stream().sorted().toArray(RatingProfile[]::new);
        } catch (Exception e) {
            throw new RuntimeException("Profile does not exist");
        }
    }

    private Integer getNumber(Integer rating) {
        var all = ratingRepository.getCount();
        var higher = ratingRepository.getCountHigher(rating);
        return all-higher;
    }

    private String buildFullName(Profile profile) {
        return profile.getMiddleName() + " " + profile.getFirstName() + " " + profile.getLastName();
    }
}
