package com.bandtec.alprime.imoveis;

import com.bandtec.alprime.Cliente;

public abstract class Imovel {
    private Integer id;
    private String endereco;
    private String cep;

    public Imovel(Integer id, String endereco, String cep) {
        this.id = id;
        this.endereco = endereco;
        this.cep = cep;
    }

    public abstract Double calcularImposto();

    @Override
    public String toString() {
        return "imovel{" +
                "id=" + id +
                ", endereco='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
