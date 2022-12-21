package br.com.ecommerce.controller;

import br.com.ecommerce.domain.produto.DadosCadastroProduto;
import br.com.ecommerce.domain.produto.Produto;
import br.com.ecommerce.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Busca produto pelo id.")
    public Produto getProdutoById(@PathVariable("id") Long id){
        return produtoService.getProdutoById(id);
    }

    @GetMapping("/produto/")
    @ApiOperation(value = "Busca produto pelo nome.")
    public List<Produto> getProdutoByName(@RequestParam(value="name") String nomeProduto){
        return produtoService.getProdutoByName(nomeProduto);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Cria um produto.")
    public Produto createProduto(@RequestBody DadosCadastroProduto dados){
        return produtoService.createProduto(dados);
    }

    @PutMapping("/produto/{id}")
    @ApiOperation(value = "Atualiza um produto.")
    public Produto updateProduto(@PathVariable Long id,@RequestBody Produto produto){
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "Deleta um produto.")
    public ResponseEntity deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);

        return ResponseEntity.noContent().build();
    }
}
