package com.sut.ist.rotaback.controllers.register;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.sut.ist.rotaback.controllers.auth.dto.LoginDTO;
import com.sut.ist.rotaback.controllers.register.request.RegisterRequest;
import com.sut.ist.rotaback.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/register")
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(final RegisterService registerService) {this.registerService = registerService;}

    @PostMapping(value = "/new")
    public @ResponseBody
    boolean createNewAccount(@RequestBody RegisterRequest request) {
        if (StringUtils.isBlank(request.login) || StringUtils.isBlank(request.login)) {
            throw new RuntimeException("Login or password is empty");
        }
        return registerService.createAccount(request);
    }
}
