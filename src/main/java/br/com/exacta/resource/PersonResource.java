package br.com.exacta.resource;

import br.com.exacta.models.dto.PersonForm;
import br.com.exacta.models.dto.PersonView;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

public interface PersonResource {

    @GetMapping("/{id}")
    @ApiOperation(value = "Recurso responsavel por obter a pessoa pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    PersonView getById(@PathVariable("id") Long id);

    @GetMapping("/all/name")
    @ApiOperation(value = "Recurso responsavel por obter uma lista de pessoas pelo nome")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    List<PersonView> getByNameStartsWithIgnoreCase(@RequestParam(name = "personName", required = false) String personName);

    @GetMapping("/all")
    @ApiOperation(value = "Recurso responsavel por obter todas as")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    List<PersonView> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Recurso responsavel por salvar a pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    void save(@Valid @RequestBody PersonForm personForm);

    @PutMapping
    @ApiOperation(value = "Recurso responsavel por atualizar a pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    void update(@Valid @RequestBody PersonForm personForm);

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Recurso responsavel por excluir a pessoa pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Atributos do corpo da requisição podem está vazios"),
            @ApiResponse(code = 200, message = "Requisição feita com sucesso")
    })
    void delete(@PathVariable("id") Long id);

}
