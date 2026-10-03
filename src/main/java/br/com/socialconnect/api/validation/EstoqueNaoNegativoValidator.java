package br.com.socialconnect.api.validation;

import br.com.socialconnect.api.produtos.dto.ProdutoRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EstoqueNaoNegativoValidator
        implements ConstraintValidator<EstoqueNaoNegativo, ProdutoRequestDTO> {

    @Override
    public boolean isValid(ProdutoRequestDTO dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true;
        }

        boolean valido = dto.estoqueAtual() == null || dto.estoqueAtual() >= 0;
        valido &= dto.estoqueMinimo() == null || dto.estoqueMinimo() >= 0;
        return valido;
    }
}
