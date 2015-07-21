# Questão 2

Salvar o endereco do usuario, seguindo as regras de CRUD (Create, Read, Update e Delete)

### Requisitos Funcionais

O usuário administrará seus dados de endereço (INCLUIR, CONSULTAR, ATUALIZAR, DELETAR).

#### Critérios de Aceite

- O endereço deve ser controlado por um ID único

Para o CEP deve-se garantir:
- Utilizar o serviço de BUSCA DE CEP para validar o CEP digitado
- Em caso de erro, retornar a mensagem do serviço de BUSCA DE CEP

Os atributos RUA, NÚMERO, CEP, CIDADE e ESTADO são obrigatórios
Os atributos BAIRRO e COMPLEMENTO não são obrigatórios
Em caso de erro:
- Retornar uma mensagem de erro
- Não efetuar a INCLUSÃO/ALTERAÇÃO

A busca deve ser feita pelo ID

