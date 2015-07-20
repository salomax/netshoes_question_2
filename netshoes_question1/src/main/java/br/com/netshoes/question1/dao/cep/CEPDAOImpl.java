/**
 * 
 */
package br.com.netshoes.question1.dao.cep;

import java.util.HashMap;
import java.util.Map;

import br.com.netshoes.question1.entity.cep.EnderecoEntity;

/**
 * Implementação de exemplo no padrão DAO para busca de endereços pelo CEP.
 * 
 * @author salomao.marcos@gmail.com
 */
public class CEPDAOImpl implements CEPDao {
	
	/**
	 * Map contendos os CEPs cadastrados e seus respectivos endereços.
	 */
	private static Map<String, EnderecoEntity> enderecos = new HashMap<String, EnderecoEntity>();
	
	/**
	 * Buscar endereço pelo CEP.
	 */
	public EnderecoEntity buscarEnderecoPorCEP(String cep) {
		return CEPDAOImpl.enderecos.get(cep);
	}
	
	/**
	 * Incluir novo endereço pelo CEP.
	 */
	public void addEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity) {
		CEPDAOImpl.enderecos.put(cep, enderecoEntity);
	}

	/**
	 * Remover endereço existente pelo CEP.
	 */
	public void removeEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity) {
		CEPDAOImpl.enderecos.remove(cep);
	}

}

