package com.edudata.edudata_api.service;
import com.edudata.edudata_api.exception.RecursoNaoEncontradoException;
import com.edudata.edudata_api.entity.Escola;
import com.edudata.edudata_api.repository.EscolaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EscolaService {

    private final EscolaRepository escolaRepository;

    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public Page<Escola> buscarTodas(Pageable pageable) {
        return escolaRepository.findAll(pageable);
    }

    public Optional<Escola> buscarPorCodigo(Long codigoInep) {
        return escolaRepository.findById(codigoInep);
    }

    public Page<Escola> buscarPorUf(String uf, Pageable pageable) {
        return escolaRepository.findByUfIgnoreCase(uf, pageable);
    }

    public Page<Escola> buscarPorMunicipio(
            String municipio,
            Pageable pageable) {

        return escolaRepository.findByMunicipioIgnoreCase(
                municipio,
                pageable
        );
    }

    public Escola buscarPorCodigoOuFalhar(Long codigoInep) {
    return escolaRepository.findById(codigoInep)
            .orElseThrow(() ->
                    new RecursoNaoEncontradoException(
                            "Escola não encontrada para o código INEP " + codigoInep
                    )
            );
}
}