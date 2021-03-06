package com.sut.ist.rotaback.controllers.auth;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.controllers.auth.request.LoginRequest;
import com.sut.ist.rotaback.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final LoginService loginService;

    @Autowired
    public AuthController(final LoginService loginService) {this.loginService = loginService;}

    @PostMapping(value = "/login")
    public @ResponseBody
    LoginDTO getLogin(@RequestBody LoginRequest request) {
        if (StringUtils.isBlank(request.login) || StringUtils.isBlank(request.login)) {
            throw new RuntimeException("Login or password is empty");
        }
        return loginService.getLogin(request);
    }

    @PostMapping(value = "/logout")
    public @ResponseBody
    boolean getLogout(@RequestBody LoginRequest request) {
        return true;
    }
}
