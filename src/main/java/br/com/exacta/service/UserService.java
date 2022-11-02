package br.com.exacta.service;

import br.com.exacta.exceptionhandler.NotFoundException;
import br.com.exacta.models.dto.UserForm;
import br.com.exacta.models.dto.UserView;
import br.com.exacta.models.entity.User;
import br.com.exacta.models.mapper.MapStructMapper;
import br.com.exacta.models.mapper.UserMapperImpl;
import br.com.exacta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class UserService extends AbstractService<User, UserView, UserForm> implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }
    @Override
    protected MapStructMapper<User, UserView, UserForm> getConverter() {
        return userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> entity = userRepository.findByEmail(email);
        if(!entity.isPresent()) {
            throw new NotFoundException("Nenhum usuário encontrado!");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(email, entity.get().getPassword(), getPermission(entity.get()));
        return userDetails;
    }

    private Collection<? extends GrantedAuthority> getPermission(User user) {
        return Arrays.asList(new SimpleGrantedAuthority("ALL"));
    }
}
