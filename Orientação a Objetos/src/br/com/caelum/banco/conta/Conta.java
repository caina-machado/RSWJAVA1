package br.com.caelum.banco.conta;

import br.com.caelum.util.Data;

public class Conta
{
	private int identificador; //N�o precisa de setter nem getter
	private int numConta;
	private String titular;
	private double saldo;
	private String agencia;
	private Data dataAbertura;
	
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}	
	
	public Conta(String nome, int num, String agencia, Data data, int id)
	{
		this.numConta = num;
		this.titular = nome;
		this.agencia = agencia;
		this.dataAbertura = data;
		this.saldo = 0;
		this.identificador = id;
	}

	public void saca(double valorSaque)
	{
		if(this.saldo >= valorSaque)
		{
			double novoSaldo = this.saldo - valorSaque;
			this.saldo = novoSaldo;
		}
		else
		{
			System.out.print("N�o � poss�vel sacar esse valor nessa conta.");
		}
	}
	
	public void deposita(double valorDeposito)
	{
		double novoSaldo = this.saldo + valorDeposito;
		this.saldo = novoSaldo;
	}
	
	public double calculaRendimento()
	{
		double rendimento = this.saldo * 0.1;
		return rendimento;
	}
	
	public void imprimeInformacoes()
	{
		System.out.println("Titular da conta: " + this.titular);
		System.out.println("N�mero da conta: " + this.numConta);
		System.out.println("Identificador da conta: " + this.identificador);
		System.out.println("Ag�ncia: " + agencia);
		System.out.println("Data de Abertura: " + dataAbertura.retornaData());
		System.out.println("Saldo atual: " + this.saldo);
		System.out.println("Rendimento mensal: " + calculaRendimento());
		System.out.println();
	}
}