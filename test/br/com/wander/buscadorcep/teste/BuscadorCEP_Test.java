/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wander.buscadorcep.teste;

import br.com.wander.buscadorcep.BuscaCEP;
import org.junit.Test;
import java.io.IOException;
import org.junit.Assert;
/**
 *
 * @author Wanderlei
 */
public class BuscadorCEP_Test {
    
    public BuscadorCEP_Test() {
    }

    @Test
    public void  deveRetornarEndereco() throws IOException{
       String cep = "29032808";
       
       String endereco = BuscaCEP.getEndereco(cep);
       String bairro = BuscaCEP.getBairro(cep);
       String cidade = BuscaCEP.getCidade(cep);
       String uf = BuscaCEP.getUF(cep);
       
       System.out.println(endereco);
       System.out.println(cidade);
       System.out.println(bairro);
       System.out.println(uf);
       Assert.assertTrue("Validando endereço: ", endereco.equals("Rua João Dentuski"));
       Assert.assertTrue("Validando bairro: ", bairro.equals("Redenção"));
       Assert.assertTrue("Validando cidade: ", cidade.equals("Vitória"));
       Assert.assertTrue("Validando uf: ", uf.equals("ES"));
    }    
}
