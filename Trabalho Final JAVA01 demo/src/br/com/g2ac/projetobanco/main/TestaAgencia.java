package br.com.g2ac.projetobanco.main;

import java.util.*;

import br.com.g2ac.projetobanco.conta.Conta;
import br.com.g2ac.projetobanco.conta.ContaCorrente;
import br.com.g2ac.projetobanco.usuario.Cliente;
import br.com.g2ac.projetobanco.usuario.Gerente;
import br.com.g2ac.projetobanco.usuario.Usuario;

public class TestaAgencia {
	public static void main(String[] args) {
		
		Usuario cliente1 = new Cliente("Júnior", "12332145678", "1234");
		Usuario cliente2 = new Cliente("Zico", "12332145671", "1235");
		Usuario cliente3 = new Cliente("Adílio", "12332145672", "1236");
		Usuario cliente4 = new Cliente("Andrade", "12332145673", "1237");
						
		Conta c1 = new ContaCorrente("1234-5", cliente1);
		Conta c2 = new ContaCorrente("1234-5", cliente2);
		Conta c3 = new ContaCorrente("5432-1", cliente3);
		Conta c4 = new ContaCorrente("1234-5", cliente4);
		
		List lista = new ArrayList();
		
		Gerente g1 = new Gerente("h", "12332145678", "123ert", "Gerente", "1234-5");
		
		lista.add(c1.getAgencia());
		lista.add(c2.getAgencia());
		lista.add(c3.getAgencia());
		lista.add(c4.getAgencia());
		
		g1.relatorioContasNaAgencia(lista);
	}
}
