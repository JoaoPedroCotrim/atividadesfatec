package br.com.socialconnect.api.produtos.service;

import br.com.socialconnect.api.exception.EstoqueInvalidoException;
import br.com.socialconnect.api.exception.NomeDuplicadoException;
import br.com.socialconnect.api.produtos.dto.ProdutoRequestDTO;
import br.com.socialconnect.api.produtos.dto.ProdutoResponseDTO;
import br.com.socialconnect.api.produtos.model.CategoriaProduto;
import br.com.socialconnect.api.produtos.model.Produto;
import br.com.socialconnect.api.produtos.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    private final ProdutoRepository repository = Mockito.mock(ProdutoRepository.class);
    private final ProdutoService service = new ProdutoService(repository);

    @Test
    void deveCriarProdutoQuandoDadosValidos() {
        // ARRANGE
        ProdutoRequestDTO dto = new ProdutoRequestDTO(
                "Arroz 5kg", CategoriaProduto.ALIMENTO, 3, 10, "unidade");

        Produto salvo = Produto.builder()
                .idProduto(1L)
                .nome(dto.nome())
                .categoria(dto.categoria())
                .estoqueAtual(dto.estoqueAtual())
                .estoqueMinimo(dto.estoqueMinimo())
                .unidadeMedida(dto.unidadeMedida())
                .dataCadastro(java.time.LocalDate.now())
                .build();

        Mockito.when(repository.existsByNomeIgnoreCase(dto.nome())).thenReturn(false);
        Mockito.when(repository.save(Mockito.any(Produto.class))).thenReturn(salvo);

        // ACT
        ProdutoResponseDTO resultado = service.criar(dto);

        // ASSERT
        assertEquals(1L, resultado.idProduto());
        assertTrue(resultado.estoqueBaixo());
        Mockito.verify(repository).save(Mockito.any(Produto.class));
    }

    @Test
    void deveLancarExcecaoQuandoEstoqueNegativo() {
        // ARRANGE
        ProdutoRequestDTO dto = new ProdutoRequestDTO(
                "Arroz 5kg", CategoriaProduto.ALIMENTO, -1, 10, "unidade");

        // ACT + ASSERT
        assertThrows(EstoqueInvalidoException.class, () -> service.criar(dto));
        Mockito.verify(repository, Mockito.never()).save(Mockito.any(Produto.class));
    }

    @Test
    void deveLancarExcecaoQuandoNomeDuplicado() {
        // ARRANGE
        ProdutoRequestDTO dto = new ProdutoRequestDTO(
                "Arroz 5kg", CategoriaProduto.ALIMENTO, 3, 10, "unidade");

        Mockito.when(repository.existsByNomeIgnoreCase(dto.nome())).thenReturn(true);

        // ACT + ASSERT
        assertThrows(NomeDuplicadoException.class, () -> service.criar(dto));
        Mockito.verify(repository, Mockito.never()).save(Mockito.any(Produto.class));
    }
}
