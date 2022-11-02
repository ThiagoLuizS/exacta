package br.com.exacta.models.dto;

import br.com.exacta.models.entity.Spending;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonView {
    private Long id;
    private String name;
    private List<SpendingView> spendings = new ArrayList<>();
}
