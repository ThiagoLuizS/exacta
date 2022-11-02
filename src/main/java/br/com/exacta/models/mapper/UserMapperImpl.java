package br.com.exacta.models.mapper;

import br.com.exacta.models.dto.UserForm;
import br.com.exacta.models.dto.UserView;
import br.com.exacta.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements MapStructMapper<User, UserView, UserForm> {

    @Override
    public UserView entityToView(User user) {
        return UserView.builder()
                .id(user.getId())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }

    @Override
    public User formToEntity(UserForm userForm) {
        return null;
    }
}
