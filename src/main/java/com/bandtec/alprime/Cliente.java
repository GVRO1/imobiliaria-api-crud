package com.bandtec.alprime;

import com.bandtec.alprime.imoveis.Aluguel;
import com.bandtec.alprime.imoveis.Imovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private Integer idCliente;
    private String nome;
    private String email;
    private String senha;
    private List<Imovel> listaImoveis;

    public Cliente(Integer idCliente, String nome, String email, String senha, String tipo) {
        this.listaImoveis = new ArrayList<>();
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String adquirirImovel(Imovel imovel) {
        listaImoveis.add(imovel);
        return "Imovel adicionado com sucesso";
    }

    public String calcularImpostoTotal() {
        Double total = 0.0;
        for (Imovel imovel : listaImoveis) {
            total += imovel.calcularImposto();
        }
        return "Você deve pagar ao governo " + total + " reais";
    }

    public String calcularAluguelTotal() {
        Double total = 0.0;
        for (Imovel imovel : listaImoveis) {
            if (imovel instanceof Aluguel) {
                total += ((Aluguel) imovel).calcularPrecoAluguel();
            }
        }
        return "Você deve todo mês de aluguel " + total + " reais";
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", Lista de imoveis='" + listaImoveis + '\'' +
                '}';
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public void setListaImoveis(List<Imovel> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente) &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(email, cliente.email) &&
                Objects.equals(senha, cliente.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, email, senha);
    }
}
