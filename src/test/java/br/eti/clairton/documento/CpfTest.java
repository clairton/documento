package br.eti.clairton.documento;

import org.junit.Test;

public class CpfTest {

	@Test(expected = DocumentoFormatoInvalidoException.class)
	public void testInvalidFormat() throws DocumentoInvalidoException {
		new Cpf("000.000.000-0");
	}

	@Test(expected = DocumentoDigitoInvalidoException.class)
	public void testValidFormat() throws DocumentoInvalidoException {
		new Cpf("000.000.000-00");
	}

	@Test
	public void testValid() throws DocumentoInvalidoException {
		new Cpf("903.888.077-41");
	}
}
