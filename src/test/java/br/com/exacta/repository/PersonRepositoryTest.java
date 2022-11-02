package br.com.exacta.repository;

import br.com.exacta.models.dto.PersonForm;
import br.com.exacta.models.entity.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void findByNameStartsWithIgnoreCase() {
        PersonForm personForm = PersonForm.builder().name("Fulano de tal 1").build();
        List<Person> persons = repository.findByNameStartsWithIgnoreCase(personForm.getName());
        Assert.assertNotNull(persons);

        Person person = persons.stream().findFirst().get();
        Assert.assertEquals(person.getName(), personForm.getName());
    }

    @Test
    public void notFindByIdNonexistent() {
        Optional<Person> person = repository.findById(0L);
        Assert.assertTrue(!person.isPresent());
    }
}
