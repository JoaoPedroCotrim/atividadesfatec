package br.com.socialconnect.api.produtos.dto;

import br.com.socialconnect.api.produtos.model.CategoriaProduto;
import br.com.socialconnect.api.validation.EstoqueNaoNegativo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastro ou atualização de produto")
@EstoqueNaoNegativo
public record ProdutoRequestDTO(

        @Schema(description = "Nome do produto", example = "Arroz 5kg")
        @NotBlank(message = "{produto.nome.obrigatorio}")
        @Size(max = 150, message = "{produto.nome.tamanho}")
        String nome,

        @Schema(description = "Categoria do produto", example = "ALIMENTO")
        @NotNull(message = "{produto.categoria.obrigatoria}")
        CategoriaProduto categoria,

        @Schema(description = "Quantidade atual em estoque", example = "3", minimum = "0")
        @NotNull(message = "{produto.estoque.atual.obrigatorio}")
        @Min(value = 0, message = "{produto.estoque.minimo}")
        Integer estoqueAtual,

        @Schema(description = "Estoque mínimo para gerar alerta", example = "10", minimum = "0")
        @NotNull(message = "{produto.estoque.minimo.obrigatorio}")
        @Min(value = 0, message = "{produto.estoque.minimo}")
        Integer estoqueMinimo,

        @Schema(description = "Unidade de medida", example = "unidade")
        @NotBlank(message = "{produto.unidade.obrigatoria}")
        @Size(max = 20, message = "{produto.unidade.tamanho}")
        String unidadeMedida
) {}
