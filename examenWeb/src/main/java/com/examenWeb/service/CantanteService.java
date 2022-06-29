
package com.examenWeb.service;

import com.examenWeb.entity.Cantante;
import com.examenWeb.repository.CantanteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ariana
 */

@Service
public class CantanteService implements ICantanteService{
    
    @Autowired
    private CantanteRepository CantanteRepository;

    @Override
    public List<Cantante> getAllConcert() {
         return (List<Cantante>) CantanteRepository.findAll();
    }

    @Override
    public Cantante getConcertById(long id) {
        return CantanteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCantante(Cantante cantante) {
        CantanteRepository.save(cantante);
    }

    @Override
    public void delete(long id) {
        CantanteRepository.deleteById(id);
    }
}
