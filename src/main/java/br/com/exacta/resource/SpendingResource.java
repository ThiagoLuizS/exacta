package br.com.exacta.resource;

import br.com.exacta.models.dto.SpendingForm;
import br.com.exacta.models.dto.SpendingView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Recurso responsavel por obter o gasto por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    SpendingView getById(@PathVariable("id") Long id);

    @GetMapping("/all")
    @ApiOperation(value = "Recurso responsavel por obter uma lista de gastos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    List<SpendingView> getAll();

    @GetMapping("/all/{personId}")
    @ApiOperation(value = "Recurso responsavel por obter uma lista de gastos por ID da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    List<SpendingView> getByPersonId(@PathVariable("personId") Long personId);

    @GetMapping("/all/name/{personName}")
    @ApiOperation(value = "Recurso responsavel por obter uma lista de gastos pelo nome da pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    List<SpendingView> getByPersonNameStartsWithIgnoreCase(@PathVariable("personName") String personName);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Recurso responsavel por obter salvar o gasto")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    void save(@Valid @RequestBody SpendingForm spendingForm);

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Recurso responsavel por excluir o gasto por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    void delete(@PathVariable("id") Long id);
}
