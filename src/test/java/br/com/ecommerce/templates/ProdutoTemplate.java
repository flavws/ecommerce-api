package br.com.ecommerce.templates;

import br.com.ecommerce.domain.produto.Produto;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;

public class ProdutoTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Produto.class).addTemplate("produto_model", new Rule(){{
            add("idProduto", random(Long.class, range(1L, 500L)));
            add("nomeProduto", random("Fone", "Teclado", "Monitor"));
            add("precoProduto", new BigDecimal("150"));
            add("qtdeProduto", random(Integer.class, range(1, 500)));
            add("descricaoProduto", random("Grande", "Pequeno", "Medio"));
        }});
    }
}
