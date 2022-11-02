package br.com.exacta.service;

import br.com.exacta.exceptionhandler.NotFoundException;
import br.com.exacta.models.dto.LoginForm;
import br.com.exacta.models.dto.TokenDTO;
import br.com.exacta.models.entity.User;
import br.com.exacta.models.enumerators.UserStatusEnum;
import br.com.exacta.repository.UserRepository;
import br.com.exacta.utils.ConstanteUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class AuthenticationService {

	@Autowired private AuthenticationManager authenticationManager;	
	@Autowired private UserRepository userRepository;
	@Autowired private JwtManager jwtManager;

	public TokenDTO authenticationManagerSignJwt(LoginForm form) {
		Optional<User> entity =  userRepository.findByEmail(form.getEmail());
		if (!entity.isPresent()) {
			throw new NotFoundException("Usuário não existe");
		}
		if(!UserStatusEnum.ACTIVE.equals(entity.get().getStatus())){
			throw new NotFoundException("Usuário não está ativo");
		}
		Authentication auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(auth);
		
		org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
		String email = userDetails.getUsername();
		List<String> roles = userDetails.getAuthorities()
			      .stream()
			      .map(authority -> authority.getAuthority())
			      .collect(Collectors.toList());
		return TokenDTO.builder()
				.token(jwtManager.createToken(email, roles))
				.type("JWT")
				.build();
	}
}
