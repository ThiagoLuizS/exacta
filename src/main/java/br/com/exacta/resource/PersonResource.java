package br.com.exacta.resource;

import br.com.exacta.models.dto.PersonForm;
import br.com.exacta.models.dto.PersonView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

public interface PersonResource {

    @GetMapping("/{id}")
    PersonView getById(@PathVariable("id") Long id);

    @GetMapping("/all/name")
    List<PersonView> getByNameStartsWithIgnoreCase(@RequestParam(name = "personName", required = false) String personName);

    @GetMapping("/all")
    List<PersonView> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@Valid @RequestBody PersonForm personForm);

    @PutMapping
    void update(@Valid @RequestBody PersonForm personForm);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);

}
