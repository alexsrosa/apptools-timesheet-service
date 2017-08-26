package br.com.tools.timesheet.repository.manager;


import br.com.tools.timesheet.domain.manager.Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Consultores entity.
 */
@Repository
public interface ConsultorRepository extends JpaRepository<Consultor,Long> {

}
