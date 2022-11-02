package br.com.exacta.config;

import br.com.exacta.utils.ConstanteUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncode implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return ConstanteUtils.getSecurityHash(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return StringUtils.equals(encodedPassword, encode(rawPassword));
	}

}
