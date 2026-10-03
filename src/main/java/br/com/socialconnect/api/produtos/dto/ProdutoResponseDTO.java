package br.com.socialconnect.api.produtos.dto;

import br.com.socialconnect.api.produtos.model.CategoriaProduto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Dados de saída de um produto")
public record ProdutoResponseDTO(

        @Schema(description = "Identificador do produto", example = "1")
        Long idProduto,

        @Schema(description = "Nome do produto", example = "Arroz 5kg")
        String nome,

        @Schema(description = "Categoria do produto", example = "ALIMENTO")
        CategoriaProduto categoria,

        @Schema(description = "Quantidade atual em estoque", example = "3")
        Integer estoqueAtual,

        @Schema(description = "Estoque mínimo configurado", example = "10")
        Integer estoqueMinimo,

        @Schema(description = "Unidade de medida", example = "unidade")
        String unidadeMedida,

        @Schema(description = "Data de cadastro", example = "2026-09-18")
        LocalDate dataCadastro,

        @Schema(description = "Indica se o estoque atual está abaixo do mínimo", example = "true")
        boolean estoqueBaixo
) {}
