package br.com.tools.timesheet.service.manager;


import br.com.tools.timesheet.domain.manager.Parametro;
import br.com.tools.timesheet.repository.manager.ParametroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParametroService {

    private final Logger log = LoggerFactory.getLogger(ParametroService.class);

    @Autowired
    private ParametroRepository repository;


    /**
     * Save a timeSheet.
     *
     * @param parametro the entity to save
     * @return the persisted entity
     */
    public Parametro save(Parametro parametro) {
        log.debug("Request to save Parametro : {}", parametro);
        Parametro result = this.repository.save(parametro);

        return result;
    }

    public Parametro findByNome(String nome){
        log.debug("Request to findByName Parametro : {}", nome);
        Parametro result = this.repository.findByNome(nome);

        return result;
    }

    public Iterable<Parametro> findAll() {
        log.debug("Request to findAll");

        return  this.repository.findAll();
    }
}
