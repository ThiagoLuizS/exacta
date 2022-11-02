package br.com.exacta.config;

import br.com.exacta.models.mapper.PersonMapperImpl;
import br.com.exacta.models.mapper.SpendingMapperImpl;
import br.com.exacta.models.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TransformConfig {

    @Bean
    @Primary
    public PersonMapperImpl personMapper() {
        return new PersonMapperImpl();
    }

    @Bean
    public SpendingMapperImpl spendingMapper() {
        return new SpendingMapperImpl();
    }

    @Bean
    public UserMapperImpl userMapper() {
        return new UserMapperImpl();
    }
}
