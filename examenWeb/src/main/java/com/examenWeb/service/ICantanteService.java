package com.examenWeb.service;

import com.examenWeb.entity.Cantante;
import java.util.List;

/**
 *
 * @author Ariana
 */
public interface ICantanteService {

    public List<Cantante> getAllConcert();

    public Cantante getConcertById(long id);

    public void saveCantante(Cantante cantante);

    public void delete(long id);
}
