package br.com.exacta.service;

import br.com.exacta.utils.ConstanteUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class JwtManager {
	
	public String createToken(String email, List<String> roles) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, ConstanteUtils.JWT_EXP_DAYS);
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(calendar.getTime())
				.claim(ConstanteUtils.JWT_ROLE_KEY, roles)
				.signWith(SignatureAlgorithm.HS512, ConstanteUtils.API_KEYS.getBytes())
				.compact();
	}
	
	public Claims parseToken(String jwt) {
		return Jwts.parser()
				.setSigningKey(ConstanteUtils.API_KEYS.getBytes())
				.parseClaimsJws(jwt)
				.getBody();
	}
}
