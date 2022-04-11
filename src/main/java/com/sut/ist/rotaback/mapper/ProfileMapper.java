package com.sut.ist.rotaback.mapper;

import com.sut.ist.rotaback.controllers.auth.dto.ProfileDTO;
import com.sut.ist.rotaback.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper extends AbstractEntityMapper<ProfileDTO, Profile> {

    @Override
    public ProfileDTO toDto(final Profile profile) {
        var dto = new ProfileDTO();
        dto.setFirstName(profile.getFirstName());
        dto.setMiddleName(profile.getMiddleName());
        dto.setLastName(profile.getLastName());
        dto.setCity(profile.getCity());
        dto.setDateOfBirth(profile.getDateOfBirth());
        return dto;
    }

    @Override
    public Profile toEntity(final ProfileDTO dto) {
        var profile = new Profile();
        profile.setFirstName(dto.getFirstName());
        profile.setMiddleName(dto.getMiddleName());
        profile.setLastName(dto.getLastName());
        profile.setCity(dto.getCity());
        profile.setDateOfBirth(dto.getDateOfBirth());
        return profile;
    }
}
