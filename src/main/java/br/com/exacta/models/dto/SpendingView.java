package br.com.exacta.models.dto;

import br.com.exacta.models.entity.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpendingView {

    private Long id;

    private String description;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date date;

    private BigDecimal value;

    private String tags;

    private List<String> separatorTags;

    public String getTags() {
        this.tags = CollectionUtils.isNotEmpty(this.separatorTags) ? this.separatorTags.stream().collect(Collectors.joining(";")) : this.tags;
        return tags;
    }

    public List<String> getSeparatorTags() {
        this.separatorTags = StringUtils.isNotBlank(this.tags) ? Arrays.stream(this.tags.split(";")).collect(Collectors.toList()) : Arrays.asList();
        return separatorTags;
    }

    public void setDate(Date date) {
        this.date = new Date();
    }
}
