package com.edudata.edudata_api.dto;

public record EstatisticaDTO(
        String local,
        long totalEscolas,
        long comInternet,
        long comInternetAlunos,
        long comBiblioteca,
        long comLaboratorioInformatica,
        long comLaboratorioCiencias,
        long comQuadraEsportes,
        long comAguaPotavel,
        long comRampaAcessibilidade
) {
}