package br.eti.clairton.documento;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Documento implements Serializable, Comparable<Documento>, CharSequence {

	private static final long serialVersionUID = 1L;

	protected final CharSequence numero;

	public Documento(final CharSequence numero) throws DocumentoInvalidoException {
		super();
		this.numero = numero;
		validar();
	}

	public int length() {
		return numero.length();
	}

	public char charAt(final int index) {
		return numero.charAt(index);
	}

	public CharSequence subSequence(final int start, final int end) {
		return numero.subSequence(start, end);
	}

	public int compareTo(final Documento o) {
		return numero.toString().compareTo(o.numero.toString());
	}

	@Override
	public String toString() {
		return numero.toString();
	}

	@Override
	public int hashCode() {
		return numero.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return numero.equals(obj);
	}

	protected void validar() throws DocumentoInvalidoException {
		validarFormato();
		validarDigito();
	}

	protected void validarFormato() throws DocumentoFormatoInvalidoException {
		final Pattern pattern = format();
		final Matcher matcher = pattern.matcher(numero);
		if (!matcher.find()) {
			throw new DocumentoFormatoInvalidoException();
		}
	}

	abstract protected void validarDigito() throws DocumentoDigitoInvalidoException;

	abstract protected Pattern format();
}
