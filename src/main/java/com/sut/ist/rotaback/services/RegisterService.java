package com.sut.ist.rotaback.services;

import com.sut.ist.rotaback.controllers.auth.dto.ProfileDTO;
import com.sut.ist.rotaback.controllers.register.request.RegisterRequest;
import com.sut.ist.rotaback.mapper.ProfileMapper;
import com.sut.ist.rotaback.repository.LoginRepository;
import com.sut.ist.rotaback.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterService {
    private final LoginRepository loginRepository;
    private final ProfileRepository profileRepository;
    private final ProfileMapper mapper;

    @Autowired
    public RegisterService(final LoginRepository loginRepository,
                           final ProfileRepository profileRepository,
                           final ProfileMapper mapper) {
        this.loginRepository = loginRepository;
        this.profileRepository = profileRepository;
        this.mapper = mapper;
    }

    public boolean createAccount(RegisterRequest request) {
        var profileLogin = loginRepository.getByLoginAndPassword(request.login, request.password);
        var profileDTO = ProfileDTO.buildFromRequest(request);
        var profile = mapper.toEntity(profileDTO);
        if (profileLogin.isPresent()) {
            profileRepository.save(profile);
            return true;
        } else {
            throw new RuntimeException("Wrong password or login");
        }
    }
}
