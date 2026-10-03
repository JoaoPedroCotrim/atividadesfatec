package br.com.socialconnect.api.produtos.service;

import br.com.socialconnect.api.exception.EstoqueInvalidoException;
import br.com.socialconnect.api.exception.NomeDuplicadoException;
import br.com.socialconnect.api.exception.RecursoNaoEncontradoException;
import br.com.socialconnect.api.produtos.dto.ProdutoRequestDTO;
import br.com.socialconnect.api.produtos.dto.ProdutoResponseDTO;
import br.com.socialconnect.api.produtos.model.CategoriaProduto;
import br.com.socialconnect.api.produtos.model.Produto;
import br.com.socialconnect.api.produtos.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Page<ProdutoResponseDTO> listar(
            String nome, CategoriaProduto categoria, Pageable pageable) {

        Page<Produto> page;

        boolean temNome = nome != null && !nome.isBlank();
        boolean temCategoria = categoria != null;

        if (temNome && temCategoria) {
            page = repository.findByNomeContainingIgnoreCaseAndCategoria(
                    nome, categoria, pageable);
        } else if (temNome) {
            page = repository.findByNomeContainingIgnoreCase(nome, pageable);
        } else if (temCategoria) {
            page = repository.findByCategoria(categoria, pageable);
        } else {
            page = repository.findAll(pageable);
        }

        return page.map(this::toResponseDTO);
    }

    public ProdutoResponseDTO buscarPorId(Long idProduto) {
        return repository.findById(idProduto)
                .map(this::toResponseDTO)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Produto não encontrado com o ID: " + idProduto));
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        validarEstoque(dto);
        validarNomeUnico(dto.nome().trim());

        Produto entity = Produto.builder()
                .nome(dto.nome().trim())
                .categoria(dto.categoria())
                .estoqueAtual(dto.estoqueAtual())
                .estoqueMinimo(dto.estoqueMinimo())
                .unidadeMedida(dto.unidadeMedida().trim())
                .dataCadastro(LocalDate.now())
                .build();

        return toResponseDTO(repository.save(entity));
    }

    public ProdutoResponseDTO atualizar(Long idProduto, ProdutoRequestDTO dto) {
        validarEstoque(dto);

        Produto entity = repository.findById(idProduto)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Produto não encontrado com o ID: " + idProduto));

        if (repository.existsByNomeIgnoreCaseAndIdProdutoNot(dto.nome().trim(), idProduto)) {
            throw new NomeDuplicadoException(
                    "O produto '" + dto.nome() + "' já está cadastrado no sistema.");
        }

        entity.setNome(dto.nome().trim());
        entity.setCategoria(dto.categoria());
        entity.setEstoqueAtual(dto.estoqueAtual());
        entity.setEstoqueMinimo(dto.estoqueMinimo());
        entity.setUnidadeMedida(dto.unidadeMedida().trim());

        return toResponseDTO(repository.save(entity));
    }

    public void deletar(Long idProduto) {
        if (!repository.existsById(idProduto)) {
            throw new RecursoNaoEncontradoException(
                    "Produto não encontrado com o ID: " + idProduto);
        }

        repository.deleteById(idProduto);
    }

    private void validarEstoque(ProdutoRequestDTO dto) {
        if (dto.estoqueAtual() != null && dto.estoqueAtual() < 0) {
            throw new EstoqueInvalidoException(
                    "O estoque atual não pode ser negativo.");
        }

        if (dto.estoqueMinimo() != null && dto.estoqueMinimo() < 0) {
            throw new EstoqueInvalidoException(
                    "O estoque mínimo não pode ser negativo.");
        }
    }

    private void validarNomeUnico(String nome) {
        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new NomeDuplicadoException(
                    "O produto '" + nome + "' já está cadastrado no sistema.");
        }
    }

    private ProdutoResponseDTO toResponseDTO(Produto entity) {
        return new ProdutoResponseDTO(
                entity.getIdProduto(),
                entity.getNome(),
                entity.getCategoria(),
                entity.getEstoqueAtual(),
                entity.getEstoqueMinimo(),
                entity.getUnidadeMedida(),
                entity.getDataCadastro(),
                entity.getEstoqueAtual() < entity.getEstoqueMinimo()
        );
    }
}
