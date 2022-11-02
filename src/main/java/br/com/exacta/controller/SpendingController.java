package br.com.exacta.controller;

import br.com.exacta.models.dto.SpendingForm;
import br.com.exacta.models.dto.SpendingView;
import br.com.exacta.resource.SpendingResource;
import br.com.exacta.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/spendings")
public class SpendingController implements SpendingResource {

    private final SpendingService service;

    @Override
    public SpendingView getById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<SpendingView> getAll() {
        return service.findAll();
    }

    @Override
    public List<SpendingView> getByPersonId(Long personId) {
        return service.findByPersonId(personId);
    }

    @Override
    public List<SpendingView> getByPersonNameStartsWithIgnoreCase(String personName) {
        return service.findByPersonNameStartsWithIgnoreCase(personName);
    }

    @Override
    public void save(SpendingForm spendingForm) {
        service.save(spendingForm);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
