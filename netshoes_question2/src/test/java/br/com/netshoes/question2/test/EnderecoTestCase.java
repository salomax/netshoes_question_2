package br.com.netshoes.question2.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.netshoes.question2.entity.endereco.EnderecoEntity;
import br.com.netshoes.question2.exception.endereco.EnderecoInvalidoException;
import br.com.netshoes.question2.service.cep.CEPService;
import br.com.netshoes.question2.service.endereco.EnderecoService;

/**
 * Test Case do serviço CRUD de endereço.
 * 
 * @author Marcos Salomão (salomao.marcos@gmail.com)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EnderecoTestCase {
	
	/**
	 * Serviço do CEP.
	 */
	@Autowired
	private CEPService cepService;

	/**
	 * Serviço do CRUD de endereço.
	 */
	@Autowired
	private EnderecoService enderecoService;
	
	/**
	 * Teste salvar novo.
	 */
	@Test
	public void salvarNovo() {

		try {
			
			// Buscar CEP válido
			EnderecoEntity enderecoEntity = 
					this.cepService.buscarEnderecoPorCEP("22333999");
			
			// Informar um número pois é obrigatório
			enderecoEntity.setNumero("123");
			
			// Salvar
			this.enderecoService.salvar(enderecoEntity);
			
			// Validar
			Assert.assertNotNull(enderecoEntity.getId());
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	/**
	 * Teste salvar existente.
	 */
	@Test
	public void salvarExistente() {
		
		try {
			
			// Buscar CEP válido
			EnderecoEntity enderecoEntity = 
					this.cepService.buscarEnderecoPorCEP("22333999");
			
			// Informar um número pois é obrigatório
			enderecoEntity.setNumero("123");
			
			// Salvar
			this.enderecoService.salvar(enderecoEntity);
			
			// Validar
			Assert.assertNotNull(enderecoEntity.getId());

			String id = enderecoEntity.getId();
			
			this.enderecoService.salvar(enderecoEntity);

			// Validar
			Assert.assertEquals(enderecoEntity.getId(), id);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	/**
	 * Teste listar.
	 */
	@Test
	public void listar() {
		
		try {
			
			// Buscar CEp válido
			EnderecoEntity enderecoEntity = 
					this.cepService.buscarEnderecoPorCEP("22333999");
			
			// Informar um número pois é obrigatório
			enderecoEntity.setNumero("123");
			
			// Salvar
			this.enderecoService.salvar(enderecoEntity);
			
			// Validar
			Assert.assertNotNull(enderecoEntity.getId());
			
			// Listar endereços cadastrados
			Collection<EnderecoEntity> enderecos = this.enderecoService.listar();
			
			// Validar
			Assert.assertNotNull(enderecos);
			Assert.assertTrue(enderecos.size() > 0);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	/**
	 * Teste listar.
	 */
	@Test
	public void remover() {
		
		EnderecoEntity enderecoEntity = null;
		
		try {
			
			// Buscar CEP válido
			enderecoEntity = this.cepService.buscarEnderecoPorCEP("22333999");
			
			// Informar um número pois é obrigatório
			enderecoEntity.setNumero("123");
			
			// Salvar
			this.enderecoService.salvar(enderecoEntity);
			
			// Validar
			Assert.assertNotNull(enderecoEntity.getId());
			
			// Remover		
			this.enderecoService.remover(enderecoEntity.getId());
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		try {

			// Verificar se o mesmo foi removido
			this.enderecoService.selecionar(enderecoEntity.getId());

		} catch (EnderecoInvalidoException e) {
			// Exceção esperada
		}

	}
	
}
