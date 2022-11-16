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
        return service.getAllCarrinho();
    }

    @PostMapping
    public Long createCarrinho(Carrinho carrinho){
        return service.createCarrinho(carrinho);
    }

    @PostMapping("/{id}/{id_produto}")
    public void addProduto(@PathVariable("id") Long idCarrinho,@PathVariable("id_produto") Long idProduto){
       service.addProduto(idCarrinho, idProduto);
    }

    @DeleteMapping("/{id}/{id_produto}")
    public void removeProduto(@PathVariable("id") Long idCarrinho,@PathVariable("id_produto") Long idProduto){
        service.removeProduto(idCarrinho, idProduto);
    }

}
