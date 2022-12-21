package br.com.ecommerce.service;

import br.com.ecommerce.domain.produto.DadosCadastroProduto;
import br.com.ecommerce.domain.produto.Produto;
import br.com.ecommerce.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id){
        return produtoRepository.findById(id).get();
    }

    public List<Produto> getProdutoByName(String nomeProduto){
        return produtoRepository.findByNomeProdutoLike(nomeProduto);
    }

    public Produto createProduto(DadosCadastroProduto dados){
        return produtoRepository.save(new Produto(dados));
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
