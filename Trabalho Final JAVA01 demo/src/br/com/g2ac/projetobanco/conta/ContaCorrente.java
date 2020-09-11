package br.com.g2ac.projetobanco.conta;

import br.com.g2ac.projetobanco.usuario.Usuario;

public class ContaCorrente extends Conta{

	private final double TAXA_SAQUE = 0.10;
	private final double TAXA_DEPOSITO = 0.10;
	private final double TAXA_TRANSFERENCIA = 0.20;
	
	protected final String tipoConta = "Conta Corrente";
	protected double totalTributo;
	
	public ContaCorrente(String agencia, Usuario titular) {
		super(agencia, titular);
	}
	
	public String getTipoConta() {
		return this.tipoConta;
	}

	@Override
	public void saca(double valor) {
		if(this.saldo < (valor + TAXA_SAQUE)) {
			System.out.println("FALTA TRATAR O ERRO!!!");
		}
		else {
			this.saldo -= (valor + TAXA_SAQUE);
			this.atualizaTributo(TAXA_SAQUE);
		}
	}

	@Override
	public void deposita(double valor) {
		this.saldo += (valor - TAXA_DEPOSITO);
		this.atualizaTributo(TAXA_DEPOSITO);
	}

	@Override
	public void transfere(Conta destino, double valor) {
		if(this.saldo < (valor + TAXA_TRANSFERENCIA)) {
			System.out.println("TRATAR O ERROOOO!!!");
		}
		else {
			this.saldo -= (valor + TAXA_TRANSFERENCIA);
			destino.saldo += valor;
			this.atualizaTributo(TAXA_TRANSFERENCIA);
		}
	}
	
	public void atualizaTributo(double tributo) {
		this.totalTributo += tributo;
	}
	
	public void getRelatorio() {
		System.out.println(this.tipoConta);
		System.out.println("Número da conta: " + this.numConta);
		System.out.println("Nome do titular: " + this.titular.getNome());
		System.out.println("Saldo atual: " + this.saldo);
		System.out.println("Total gasto com tributos: " + this.totalTributo);
	}
}
