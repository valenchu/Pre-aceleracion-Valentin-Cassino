package com.icons.geographic.start.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.geographic.start.dto.ContinenteDto;
import com.icons.geographic.start.entity.ContinenteEntity;
import com.icons.geographic.start.mapper.ContinenteMapper;
import com.icons.geographic.start.repository.ContinenteRepository;

@Service
public class ContienenteService {

    private final ContinenteRepository continenteRepository;
    private final ContinenteMapper mapCont;

    @Autowired
    public ContienenteService(ContinenteRepository continenteRepository, ContinenteMapper mapCont) {
	this.continenteRepository = continenteRepository;
	this.mapCont = mapCont;
    }

    // save img and name of continent
    public ContinenteEntity saveCont(ContinenteDto continenteDto, String img, String nomb) {

	continenteDto.setImg(img);
	continenteDto.setDenominacion(nomb);
	ContinenteEntity con = mapCont.dtoToCont(continenteDto);
	return continenteRepository.save(con);
    }

    // get all continent in the DB
    public List<ContinenteEntity> findAll() {
	return continenteRepository.findAll();
    }

    // update continent for id
    public ContinenteEntity updateContinent(Long id, ContinenteDto continenteDto) {
	Optional<ContinenteEntity> con = continenteRepository.findById(id);
	if (!con.isPresent()) {
	    return null;
	}

	return continenteRepository.save(mapCont.guar(con.get(), continenteDto));

    }
}