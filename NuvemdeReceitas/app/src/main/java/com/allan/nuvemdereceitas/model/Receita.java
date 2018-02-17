package com.allan.nuvemdereceitas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by allan on 01/02/18.
 */

public class Receita implements Serializable{

    String titulo;
    String descricao;
    Date data_add;
    String url;

    public Receita(String titulo, String descricao, Date data_add) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_add = data_add;
    }

    public Receita() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_add() {
        return data_add;
    }

    public void setData_add(Date data_add) {
        this.data_add = data_add;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return Objects.equals(titulo, receita.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
