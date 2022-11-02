package br.com.exacta.repository;

import br.com.exacta.models.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long> {

    List<Spending> findByPersonId(Long personId);
    List<Spending> findByPersonNameStartsWithIgnoreCase(String personName);

}
