package com.sut.ist.rotaback.services.login;

import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.controllers.auth.request.LoginRequest;
import com.sut.ist.rotaback.mapper.LoginMapper;
import com.sut.ist.rotaback.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    private final LoginRepository repository;
    private final LoginMapper mapper;

    @Autowired
    public LoginService(final LoginRepository repository,
                        final LoginMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public LoginDTO getLogin(LoginRequest request) {
        var profileLogin = repository.getByLoginAndPassword(request.getLogin(), request.getPassword());
        if (profileLogin.isPresent()) {
            return mapper.toDto(profileLogin.get());
        } else {
            throw new RuntimeException("Wrong password or login");
        }
    }
}
