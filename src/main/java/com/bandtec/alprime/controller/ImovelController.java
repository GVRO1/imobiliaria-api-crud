package com.bandtec.alprime.controller;

import com.bandtec.alprime.controller.LoginController;
import com.bandtec.alprime.imoveis.Apartamento;
import com.bandtec.alprime.imoveis.Casa;
import com.bandtec.alprime.imoveis.Imovel;
import com.bandtec.alprime.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    LoginController loginController;
    @Autowired
    ImovelService imovelService;

    @GetMapping("/imposto")
    public String calcularImpostoTotal() {
        return imovelService.calcularImpostoTotal(loginController.getClienteLogado());
    }

    @GetMapping("/aluguel")
    public String calcularAluguelTotal() {
        return imovelService.calcularAluguelTotal(loginController.getClienteLogado());
    }

    @PostMapping("/adquirirApartamento")
    public String aquirirApartamento(@RequestBody Apartamento apartamento) {
        return imovelService.aquirirImovel(loginController.getClienteLogado(), apartamento);
    }

    @PostMapping("/adquirirCasa")
    public String aquirirCasa(@RequestBody Casa casa) {
        return imovelService.aquirirImovel(loginController.getClienteLogado(), casa);
    }

    @GetMapping("/apartamentos")
    public List<Apartamento> verApartametos() {
        return imovelService.todoApartamentos(loginController.getClienteLogado());
    }

    @GetMapping("/casas")
    public List<Casa> verCasas() {
        return imovelService.todasCasas(loginController.getClienteLogado());
    }

    @GetMapping("/imovel/{id}")
    public Imovel verImovel(@PathVariable Integer id) {
        return imovelService.verImovel(loginController.getClienteLogado(), id);
    }
    @DeleteMapping("/imovel/{id}")
    public Imovel venderImovel(@PathVariable Integer id) {
        return imovelService.venderImovel(loginController.getClienteLogado(), id);
    }

    @GetMapping("/casas")
    public List<Imovel> verImoveis() {
        return imovelService.todosImoveis(loginController.getClienteLogado());
    }
}
