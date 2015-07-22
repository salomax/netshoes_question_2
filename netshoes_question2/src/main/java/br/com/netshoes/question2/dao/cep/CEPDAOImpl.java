package br.com.netshoes.question2.dao.cep;

import java.util.HashMap;
import java.util.Map;

import br.com.netshoes.question2.entity.endereco.EnderecoEntity;

/**
 * Implementação de exemplo no padrão DAO para CRUD de CEPs.
 * 
 * @author salomao.marcos@gmail.com
 */
public class CEPDAOImpl implements CEPDao {
	
	/**
	 * Map contendos os CEPs cadastrados e seus respectivos endereços.
	 */
	private Map<String, EnderecoEntity> enderecos;
	
	/**
	 * Construtor padrão.
	 */
	public CEPDAOImpl() {
		this.enderecos = new HashMap<String, EnderecoEntity>();
	}
	
	/**
	 * Construtor passando os valores dos endereços.
	 */
	public CEPDAOImpl(HashMap<String, EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * Buscar endereço pelo CEP.
	 */
	public EnderecoEntity buscarEnderecoPorCEP(String cep) {
		return this.enderecos.get(cep);
	}
	
	/**
	 * Incluir novo endereço pelo CEP.
	 */
	public void addEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity) {
		this.enderecos.put(cep, enderecoEntity);
	}

	/**
	 * Remover endereço existente pelo CEP.
	 */
	public void removeEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity) {
		this.enderecos.remove(cep);
	}

}

