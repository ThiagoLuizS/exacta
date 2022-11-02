package br.com.exacta.resource;

import br.com.exacta.models.dto.SpendingForm;
import br.com.exacta.models.dto.SpendingView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

public interface SpendingResource {

    @GetMapping("/{id}")
    SpendingView getById(@PathVariable("id") Long id);

    @GetMapping("/all")
    List<SpendingView> getAll();

    @GetMapping("/all/{personId}")
    List<SpendingView> getByPersonId(@PathVariable("personId") Long personId);

    @GetMapping("/all/name/{personName}")
    List<SpendingView> getByPersonNameStartsWithIgnoreCase(@PathVariable("personName") String personName);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@Valid @RequestBody SpendingForm spendingForm);

    @PutMapping
    void update(@Valid @RequestBody SpendingForm spendingForm);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);
}
