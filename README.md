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


### Solução

Partindo da premissa de um site existente, onde já temos disponível um serviço de busca de CEP, a solução terá como objetivo **expor o mesmo por um tipo de webservice**.

Portanto, a primeira etapa será separarmos esta funcionalidade existente entre a camada de negócio (a busca efetiva do CEP) e a responsável por expor o webservice, diminuindo o acoplamento e responsabilidade de cada objeto.

Como o objetivo é apenas expormos em um tipo de webservice utilizando JSON, adotou-se o padrão Web Service [RESTful](https://en.wikipedia.org/wiki/Representational_state_transfer) ao invés do SOAP, por ser mais simples e também adequado à proposta. Utilizou-se o framework **Jersey** como responsável por expor o webservice RESTful.

O serviço foi disponibilizado em `services/cep/`. Veja exemplo:

```
GET services/cep/22333999

200 OK

{
 "CEP" : {
  RUA : "Rua Xxxxxx",
  BAIRRO : "Xxxxx",
  CIDADE : "Xxxxx",
  ESTADO : "XX"
 }
}

ou em caso de não encontrar

422 CEP inválido

```




