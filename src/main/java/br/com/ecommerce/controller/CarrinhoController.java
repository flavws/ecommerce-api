package br.com.ecommerce.controller;

import br.com.ecommerce.model.Carrinho;
import br.com.ecommerce.repository.CarrinhoRepository;
import br.com.ecommerce.service.CarrinhoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
@Api(value = "Endpoints para controle do carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService service;

    @Autowired
    private CarrinhoRepository repository;

    @GetMapping("/carrinho")
    @ApiOperation(value = "Lista todos os itens do carrinho.")
    public List<Carrinho> getAllCarrinho(){
        return service.getAllCarrinho();
    }

    @PostMapping("/carrinho")
    @ApiOperation(value = "Inicializa um carrinho.")
    public Long createCarrinho(Carrinho carrinho){
        return service.createCarrinho(carrinho);
    }

    @PostMapping("/carrinho/{id}/{id_produto}")
    @ApiOperation(value = "Adiciona um produto ao carrinho.")
    public void addProduto(@PathVariable("id") Long idCarrinho,@PathVariable("id_produto") Long idProduto){
       service.addProduto(idCarrinho, idProduto);
    }

    @DeleteMapping("/carrinho/{id}/{id_produto}")
    @ApiOperation(value = "Remove um produto do carrinho.")
    public void removeProduto(@PathVariable("id") Long idCarrinho,@PathVariable("id_produto") Long idProduto){
        service.removeProduto(idCarrinho, idProduto);
    }

}
