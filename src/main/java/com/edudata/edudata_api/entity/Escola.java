package com.edudata.edudata_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "escola", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class Escola {

    @Id
    @Column(name = "codigo_inep")
    private Long codigoInep;

    @Column(name = "ano_censo")
    private Integer anoCenso;

    @Column(name = "nome")
    private String nome;

    @Column(name = "uf")
    private String uf;

    @Column(name = "codigo_uf")
    private Integer codigoUf;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "codigo_municipio")
    private Integer codigoMunicipio;

    @Column(name = "dependencia")
    private Integer dependencia;

    @Column(name = "localizacao")
    private Integer localizacao;

    @Column(name = "situacao_funcionamento")
    private Integer situacaoFuncionamento;

    @Column(name = "agua_potavel")
    private Integer aguaPotavel;

    @Column(name = "energia_rede_publica")
    private Integer energiaRedePublica;

    @Column(name = "esgoto_rede_publica")
    private Integer esgotoRedePublica;

    @Column(name = "biblioteca")
    private Integer biblioteca;

    @Column(name = "laboratorio_ciencias")
    private Integer laboratorioCiencias;

    @Column(name = "laboratorio_informatica")
    private Integer laboratorioInformatica;

    @Column(name = "quadra_esportes")
    private Integer quadraEsportes;

    @Column(name = "rampa_acessibilidade")
    private Integer rampaAcessibilidade;

    @Column(name = "elevador_acessibilidade")
    private Integer elevadorAcessibilidade;

    @Column(name = "salas_utilizadas")
    private Integer salasUtilizadas;

    @Column(name = "salas_climatizadas")
    private Integer salasClimatizadas;

    @Column(name = "salas_acessiveis")
    private Integer salasAcessiveis;

    @Column(name = "internet")
    private Integer internet;

    @Column(name = "internet_alunos")
    private Integer internetAlunos;
}