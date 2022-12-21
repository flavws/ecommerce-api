package br.com.ecommerce.service;

import br.com.ecommerce.domain.carrinho.Carrinho;
import br.com.ecommerce.domain.produto.Produto;
import br.com.ecommerce.domain.carrinho.CarrinhoRepository;
import br.com.ecommerce.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Carrinho createCarrinho(Carrinho carrinho){
        Carrinho cart = repository.save(carrinho);
        return cart;
    }

    public List<Carrinho> getAllCarrinho(){
        return repository.findAll();
    }

    public void addProduto(Long idCarrinho, Long idProduto){
        Carrinho carrinho = repository.findById(idCarrinho).orElseThrow();
        Produto produto = produtoRepository.findById(idProduto).orElseThrow();

        carrinho.addProduto(produto);

        repository.save(carrinho);
    }

    public void removeProduto(Long idCarrinho, Long idProduto){
        Carrinho carrinho = repository.findById(idCarrinho).orElseThrow();
        Produto produto = produtoRepository.findById(idProduto).orElseThrow();

        carrinho.removeProduto(produto);
        repository.save(carrinho);

    }
}
