package br.com.exacta.repository;

import br.com.exacta.models.dto.LoginForm;
import br.com.exacta.models.entity.User;
import br.com.exacta.models.enumerators.UserStatusEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmailIsActive() {
        LoginForm loginForm = LoginForm.builder().email("exacta@gmail.com").build();
        Optional<User> user = userRepository.findByEmail(loginForm.getEmail());
        Assert.assertTrue(user.isPresent());
        Assert.assertNotNull(user.get());
        Assert.assertEquals(user.get().getStatus(), UserStatusEnum.ACTIVE);
    }
}
