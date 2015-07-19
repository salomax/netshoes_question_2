# netshoes_question_1

## Questão 1

Expor um servico de BUSCA DE CEP, porém esta funcionalidade  ja existe no site atual, porem nao existe nenhum tipo de webservice.

### Requisitos Funcionais

Usuário informará o CEP e como resultado, deverá obter o nome da RUA, BAIRRO, CIDADE e ESTADO para preencher seus dados de cadastro de forma automática.

#### Critérios de Aceite

- Dado um CEP válido, deve retornar o endereço correspondente
- Dado um CEP válido, que não exista o endereço, deve substituir um digito da direita para a esquerda por zero até que o endereço seja localizado (Exemplo: Dado 22333999 tentar com 22333990, 22333900 …)
- Dado um CEP inválido, deve retornar uma mensagem reportando o erro: "CEP inválido"

### Requisitos Não Funcionais

- Os serviços devem receber e responder JSON;
 
### Etc

- Faça o uso de Mocks principalmente nos testes;
- Os dados dos CEPs podem ser "Mocados";
- Pense em como documentar os cenários desenvolvidos (Testes sempre são uma boa forma de documentar);
- Ao finalizar o desenvolvimento você pode compartilhar o código pelo Github ou de outra maneira que preferir (como arquivo compactado). Se possivel, em caso de arquivo compacto, envie o mesmo para um virtual drive e compartilha o link na prova;
- Fique a vontade para entrar em contato e tirar dúvidas;


## Solução
 

