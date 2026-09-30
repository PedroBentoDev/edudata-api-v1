package com.edudata.edudata_api.service;

import com.edudata.edudata_api.dto.EstatisticaDTO;
import com.edudata.edudata_api.repository.EscolaRepository;

import org.springframework.stereotype.Service;

@Service
public class EstatisticaService {

    private final EscolaRepository escolaRepository;

    public EstatisticaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public EstatisticaDTO buscarPorUf(String uf) {

        return new EstatisticaDTO(
                uf.toUpperCase(),

                escolaRepository.countByUfIgnoreCase(uf),

                escolaRepository
                        .countByUfIgnoreCaseAndInternet(uf, 1),

                escolaRepository
                        .countByUfIgnoreCaseAndInternetAlunos(uf, 1),

                escolaRepository
                        .countByUfIgnoreCaseAndBiblioteca(uf, 1),

                escolaRepository
                        .countByUfIgnoreCaseAndLaboratorioInformatica(uf, 1),

                escolaRepository
                        .countByUfIgnoreCaseAndLaboratorioCiencias(uf, 1),

                escolaRepository
                        .countByUfIgnoreCaseAndQuadraEsportes(uf, 1),

                escolaRepository
                        .countByUfIgnoreCaseAndAguaPotavel(uf, 1),

                escolaRepository
                        .countByUfIgnoreCaseAndRampaAcessibilidade(uf, 1)
        );
    }

    public EstatisticaDTO buscarPorMunicipio(String municipio) {

        return new EstatisticaDTO(
                municipio,

                escolaRepository
                        .countByMunicipioIgnoreCase(municipio),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndInternet(municipio, 1),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndInternetAlunos(municipio, 1),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndBiblioteca(municipio, 1),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndLaboratorioInformatica(municipio, 1),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndLaboratorioCiencias(municipio, 1),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndQuadraEsportes(municipio, 1),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndAguaPotavel(municipio, 1),

                escolaRepository
                        .countByMunicipioIgnoreCaseAndRampaAcessibilidade(municipio, 1)
        );
    }
}