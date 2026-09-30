package com.edudata.edudata_api.dto;

public record InfraestruturaDTO(
        Long codigoInep,
        String nome,
        String municipio,
        String uf,
        Integer aguaPotavel,
        Integer energiaRedePublica,
        Integer esgotoRedePublica,
        Integer biblioteca,
        Integer laboratorioCiencias,
        Integer laboratorioInformatica,
        Integer quadraEsportes,
        Integer rampaAcessibilidade,
        Integer elevadorAcessibilidade,
        Integer salasUtilizadas,
        Integer salasClimatizadas,
        Integer salasAcessiveis,
        Integer internet,
        Integer internetAlunos
) {}