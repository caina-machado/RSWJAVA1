package br.com.g2ac.projetobanco.conta;

import br.com.g2ac.projetobanco.usuario.Usuario;

public class ContaPoupanca extends Conta{

	private final double TAXA_RENDIMENTO = 0.002;
	
	protected final String tipoConta = "Conta Poupança";
	
	public ContaPoupanca(String agencia, Usuario titular) {
		super(agencia, titular);
	}
	
	public String getTipoConta() {
		return this.tipoConta;
	}

	@Override
	public void saca(double valor) {
		if(this.saldo < valor) {
			System.out.println("FALTA TRATAR O ERRO!!!");
		}
		else {
			this.saldo = this.saldo - valor;
		}
	}

	@Override
	public void deposita(double valor) {
		if(valor < 0) {
			System.out.println("TRATAR ERRO");
		}
		else {
			this.saldo += valor;
		}
	}

	@Override
	public void transfere(Conta destino, double valor) {
		if(this.saldo < valor) {
			System.out.println("TRATAR O ERROOOO!!!");
		}
		else {
			this.saldo = this.saldo - valor;
			destino.saldo += valor;
		}
	}
	
	public String simulaRendimento(double valor, int dia) {
		double total = valor * dia * TAXA_RENDIMENTO;
		String simulador = "Simulação de rendimento de R$ " + valor + " para " + dia + " dias com " + TAXA_RENDIMENTO
				+ "% de rendimento foi de: R$" + total;
		return simulador;
	}
	
	public void getRelatorio() {
		System.out.println(this.tipoConta);
		System.out.println("Número da conta: " + this.numConta);
		System.out.println("Nome do titular: " + this.titular.getNome());
		System.out.println("Saldo atual: " + this.saldo);
	}
}
