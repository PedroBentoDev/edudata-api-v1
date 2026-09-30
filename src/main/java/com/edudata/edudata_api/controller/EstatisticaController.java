package com.edudata.edudata_api.controller;

import com.edudata.edudata_api.dto.EstatisticaDTO;
import com.edudata.edudata_api.service.EstatisticaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(
            EstatisticaService estatisticaService) {

        this.estatisticaService = estatisticaService;
    }

    @GetMapping("/uf/{uf}")
    public ResponseEntity<EstatisticaDTO> buscarPorUf(
            @PathVariable String uf) {

        EstatisticaDTO estatistica =
                estatisticaService.buscarPorUf(uf);

        if (estatistica.totalEscolas() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estatistica);
    }

    @GetMapping("/municipio/{municipio}")
    public ResponseEntity<EstatisticaDTO> buscarPorMunicipio(
            @PathVariable String municipio) {

        EstatisticaDTO estatistica =
                estatisticaService.buscarPorMunicipio(municipio);

        if (estatistica.totalEscolas() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estatistica);
    }
}