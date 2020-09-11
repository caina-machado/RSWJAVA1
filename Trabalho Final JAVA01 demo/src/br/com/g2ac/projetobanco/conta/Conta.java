package br.com.g2ac.projetobanco.conta;

import br.com.g2ac.projetobanco.usuario.Usuario;

public abstract class Conta {
	protected static int numConta = 0;
	protected Usuario titular;
	protected double saldo;
	private String agencia;
	
	public Conta(String agencia, Usuario titular) {
		this.numConta++;
		this.agencia = agencia;
		this.titular = titular;
	}
	
	public String getAgencia() {
		return this.agencia;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public abstract void saca(double valor);
	
	public abstract void deposita(double valor);
	
	public abstract void transfere(Conta destino, double valor);
	
	public abstract void getRelatorio();
}
