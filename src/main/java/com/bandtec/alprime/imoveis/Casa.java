package com.bandtec.alprime.imoveis;

import com.bandtec.alprime.Cliente;

public class Casa extends Imovel {
    private Double valorVenda;

    public Casa(Integer id, String endereco, String cep) {
        super(id, endereco, cep);
    }

    @Override
    public Double calcularImposto() {
        return valorVenda * 0.4;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
