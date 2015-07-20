package br.com.netshoes.question1.exception.cep;

/**
 * @author salomao.marcos@gmail.com
 *
 */
public class CEPInvalidoException extends Exception {

	/**
	 * Serial;
	 */
	private static final long serialVersionUID = -3205289088605739909L;

	/**
	 * Construtor.
	 * 
	 * @param message Mensagem de erro.
	 */
	public CEPInvalidoException(String message) {
		super(message);
	}

}
