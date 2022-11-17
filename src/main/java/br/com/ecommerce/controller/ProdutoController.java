package br.com.ecommerce.controller;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
@Api(value = "Endpoints para controle dos produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produto")
    @ApiOperation(value = "Lista todos os produtos.")
    public List<Produto> getAllProdutos(){
        return produtoService.getAllProdutos();
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Cria um produto.")
    public Produto createProduto(@RequestBody Produto produto){
        return produtoService.createProduto(produto);
    }

    @PutMapping("/produto/{id}")
    @ApiOperation(value = "Atualiza um produto.")
    public Produto updateProduto(@PathVariable Long id,@RequestBody Produto produto){
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "Deleta um produto.")
    public void deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
    }
}
