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
public class GerenciaCartao {
    
    //Atributos
    private int id;
    public String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        @Override
    public String toString(){
        return this.getNome();
    }
    
    
    
}
