package com.sut.ist.rotaback.mapper;

import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.entity.ProfileLogin;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper extends AbstractEntityMapper<LoginDTO, ProfileLogin> {
    @Override
    public LoginDTO toDto(final ProfileLogin profileLogin) {
        var dto = new LoginDTO();
        dto.setLogin(profileLogin.getLogin());
        return dto;
    }

    @Override
    public ProfileLogin toEntity(final LoginDTO dto) {
        var profileLogin = new ProfileLogin();
        profileLogin.setLogin(dto.getLogin());
        return profileLogin;
    }
}
