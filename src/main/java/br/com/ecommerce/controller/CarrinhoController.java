package br.com.ecommerce.controller;

import br.com.ecommerce.model.Carrinho;
import br.com.ecommerce.repository.CarrinhoRepository;
import br.com.ecommerce.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService service;

    @Autowired
    private CarrinhoRepository repository;

    @GetMapping
    public List<Carrinho> getAllCarrinho(){
        return repository.findAll();
    }

    @PostMapping
    public void addProduto(Long idCarrinho, Long idProduto){
       service.addProduto(idCarrinho, idProduto);
    }

    @DeleteMapping("/{id}")
    public void removeProduto(Long idCarrinho,@PathVariable Long idProduto){
        service.removeProduto(idCarrinho, idProduto);
    }

}
