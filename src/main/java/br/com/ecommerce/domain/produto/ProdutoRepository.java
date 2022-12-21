package br.com.ecommerce.domain.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //List - vai retornar uma lista de produtos
    //quando essa interface for compilada, esse método vai percorrer pela entidade produto e procurar uma variavel
    //chamada nomeProduto, caso exista o método funciona ele valida o tipo da variavel e segue para a realização do método

    List<Produto> findByNomeProdutoLike(String nomeProduto);
}
