package br.com.netshoes.question1.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.netshoes.question1.exception.cep.CEPInvalidoException;

/**
 * Classe responsável no tratamento de exceções na camada REST.
 * 
 * @author salomao.marcos@gmail.com
 */
@Provider
public class CEPInvalidoExceptionMapper implements ExceptionMapper<CEPInvalidoException> {

	/**
	 * Mensagem de erro padrão.
	 */
	private static final String MSG_ERRO = "CEP inválido";

	/**
	 * Resposta padrão.
	 */
	@Override
	public Response toResponse(CEPInvalidoException arg0) {
		return Response.status(422)
				.entity(MSG_ERRO)
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

}
