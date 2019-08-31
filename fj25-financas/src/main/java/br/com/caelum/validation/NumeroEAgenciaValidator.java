package br.com.caelum.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.modelo.Conta;

public class NumeroEAgenciaValidator implements ConstraintValidator<NumeroEAgencia, Conta> {

	@Override
	public boolean isValid(Conta conta, ConstraintValidatorContext context) {
		
		boolean agenciaPreenchida = 
				conta.getAgencia() != null && !conta.getAgencia().isBlank();
		
		boolean numeroPreenchido = 
				conta.getNumero() != null && !conta.getNumero().isBlank();
		
		
		return !(agenciaPreenchida ^ numeroPreenchido);
	}
}
