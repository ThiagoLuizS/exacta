package br.com.exacta.controller;

import br.com.exacta.models.dto.LoginForm;
import br.com.exacta.models.dto.TokenDTO;
import br.com.exacta.resource.AuthenticationResource;
import br.com.exacta.service.AuthenticationService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Api(value = "Autenticação para obter o token e ter acesso total aos recursos")
public class AuthenticationController implements AuthenticationResource {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public TokenDTO authentication(LoginForm loginForm) {
        return authenticationService.authenticationManagerSignJwt(loginForm);
    }
}
