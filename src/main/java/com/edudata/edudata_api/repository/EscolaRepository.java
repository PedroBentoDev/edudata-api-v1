package com.edudata.edudata_api.repository;

import com.edudata.edudata_api.entity.Escola;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

    // =========================
    // PAGINAÇÃO
    // =========================

    Page<Escola> findByUfIgnoreCase(
            String uf,
            Pageable pageable
    );

    Page<Escola> findByMunicipioIgnoreCase(
            String municipio,
            Pageable pageable
    );

    // =========================
    // ESTATÍSTICAS POR UF
    // =========================

    long countByUfIgnoreCase(String uf);

    long countByUfIgnoreCaseAndInternet(
            String uf,
            Integer internet
    );

    long countByUfIgnoreCaseAndInternetAlunos(
            String uf,
            Integer internetAlunos
    );

    long countByUfIgnoreCaseAndBiblioteca(
            String uf,
            Integer biblioteca
    );

    long countByUfIgnoreCaseAndLaboratorioInformatica(
            String uf,
            Integer laboratorioInformatica
    );

    long countByUfIgnoreCaseAndLaboratorioCiencias(
            String uf,
            Integer laboratorioCiencias
    );

    long countByUfIgnoreCaseAndQuadraEsportes(
            String uf,
            Integer quadraEsportes
    );

    long countByUfIgnoreCaseAndAguaPotavel(
            String uf,
            Integer aguaPotavel
    );

    long countByUfIgnoreCaseAndRampaAcessibilidade(
            String uf,
            Integer rampaAcessibilidade
    );

    // =========================
    // ESTATÍSTICAS POR MUNICÍPIO
    // =========================

    long countByMunicipioIgnoreCase(String municipio);

    long countByMunicipioIgnoreCaseAndInternet(
            String municipio,
            Integer internet
    );

    long countByMunicipioIgnoreCaseAndInternetAlunos(
            String municipio,
            Integer internetAlunos
    );

    long countByMunicipioIgnoreCaseAndBiblioteca(
            String municipio,
            Integer biblioteca
    );

    long countByMunicipioIgnoreCaseAndLaboratorioInformatica(
            String municipio,
            Integer laboratorioInformatica
    );

    long countByMunicipioIgnoreCaseAndLaboratorioCiencias(
            String municipio,
            Integer laboratorioCiencias
    );

    long countByMunicipioIgnoreCaseAndQuadraEsportes(
            String municipio,
            Integer quadraEsportes
    );

    long countByMunicipioIgnoreCaseAndAguaPotavel(
            String municipio,
            Integer aguaPotavel
    );

    long countByMunicipioIgnoreCaseAndRampaAcessibilidade(
            String municipio,
            Integer rampaAcessibilidade
    );
}