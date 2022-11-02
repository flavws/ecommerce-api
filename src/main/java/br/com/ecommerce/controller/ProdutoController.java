package br.com.ecommerce.controller;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos(){
        return produtoService.getAllProdutos();
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto){
        return produtoService.createProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id,@RequestBody Produto produto){
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
    }
}
