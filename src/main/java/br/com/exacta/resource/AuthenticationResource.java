package br.com.exacta.resource;

import br.com.exacta.models.dto.LoginForm;
import br.com.exacta.models.dto.TokenDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthenticationResource {

    @PostMapping
    TokenDTO authentication(@Valid @RequestBody LoginForm loginForm) throws Exception;

}
