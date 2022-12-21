package br.com.ecommerce.domain.carrinho;

import br.com.ecommerce.domain.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinho;
    @Column
    @OneToMany
    private List<Produto> produtos;

    @Column
    private BigDecimal precoTotal;

    public boolean addProduto(Produto produto){
        return this.produtos.add(produto);
    }

    public boolean removeProduto(Produto produto){
        return this.produtos.remove(produto);
    }
}
