package br.com.ecommerce.domain.produto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository repository;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
        FixtureFactoryLoader.loadTemplates("br.com.ecommerce.templates");
    }

    @Test
    public void deveCriarProdutoNoRepository(){
        Produto produto = new Produto(1L, "Escrivaninha",
                new BigDecimal("150.00"), 1,
                "Média");
        this.repository.save(produto);
        Assertions.assertThat(produto.getIdProduto()).isNotNull();
        Assertions.assertThat(produto.getNomeProduto()).isEqualTo("Escrivaninha");
        Assertions.assertThat(produto.getPrecoProduto()).isEqualTo(new BigDecimal("150.00"));
        Assertions.assertThat(produto.getQtdeProduto()).isEqualTo(1);
        Assertions.assertThat(produto.getDescricaoProduto()).isEqualTo("Média");
        Assert.assertNotNull(repository.save(produto));
    }

    @Test
    public void deveDeletarProdutoNoRepository(){
        Produto produto = Fixture.from(Produto.class).gimme("produto_model");
        this.repository.save(produto);
        repository.delete(produto);
        Assertions.assertThat(repository.findById(produto.getIdProduto())).isEmpty();
    }

    @Test
    public void deveAtualizarProdutoNoRepository(){
        Produto produto = Fixture.from(Produto.class).gimme("produto_model");
        this.repository.save(produto);
        produto = new Produto(1L, "Cadeira",
                new BigDecimal("20.00"), 2,
                "Confortaveis");
        this.repository.save(produto);

        Assertions.assertThat(produto.getIdProduto()).isEqualTo(1L);
        Assertions.assertThat(produto.getNomeProduto()).isEqualTo("Cadeira");
        Assertions.assertThat(produto.getPrecoProduto()).isEqualTo(new BigDecimal("20.00"));
        Assertions.assertThat(produto.getQtdeProduto()).isEqualTo(2);
        Assertions.assertThat(produto.getDescricaoProduto()).isEqualTo("Confortaveis");
    }
}
