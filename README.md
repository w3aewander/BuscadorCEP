# BuscadorCEP
Buscador de Endereços a partir do CEP

## Esta biblioteca foi criada inspirada na classe de  "danilovazb" do site http://respostas.guj.com.br/6592-api-java-para-buscar-cep-correios

Fiz a biblioteca para contribuir com os demais usuários.

Esta classe lê endereço, bairro, cidade, uf e as coordenadas geográficas do local latitude e longetude.

Transformei os métodos em static para facilitar a obtenção da informação.

### Como usar:

Para usar simplesmete copie o jar da pasta lib para a bibliotecas de seu sistema.

Com esta classe você pode implementar um mapa obtendo as coordenadas com método getLatLng(cep) e enviando como parâmetro para o google maps.

# Exemplo de uma implementação:

Use da seguinte maneira:


###
       String cep = "29032808";     
       String endereco = BuscaCEP.getEndereco(cep);
       String bairro = BuscaCEP.getBairro(cep);
       String cidade = BuscaCEP.getCidade(cep);
       String uf = BuscaCEP.getUF(cep);
       
       System.out.println(endereco);
       System.out.println(cidade);
       System.out.println(bairro);
       System.out.println(uf);
       System.out.println(BuscaCEP.getLatLong(cep));
###
Wanderlei Silva do Carmo <Wander.silva@gmail.com>
