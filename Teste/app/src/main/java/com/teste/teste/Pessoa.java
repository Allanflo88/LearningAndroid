package com.teste.teste;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by allan on 28/01/18.
 */

public class Pessoa implements Comparable<Pessoa>{
    String nome, endereco, telefone;

    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(@NonNull Pessoa pessoa) {

        if(this.getNome().compareTo(pessoa.getNome()) > 0){
            return -1;
        }
        if(this.getNome().compareTo(pessoa.getNome()) < 0){
            return 1;
        }
        return 0;
    }
}
