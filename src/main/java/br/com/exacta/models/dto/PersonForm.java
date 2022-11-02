package br.com.exacta.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;
}
