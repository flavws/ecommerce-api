package br.com.ecommerce.domain.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private BigDecimal precoProduto;

    @Column(nullable = false)
    private Integer qtdeProduto;

    @Column
    private String descricaoProduto;

    public Produto(DadosCadastroProduto dados) {
        this.nomeProduto = dados.nomeProduto();
        this.precoProduto = dados.precoProduto();
        this.qtdeProduto = dados.qtdeProduto();
        this.descricaoProduto = dados.descricaoProduto();

    }
}
