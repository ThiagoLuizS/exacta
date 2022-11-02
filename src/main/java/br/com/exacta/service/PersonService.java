package br.com.exacta.service;

import br.com.exacta.exceptionhandler.NotFoundException;
import br.com.exacta.models.dto.PersonForm;
import br.com.exacta.models.dto.PersonView;
import br.com.exacta.models.entity.Person;
import br.com.exacta.models.mapper.MapStructMapper;
import br.com.exacta.models.mapper.PersonMapperImpl;
import br.com.exacta.repository.PersonRepository;
import br.com.exacta.utils.ConstantsMessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
public class PersonService extends AbstractService<Person, PersonView, PersonForm> {

    private final PersonRepository personRepository;

    private final PersonMapperImpl personMapper;

    public List<PersonView> findByNameStartsWithIgnoreCase(String personName) {
        if(StringUtils.isNotBlank(personName)) {
            List<Person> views = personRepository.findByNameStartsWithIgnoreCase(personName);
            if(CollectionUtils.isEmpty(views)) {
                throw new NotFoundException(ConstantsMessageUtils.NOT_FOUND);
            }
            return views.stream().map(personMapper::entityToView).collect(Collectors.toList());
        }

        return findAll();
    }

    @Override
    protected JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    protected MapStructMapper<Person, PersonView, PersonForm> getConverter() {
        return personMapper;
    }
}
