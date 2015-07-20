package br.com.netshoes.question1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.RandomStringUtils;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import br.com.netshoes.question1.dao.cep.CEPDao;
import br.com.netshoes.question1.entity.cep.EnderecoEntity;
import br.com.netshoes.question1.rest.AppConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Teste unitário do serviço REST para busca do CEP.
 * 
 * @author salomao.marcos@gmail.com
 */
public class BuscarCEPRestTestCase extends JerseyTest {
	
	/**
	 * Container Jersey.
	 */
	private ApplicationHandler applicationHandler;

	/**
	 * Configuração REST.
	 */
	@Override
    protected Application configure() {
		
		AppConfig appConfig = new AppConfig();
		appConfig.property("contextConfigLocation", "classpath:applicationContext.xml");
		
		this.applicationHandler = new ApplicationHandler(appConfig);
		
        return appConfig;
    }
	
	/**
	 * Buscar CEP válido.
	 */
	@Test
	public void buscarCEPsValidos() {
        
		try {
			
			// Obter contexto Spring
			ApplicationContext applicationContext = 
					this.applicationHandler.getServiceLocator().getService(ApplicationContext.class);
			
			// Obter o CEPDao para incluir o CEP de teste 
			CEPDao cepDao = (CEPDao) applicationContext.getBean("cepDao");
			
			/*
			 * Incluir CEP 12345678 para a consulta
			 *
			 * NÃO MOCKADO VIA MOCKITO O OBJETO EnderecoEntity 
			 * POR APRESENTAR ERRO AO GERAR STREAM JSON
			 */
			String cepTeste = "12345678";

			// Incluir o endereço com o CEP de teste
			EnderecoEntity enderecoEntity = mockEndereco();
			cepDao.addEnderecoPorCEP(cepTeste, enderecoEntity);
			
			// Executar requisição GET
			final Response response = target("cep/" + cepTeste).request().get();
			
			// Validar a resposta não é nula
			assertNotNull(response);

			// Validar se a resposta é OK (status 200)
			assertEquals(200, response.getStatus());
			
			// Validar se a resposta está no padrão JSON e é igual ao endereço esperado
			String jsonResponse = response.readEntity(String.class);
			assertNotNull(jsonResponse);
			
			ObjectMapper mapper = new ObjectMapper();
			EnderecoEntity enderecoResponse = mapper.readValue(jsonResponse, EnderecoEntity.class);
			
			assertEquals(enderecoEntity.getRua(), enderecoResponse.getRua());
			assertEquals(enderecoEntity.getBairro(), enderecoResponse.getBairro());
			assertEquals(enderecoEntity.getCidade(), enderecoResponse.getCidade());
			assertEquals(enderecoEntity.getEstado(), enderecoResponse.getEstado());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
    	
    }

	/**
	 * Mock endereço.
	 */
	private EnderecoEntity mockEndereco() {
		EnderecoEntity enderecoEntity = new EnderecoEntity();

		enderecoEntity.setRua(RandomStringUtils.random(9, "abc"));
		enderecoEntity.setBairro(RandomStringUtils.random(9, "abc"));
		enderecoEntity.setCidade(RandomStringUtils.random(9, "abc"));
		enderecoEntity.setEstado(RandomStringUtils.random(2, "ABC"));
		return enderecoEntity;
	}

}
