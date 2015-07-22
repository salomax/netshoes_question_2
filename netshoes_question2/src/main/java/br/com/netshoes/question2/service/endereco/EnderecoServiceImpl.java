package br.com.netshoes.question2.service.endereco;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.netshoes.question2.dao.endereco.EnderecoDAO;
import br.com.netshoes.question2.entity.endereco.EnderecoEntity;
import br.com.netshoes.question2.exception.endereco.EnderecoInvalidoException;

/**
 * Implementação do serviço para os metodos CRUD de endereço.
 * 
 * @author Marcos Salomão (salomao.marcos@gmail.com)
 *
 */
public class EnderecoServiceImpl implements EnderecoService {

	/**
	 * DAO de endereços.
	 */
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	/**
	 * Salvar um endereço.
	 */
	public void salvar(EnderecoEntity endereco) throws EnderecoInvalidoException {
		
		this.enderecoDAO.salvar(endereco);
		
	}
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	public void remover(String id) throws EnderecoInvalidoException {
		
		this.enderecoDAO.remover(id);
		
	}
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	public EnderecoEntity selecionar(String id) throws EnderecoInvalidoException {
		
		return this.enderecoDAO.selecionar(id);
		
	}
	
}
