package br.com.ecommerce.service;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    public Produto createProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto produto){
        return produtoRepository.findById(id)
                .map(produtoSaved -> {
                    produtoSaved.setDescricaoProduto(produto.getDescricaoProduto());
                    produtoSaved.setNomeProduto(produto.getNomeProduto());
                    produtoSaved.setPrecoProduto(produto.getPrecoProduto());
                    produtoSaved.setQtdeProduto(produto.getQtdeProduto());

                    Produto updatedProduto = produtoRepository.save(produtoSaved);
                    return updatedProduto;
                }).orElse(null);
    }

    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
