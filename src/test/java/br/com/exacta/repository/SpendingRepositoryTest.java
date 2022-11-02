package br.com.exacta.repository;

import br.com.exacta.models.dto.PersonForm;
import br.com.exacta.models.entity.Spending;
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
public class SpendingRepositoryTest {

    @Autowired
    private SpendingRepository repository;

    @Test
    public void findByPersonId() {
        List<Spending> list = repository.findByPersonId(1L);
        Assert.assertTrue(!list.isEmpty());
    }

    @Test
    public void notFindByPersonNameStartsWithIgnoreCase() {
        PersonForm personForm = PersonForm.builder().name("Um nome que não tem nada haver").build();
        List<Spending> list = repository.findByPersonNameStartsWithIgnoreCase(personForm.getName());
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void notFindByIdNonexistent() {
        Optional<Spending> spending = repository.findById(0L);
        Assert.assertTrue(!spending.isPresent());
    }

}
