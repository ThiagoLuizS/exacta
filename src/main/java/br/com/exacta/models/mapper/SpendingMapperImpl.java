package br.com.exacta.models.mapper;

import br.com.exacta.models.dto.SpendingForm;
import br.com.exacta.models.dto.SpendingView;
import br.com.exacta.models.entity.Person;
import br.com.exacta.models.entity.Spending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpendingMapperImpl implements MapStructMapper<Spending, SpendingView, SpendingForm> {

    @Override
    public SpendingView entityToView(Spending spending) {
        return SpendingView.builder()
                .id(spending.getId())
                .description(spending.getDescription())
                .date(spending.getDate())
                .value(spending.getValue())
                .tags(spending.getTags())
                .build();
    }

    @Override
    public Spending formToEntity(SpendingForm spendingForm) {
        return Spending.builder()
                .id(spendingForm.getId())
                .person(Person.builder().id(spendingForm.getPersonId()).build())
                .description(spendingForm.getDescription())
                .date(spendingForm.getDate())
                .value(spendingForm.getValue())
                .tags(spendingForm.getTags())
                .build();
    }
}
