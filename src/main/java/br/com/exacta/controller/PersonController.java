package br.com.exacta.controller;

import br.com.exacta.models.dto.PersonForm;
import br.com.exacta.models.dto.PersonView;
import br.com.exacta.resource.PersonResource;
import br.com.exacta.service.PersonService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persons")
@Api(value = "Recursos para obter os dados da pessoa")
public class PersonController implements PersonResource {

    private final PersonService service;

    @Override
    public PersonView getById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<PersonView> getByNameStartsWithIgnoreCase(String personName) {
        return service.findByNameStartsWithIgnoreCase(personName);
    }

    @Override
    public List<PersonView> getAll() {
        return service.findAll();
    }

    @Override
    public void save(PersonForm personForm) {
        service.save(personForm);
    }

    @Override
    public void update(PersonForm personForm) {
        service.update(personForm);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
