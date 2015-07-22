/**
 * 
 */
package br.com.netshoes.question2.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import br.com.netshoes.question2.exception.endereco.EnderecoInvalidoException;

/**
 * @author Marcos Salomão (salomao.marcos@gmail.com)
 *
 */
public class EnderecoInvalidoExceptionMapper implements ExceptionMapper<EnderecoInvalidoException> {

	/**
	 * Resposta padrão.
	 */
	@Override
	public Response toResponse(EnderecoInvalidoException e) {
		return Response.status(422)
				.entity(e.getMessage())
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

}
