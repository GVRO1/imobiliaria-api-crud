package com.bandtec.alprime.service;

import com.bandtec.alprime.Cliente;
import com.bandtec.alprime.imoveis.Apartamento;
import com.bandtec.alprime.imoveis.Casa;
import com.bandtec.alprime.imoveis.Imovel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImovelService {

    public String calcularImpostoTotal(Cliente cliente) {
        if (cliente == null) {
            return "Nenhuma sessão iniciada";
        } else {
            return cliente.calcularImpostoTotal();
        }
    }

    public String calcularAluguelTotal(Cliente cliente) {
        if (cliente == null) {
            return "Nenhuma sessão iniciada";
        } else {
            return cliente.calcularAluguelTotal();
        }
    }

    public String aquirirImovel(Cliente cliente, Imovel imovel) {
        if (cliente == null) {
            return "Nenhuma sessão iniciada";
        } else {
            return cliente.adquirirImovel(imovel);
        }
    }

    public List<Apartamento> todoApartamentos(Cliente cliente) {
        List<Apartamento> apartamentos = new ArrayList<>();
        if (cliente == null) {
            return new ArrayList<>();
        } else {
            for (Imovel imovel : cliente.getListaImoveis()) {
                if (imovel instanceof Apartamento) {
                    apartamentos.add((Apartamento) imovel);
                }
            }
            return apartamentos;
        }
    }

    public List<Casa> todasCasas(Cliente cliente) {
        List<Casa> casas = new ArrayList<>();
        if (cliente == null) {
            return new ArrayList<>();
        } else {
            for (Imovel imovel : cliente.getListaImoveis()) {
                if (imovel instanceof Casa) {
                    casas.add((Casa) imovel);
                }
            }
            return casas;
        }
    }

    public Imovel verImovel(Cliente cliente, Integer id) {
        if (cliente == null) {
            return null;
        } else {
            return cliente.getListaImoveis().get(id - 1);
        }
    }

    public Imovel venderImovel(Cliente cliente, Integer id) {
        if (cliente == null) {
            return null;
        } else {
            return cliente.getListaImoveis().remove(id - 1);
        }
    }

    public List<Imovel> todosImoveis(Cliente cliente) {
        if (cliente == null) {
            return new ArrayList<>();
        } else {
            return cliente.getListaImoveis();
        }
    }

}
