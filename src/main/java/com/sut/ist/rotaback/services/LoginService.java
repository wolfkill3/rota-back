package com.sut.ist.rotaback.services;

import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.controllers.auth.request.LoginRequest;
import com.sut.ist.rotaback.mapper.LoginMapper;
import com.sut.ist.rotaback.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
        var profileLogin = repository.getByLoginAndPassword(request.login, request.password);
        if (profileLogin.isPresent()) {
            return mapper.toDto(profileLogin.get());
        } else {
            throw new RuntimeException("Wrong password or login");
        }
    }

    public boolean getLogOut(LoginRequest request) {
        return true;
    }
}
