package br.com.tools.timesheet.service.manager;

import br.com.tools.timesheet.domain.manager.Consultor;
import br.com.tools.timesheet.repository.manager.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ConsultorService {

    @Autowired
    private ConsultorRepository repository;

    /**
     *
     * @param consultor
     * @return
     */
    public Consultor save(Consultor consultor){
        return this.repository.save(consultor);
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Consultor> findById(Long id){
        return this.repository.findById(id);
    }
}
