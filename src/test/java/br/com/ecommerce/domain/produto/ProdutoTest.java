package br.com.ecommerce.domain.produto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ProdutoTest {

    @Before
    public void before(){
        FixtureFactoryLoader.loadTemplates("br.com.ecommerce.templates");
    }

    @Test
    public void deveTestar0ConstrutorProduto(){

        Produto construtorTeste = Fixture.from(Produto.class).gimme("produto_model");
        Produto construtorDespesa = new Produto(construtorTeste.getIdProduto(), construtorTeste.getNomeProduto(),
                construtorTeste.getPrecoProduto(), construtorTeste.getQtdeProduto(), construtorTeste.getDescricaoProduto());

        assertEquals(construtorDespesa.getIdProduto(), construtorTeste.getIdProduto());
        assertEquals(construtorDespesa.getNomeProduto(), construtorTeste.getNomeProduto());
        assertEquals(construtorDespesa.getPrecoProduto(), construtorTeste.getPrecoProduto());
        assertEquals(construtorDespesa.getQtdeProduto(), construtorTeste.getQtdeProduto());
        assertEquals(construtorDespesa.getDescricaoProduto(), construtorTeste.getDescricaoProduto());
    }

    @Test
    public void deveTestarNoArgsConstructorProduto(){

        Produto construtorProduto = new Produto();

        assertNotNull(construtorProduto);
    }

    @Test
    public void deveTestarGetSet(){
        Produto produtodespesaTemplate = Fixture.from(Produto.class).gimme("produto_model");
        Produto produto = new Produto();

        produto.setIdProduto(produtodespesaTemplate.getIdProduto());
        produto.setNomeProduto(produtodespesaTemplate.getNomeProduto());
        produto.setPrecoProduto(produtodespesaTemplate.getPrecoProduto());
        produto.setQtdeProduto(produtodespesaTemplate.getQtdeProduto());
        produto.setDescricaoProduto(produtodespesaTemplate.getDescricaoProduto());

        assertEquals(produto.getIdProduto(), produtodespesaTemplate.getIdProduto());
        assertEquals(produto.getNomeProduto(), produtodespesaTemplate.getNomeProduto());
        assertEquals(produto.getPrecoProduto(), produtodespesaTemplate.getPrecoProduto());
        assertEquals(produto.getQtdeProduto(), produtodespesaTemplate.getQtdeProduto());
        assertEquals(produto.getDescricaoProduto(), produtodespesaTemplate.getDescricaoProduto());
    }
}
