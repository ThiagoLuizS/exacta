package br.com.exacta.service;

import br.com.exacta.exceptionhandler.NotFoundException;
import br.com.exacta.models.dto.SpendingForm;
import br.com.exacta.models.dto.SpendingView;
import br.com.exacta.models.entity.Spending;
import br.com.exacta.models.mapper.MapStructMapper;
import br.com.exacta.models.mapper.SpendingMapperImpl;
import br.com.exacta.repository.SpendingRepository;
import br.com.exacta.utils.ConstantsMessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class SpendingService extends AbstractService<Spending, SpendingView, SpendingForm> {

    private final SpendingRepository spendingRepository;
    private final SpendingMapperImpl spendingMapper;


    public List<SpendingView> findByPersonId(Long personId) {
        List<Spending> views = spendingRepository.findByPersonId(personId);
        if(CollectionUtils.isEmpty(views)) {
            throw new NotFoundException(ConstantsMessageUtils.NOT_FOUND);
        }
        return views.stream().map(spendingMapper::entityToView).collect(Collectors.toList());
    }

    public List<SpendingView> findByPersonNameStartsWithIgnoreCase(String personName) {
        List<Spending> views = spendingRepository.findByPersonNameStartsWithIgnoreCase(personName);
        if(CollectionUtils.isEmpty(views)) {
            throw new NotFoundException(ConstantsMessageUtils.NOT_FOUND);
        }
        return views.stream().map(spendingMapper::entityToView).collect(Collectors.toList());
    }

    @Override
    protected JpaRepository<Spending, Long> getRepository() {
        return spendingRepository;
    }

    @Override
    protected MapStructMapper<Spending, SpendingView, SpendingForm> getConverter() {
        return spendingMapper;
    }
}
