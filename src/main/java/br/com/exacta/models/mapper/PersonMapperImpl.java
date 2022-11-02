package br.com.exacta.models.mapper;

import br.com.exacta.models.dto.PersonForm;
import br.com.exacta.models.dto.PersonView;
import br.com.exacta.models.entity.Person;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class PersonMapperImpl implements MapStructMapper<Person, PersonView, PersonForm> {

    @Autowired
    private SpendingMapperImpl spendingMapper;

    @Override
    public PersonView entityToView(Person person) {
        return PersonView.builder()
                .id(person.getId())
                .name(person.getName())
                .spendings(CollectionUtils.isNotEmpty(person.getSpendings()) ?
                        person.getSpendings().stream().map(spendingMapper::entityToView).collect(Collectors.toList())
                        : Arrays.asList())
                .build();
    }

    @Override
    public Person formToEntity(PersonForm personForm) {
        return Person.builder()
                .id(personForm.getId())
                .name(personForm.getName())
                .build();
    }
}
