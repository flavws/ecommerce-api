package br.com.ecommerce.domain.produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record DadosCadastroProduto(

        @NotBlank
        String nomeProduto,

        @NotNull
        BigDecimal precoProduto,

        @NotNull
        Integer qtdeProduto,

        @NotBlank
        String descricaoProduto

) {
}
