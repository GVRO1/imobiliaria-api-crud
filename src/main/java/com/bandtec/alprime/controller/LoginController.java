package com.bandtec.alprime.controller;

import com.bandtec.alprime.Cliente;
import com.bandtec.alprime.service.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autenticacao")
public class LoginController {
    private List<Cliente> cadastrados = new ArrayList<>();
    private Cliente clienteLogado;
    LoginService loginService = new LoginService();

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestBody Cliente cliente) {
        String autenticacao = loginService.autenticarCadastro(cliente, cadastrados);
        if (autenticacao.equals("Usuário cadastrado com sucesso")) {
            cadastrados.add(cliente);
        }
        return autenticacao;
    }

    @PostMapping("/autenticar")
    public String login(@RequestBody Cliente cliente) {
        if (clienteLogado != null) {
            return String.format("O Usuario %s já está logado.\n Não é você? Saia dessa sessão em http:localhost:8080/autenticacao/sair", clienteLogado.getNome());
        } else {
            String autenticacao = loginService.autenticar(cliente, cadastrados);
            if (autenticacao.equals("Autenticado com Sucesso!")) {
                clienteLogado = cliente;
            }
            return autenticacao;
        }
    }

    @GetMapping()
    public String verificarTodosUsuarios() {
        return loginService.verificarTodosClientes(cadastrados);
    }

    @GetMapping("/entrar")
    public String telaInicial() {
        if (clienteLogado != null) {
            return loginService.mensagemBoasVindas(clienteLogado);
        } else {
            return "Não existe nenhuma sessão iniciada";
        }
    }

    @GetMapping("/sair")
    public String logoff() {
        Cliente cliente = clienteLogado;
        if (clienteLogado != null) {
            clienteLogado = null;
            return String.format("Você saiu de sua sessão, Até mais %s", cliente.getNome());
        } else {
            return "Não existe nenhuma sessão iniciada";
        }
    }

    public List<Cliente> getCadastrados() {
        return cadastrados;
    }

    public void setCadastrados(List<Cliente> cadastrados) {
        this.cadastrados = cadastrados;
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
