/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pertinax.model;

/**
 *
 * @author mrs_a
 */
public class CartonLaminado {
    
    //Atributos
    private int id;
    private String faca;
    private String nome;
    private int grm_cartao;
    private int grm_laminado;
    private int grm_total;
    private String uv;
    private float pertinax;
    private float fresa1;
    private float fresa2;
    private String observacao;
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaca() {
        return faca;
    }

    public void setFaca(String faca) {
        this.faca = faca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGrm_cartao() {
        return grm_cartao;
    }

    public void setGrm_cartao(int grm_cartao) {
        this.grm_cartao = grm_cartao;
    }

    public int getGrm_laminado() {
        return grm_laminado;
    }

    public void setGrm_laminado(int grm_laminado) {
        this.grm_laminado = grm_laminado;
    }

    public int getGrm_total() {
        return grm_total;
    }

    public void setGrm_total(int grm_total) {
        this.grm_total = grm_total;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public float getPertinax() {
        return pertinax;
    }

    public void setPertinax(float pertinax) {
        this.pertinax = pertinax;
    }

    public float getFresa1() {
        return fresa1;
    }

    public void setFresa1(float fresa1) {
        this.fresa1 = fresa1;
    }

    public float getFresa2() {
        return fresa2;
    }

    public void setFresa2(float fresa2) {
        this.fresa2 = fresa2;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
