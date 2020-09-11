package br.com.g2ac.projetobanco.main;

import br.com.g2ac.projetobanco.conta.*;
import br.com.g2ac.projetobanco.usuario.*;

public class TestaConta {

	public static void main(String[] args) {
		Usuario cliente1 = new Cliente("Júnior", "12332145678", "1234");
		Usuario cliente2 = new Cliente("Zico", "12332145671", "1235");
		Usuario cliente3 = new Cliente("Adílio", "12332145672", "1236");
		Usuario cliente4 = new Cliente("Andrade", "12332145673", "1237");
		
		Conta cc1 = new ContaCorrente("1234-5", cliente1);
		cc1.deposita(2000);
		cc1.getRelatorio();
		System.out.println();
		Conta cc2 = new ContaCorrente("1234-5", cliente2);
		cc2.deposita(81000);
		cc2.getRelatorio();
		System.out.println();
		Conta cp1 = new ContaPoupanca("1234-5", cliente3);
		cp1.deposita(3000);
		cp1.getRelatorio();
		System.out.println();
		Conta cp2 = new ContaPoupanca("1234-5", cliente4);
		cp2.deposita(50000);
		cp2.getRelatorio();
		
		/*
		cc1.deposita(2000);
		cc2.deposita(5000);
		cp1.deposita(70000);
		cp2.deposita(150000);
		
		cp2.transfere(cc1, 75000);
		cp1.transfere(cc2, 100000);
		cc2.saca(3000);
		*/
	}

}
