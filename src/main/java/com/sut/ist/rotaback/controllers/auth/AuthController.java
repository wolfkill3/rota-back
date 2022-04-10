package com.sut.ist.rotaback.controllers.auth;

import java.util.*;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.controllers.auth.dto.RulesLevel;
import com.sut.ist.rotaback.controllers.auth.request.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @PostMapping(value = "/login")
    public @ResponseBody
    LoginDTO getLogin(@RequestBody LoginRequest request) {
        if (StringUtils.isBlank(request.getLogin()) || StringUtils.isBlank(request.getPassword())) {
            throw new RuntimeException("Login or password is empty");
        }
        return new LoginDTO("Admin", UUID.randomUUID().toString(), RulesLevel.ADMIN.value);
    }
}
