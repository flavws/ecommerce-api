package br.com.ecommerce.service;

import br.com.ecommerce.model.Carrinho;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.repository.CarrinhoRepository;
import br.com.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Long createCarrinho(Carrinho carrinho){
        Carrinho cart = repository.save(carrinho);
        return cart.getIdCarrinho();
    }

    public List<Carrinho> getAllCarrinho(){
        return repository.findAll();
    }

    public void addProduto(Long idCarrinho, Long idProduto){
        Carrinho carrinho = repository.findById(idCarrinho).orElseThrow();
        Produto produto = produtoRepository.findById(idProduto).orElseThrow();

        carrinho.getProdutos().add(produto);

        repository.save(carrinho);
    }

    public void removeProduto(Long idCarrinho, Long idProduto){
        Carrinho carrinho = repository.findById(idCarrinho).orElseThrow();
        Produto produto = produtoRepository.findById(idProduto).orElseThrow();

        carrinho.getProdutos().remove(produto);
        repository.save(carrinho);

    }
}
