package br.com.netshoes.question1.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import br.com.netshoes.question1.rest.exception.CEPInvalidoExceptionMapper;

/**
 * Configuração REST.
 * 
 * @author salomao.marcos@gmail.com
 *
 */
public class AppConfig extends ResourceConfig {

	/**
	 * Construtor padrão.
	 */
	public AppConfig() {
		register(RequestContextFilter.class);
		register(CEPResource.class);
		register(CEPInvalidoExceptionMapper.class);
	}
	
}
