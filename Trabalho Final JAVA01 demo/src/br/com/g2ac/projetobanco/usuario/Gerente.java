package br.com.g2ac.projetobanco.usuario;

import java.util.*;

import br.com.g2ac.projetobanco.conta.Conta;

public class Gerente extends Funcionario{

	private String agenciaResp;
	
	public Gerente(String nome, String cpf, String senha, String cargo, String agencia) {
		super(nome, cpf, senha, cargo);
		this.agenciaResp = agencia;
	}
	
	public void relatorioContasNaAgencia(List lista) {		
		int contador = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(this.agenciaResp == lista.get(i)) {
				contador += 1;
			}
		}
		System.out.println("A agência a qual esse gerente é responsável possui " + contador + " contas.");
	}
}
