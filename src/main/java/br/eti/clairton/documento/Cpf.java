package br.eti.clairton.documento;

import java.util.regex.Pattern;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class Cpf extends Documento {

	private static final long serialVersionUID = 1L;

	private static final CPFValidator validator = new CPFValidator();

	public Cpf(final CharSequence numero) throws DocumentoInvalidoException {
		super(numero);
	}

	@Override
	protected Pattern format() {
		return Pattern.compile("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}");
	}

	@Override
	protected void validarDigito() throws DocumentoDigitoInvalidoException {
		try {
			validator.assertValid(numero.toString());
		} catch (InvalidStateException e) {
			throw new DocumentoDigitoInvalidoException();
		}
	}
}
