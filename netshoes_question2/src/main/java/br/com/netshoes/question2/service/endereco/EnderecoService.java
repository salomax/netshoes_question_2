package br.com.netshoes.question2.service.endereco;

import br.com.netshoes.question2.entity.endereco.EnderecoEntity;
import br.com.netshoes.question2.exception.endereco.EnderecoInvalidoException;

/**
 * Interface do serviço para os metodos CRUD de endereço.
 * 
 * @author Marcos Salomão (salomao.marcos@gmail.com)
 *
 */
public interface EnderecoService {
	
	/**
	 * Salvar um endereço.
	 */
	public void salvar(EnderecoEntity endereco) throws EnderecoInvalidoException;
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	public void remover(String id) throws EnderecoInvalidoException;
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	public EnderecoEntity selecionar(String id) throws EnderecoInvalidoException;

}
