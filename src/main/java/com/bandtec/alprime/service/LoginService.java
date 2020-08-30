package com.bandtec.alprime.service;

import com.bandtec.alprime.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    public String autenticarCadastro(Cliente cliente, List<Cliente> clientes) {
        String email = cliente.getEmail();
        String senha = cliente.getSenha();
        boolean emailValidado = false;
        boolean senhaValidada = false;
        Integer numeroMaiusculas = 0;
        Integer numeroMinusculas = 0;
        Integer numeroNumeros = 0;
        for (Cliente clienteCadastrado : clientes) {
            if (cliente.equals(clienteCadastrado)) {
                return "Usuário já esta cadastrado";
            }
        }
//        Validação do email
        if (email.indexOf("@") > 0 && (email.endsWith(".com") || email.endsWith(".com.br")) && (!email.startsWith("@"))) {
            emailValidado = true;
        }
//        validação da Senha
        char[] caracteres = senha.toCharArray();
        for (char caracter : caracteres) {
            if (Character.isLowerCase(caracter)) {
                numeroMinusculas++;
            } else if (Character.isUpperCase(caracter)) {
                numeroMaiusculas++;
            } else if (Character.isDigit(caracter)) {
                numeroNumeros++;
            }
        }
        if (senha.length() > 8 && numeroMaiusculas > 0 && numeroMinusculas > 0 && numeroNumeros > 0) {
            senhaValidada = true;
        }
        if (emailValidado) {
            if (senhaValidada) {
                return "Usuário cadastrado com sucesso";
            } else {
                return "A senha deve conter: \nMais de 8 caracteres\nLetras Maiusculas e Minusculas";
            }
        } else {
            return "Digite um email valido";
        }
    }

    public String verificarTodosClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            return "Não há nenhum cliente cadastrado";
        } else {
            return clientes.toString();
        }
    }

    public String autenticar(Cliente autenticacao, List<Cliente> clientes) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        String mensagem;
        for (Cliente cliente : clientes) {
            if (cliente.equals(autenticacao)) {
                clientesEncontrados.add(cliente);
            }
        }
        switch (clientesEncontrados.size()) {
            case 0:
                mensagem = "Usuário ou senha incorretos";
                break;
            case 1:
                mensagem = "Autenticado com Sucesso!";
                break;
            default:
                mensagem = "Mais de um cliente cadastrado";
                break;
        }
        return mensagem;
    }

    public String mensagemBoasVindas(Cliente cliente) {
        return String.format("Olá %s \n" +
                "%s", cliente.getNome(), cliente);
    }
}
