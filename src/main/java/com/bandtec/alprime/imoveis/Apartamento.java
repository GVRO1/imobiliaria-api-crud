package com.bandtec.alprime.imoveis;

import com.bandtec.alprime.Cliente;

public class Apartamento extends Imovel implements Aluguel {
    private String nomeBloco;
    private String nomeApartamento;
    private Double precoAluguel;
    private Double precoCondominio;

    public Apartamento(Integer id, String endereco, String cep, String nomeBloco, String nomeApartamento, Double precoAluguel, Double precoCondominio) {
        super(id, endereco, cep);
        this.nomeBloco = nomeBloco;
        this.nomeApartamento = nomeApartamento;
        this.precoAluguel = precoAluguel;
        this.precoCondominio = precoCondominio;
    }

    @Override
    public Double calcularPrecoAluguel() {
        return this.precoCondominio + this.precoAluguel;
    }

    @Override
    public Double calcularImposto() {
        return calcularPrecoAluguel() * 0.2;
    }

    public String getNomeBloco() {
        return nomeBloco;
    }

    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }

    public String getNomeApartamento() {
        return nomeApartamento;
    }

    public void setNomeApartamento(String nomeApartamento) {
        this.nomeApartamento = nomeApartamento;
    }

    public Double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(Double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public Double getPrecoCondominio() {
        return precoCondominio;
    }

    public void setPrecoCondominio(Double precoCondominio) {
        this.precoCondominio = precoCondominio;
    }
}
