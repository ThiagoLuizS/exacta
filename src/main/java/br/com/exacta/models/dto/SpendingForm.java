package br.com.exacta.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpendingForm {

    private Long id;
    @NotNull(message = "O gasto deve está relacionado a uma pessoa")
    private Long personId;
    @NotBlank(message = "O gasto deve ter uma descrição")
    private String description;
    private Date date = new Date();
    @NotNull(message = "O valor do gasto não pode ser nulo")
    private BigDecimal value;
    private String tags;
    private List<String> separatorTags = new ArrayList<>();

    public String getTags() {
        this.tags = CollectionUtils.isNotEmpty(this.separatorTags) ? this.separatorTags.stream().collect(Collectors.joining(";")) : this.tags;
        return tags;
    }
}
