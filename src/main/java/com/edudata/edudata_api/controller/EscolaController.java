package com.edudata.edudata_api.controller;

import com.edudata.edudata_api.dto.InfraestruturaDTO;
import com.edudata.edudata_api.entity.Escola;
import com.edudata.edudata_api.exception.ParametroInvalidoException;
import com.edudata.edudata_api.service.EscolaService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escolas")
public class EscolaController {

    private final EscolaService escolaService;

    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    // =====================================================
    // LISTAR ESCOLAS
    //
    // Exemplos:
    //
    // GET /api/escolas
    // GET /api/escolas?page=0&size=20
    // GET /api/escolas?uf=RO
    // GET /api/escolas?municipio=Porto Velho
    // =====================================================

    @GetMapping
    public Page<Escola> buscarEscolas(
            @RequestParam(required = false) String uf,
            @RequestParam(required = false) String municipio,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        // =================================================
        // VALIDAÇÃO DA PÁGINA
        // =================================================

        if (page < 0) {
            throw new ParametroInvalidoException(
                    "O parâmetro 'page' não pode ser negativo."
            );
        }

        // =================================================
        // VALIDAÇÃO DO TAMANHO DA PÁGINA
        // =================================================

        if (size < 1 || size > 100) {
            throw new ParametroInvalidoException(
                    "O parâmetro 'size' deve estar entre 1 e 100."
            );
        }

        // =================================================
        // TRATAMENTO DA UF
        // =================================================

        if (uf != null) {

            uf = uf.trim();

            if (uf.isEmpty()) {
                uf = null;
            }
        }

        if (uf != null && uf.length() != 2) {
            throw new ParametroInvalidoException(
                    "A UF deve possuir exatamente 2 caracteres. Exemplo: RO."
            );
        }

        // =================================================
        // TRATAMENTO DO MUNICÍPIO
        // =================================================

        if (municipio != null) {

            municipio = municipio.trim();

            if (municipio.isEmpty()) {
                municipio = null;
            }
        }

        // =================================================
        // PAGINAÇÃO
        // =================================================

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("nome").ascending()
        );

        // =================================================
        // FILTRO POR MUNICÍPIO
        // =================================================

        if (municipio != null) {

            return escolaService.buscarPorMunicipio(
                    municipio,
                    pageable
            );
        }

        // =================================================
        // FILTRO POR UF
        // =================================================

        if (uf != null) {

            return escolaService.buscarPorUf(
                    uf.toUpperCase(),
                    pageable
            );
        }

        // =================================================
        // SEM FILTROS
        // =================================================

        return escolaService.buscarTodas(pageable);
    }


    // =====================================================
    // BUSCAR ESCOLA PELO CÓDIGO INEP
    //
    // GET /api/escolas/11024275
    // =====================================================

    @GetMapping("/{codigoInep}")
    public ResponseEntity<Escola> buscarPorCodigo(
            @PathVariable Long codigoInep) {

        if (codigoInep <= 0) {
            throw new ParametroInvalidoException(
                    "O código INEP deve ser um número positivo."
            );
        }

        Escola escola =
                escolaService.buscarPorCodigoOuFalhar(codigoInep);

        return ResponseEntity.ok(escola);
    }


    // =====================================================
    // CONSULTAR INFRAESTRUTURA DA ESCOLA
    //
    // GET /api/escolas/11024275/infraestrutura
    // =====================================================

    @GetMapping("/{codigoInep}/infraestrutura")
    public ResponseEntity<InfraestruturaDTO> buscarInfraestrutura(
            @PathVariable Long codigoInep) {

        if (codigoInep <= 0) {
            throw new ParametroInvalidoException(
                    "O código INEP deve ser um número positivo."
            );
        }

        Escola escola =
                escolaService.buscarPorCodigoOuFalhar(codigoInep);

        InfraestruturaDTO infraestrutura =
                new InfraestruturaDTO(
                        escola.getCodigoInep(),
                        escola.getNome(),
                        escola.getMunicipio(),
                        escola.getUf(),
                        escola.getAguaPotavel(),
                        escola.getEnergiaRedePublica(),
                        escola.getEsgotoRedePublica(),
                        escola.getBiblioteca(),
                        escola.getLaboratorioCiencias(),
                        escola.getLaboratorioInformatica(),
                        escola.getQuadraEsportes(),
                        escola.getRampaAcessibilidade(),
                        escola.getElevadorAcessibilidade(),
                        escola.getSalasUtilizadas(),
                        escola.getSalasClimatizadas(),
                        escola.getSalasAcessiveis(),
                        escola.getInternet(),
                        escola.getInternetAlunos()
                );

        return ResponseEntity.ok(infraestrutura);
    }
}