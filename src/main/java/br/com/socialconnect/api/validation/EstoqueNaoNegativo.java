package br.com.socialconnect.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EstoqueNaoNegativoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EstoqueNaoNegativo {

    String message() default "{produto.estoque.minimo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
