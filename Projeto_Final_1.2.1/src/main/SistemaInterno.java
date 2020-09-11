package main;

import java.io.*;
import java.util.*;

import Sistema.*;
import contas.Agencia;
import modelo.contas.*;
import modelo.usuario.*;

public class SistemaInterno {

	public static void main(String[] args) {
		
		Map<String, Cliente> mapaCliente = null;
		Map<Integer, Agencia> mapaAgencia = null;
		Map<String, Funcionario> mapaFuncionario = null;
		Map<String, ContaCorrente> mapaContaCorrente = null;
		Map<String, ContaPoupanca> mapaContaPoupanca = null;

		Scanner sc = new Scanner(System.in);
		CarregaArquivo importa = new CarregaArquivo();

<<<<<<< HEAD:JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java
		Map<String, Cliente> mapaCliente = importa.importaCliente();
		Map<Integer, Agencia> mapaAgencia = importa.importaAgencia();
		Map<String, Funcionario> mapaFuncionario = importa.importaFuncionario();
		Map<String, ContaCorrente> mapaContaCorrente = importa.importaContaCorrente();
		Map<String, ContaPoupanca> mapaContaPoupanca = importa.importaContaPoupanca();
=======
		try {
			mapaCliente = importa.importaCliente();
			mapaAgencia = importa.importaAgencia();
			mapaFuncionario = importa.importaFuncionario();
			mapaContaCorrente = importa.importaContaCorrente();
			mapaContaPoupanca = importa.importaContaPoupanca();

		} catch (IOException e) {
			System.out.println("Arquivo n„o localizado." + e);
		}
>>>>>>> 0633f60c3e82e64d64529e34cc1e28a25bfd4b62:3. JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java

		Usuario usuarioLogado = null;
		Conta contaLogada = null;
		boolean ativo = false;
		String cpf = "0";
		String senha = "0";
		int op;

		do {
			try {

				Telas.telaLogin();
<<<<<<< HEAD:JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java
				cpf = sc.next();
=======
				System.out.println();
				System.out.print("CPF: ");
				cpf = sc.next();
				System.out.print("Senha: ");
>>>>>>> 0633f60c3e82e64d64529e34cc1e28a25bfd4b62:3. JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java
				senha = sc.next();
				usuarioLogado = verificaUsuario(mapaCliente, mapaFuncionario, cpf, senha);
				contaLogada = buscaConta(mapaContaCorrente, mapaContaPoupanca, usuarioLogado);
				ativo = true;
<<<<<<< HEAD:JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java
=======
				Telas.imprimeSaudacao(usuarioLogado);
				
>>>>>>> 0633f60c3e82e64d64529e34cc1e28a25bfd4b62:3. JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java

			} catch (Exception e) {
				System.out.println("Dados Invalidos!" + e);

			}
<<<<<<< HEAD:JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java
		} while (!ativo);
=======
		} while (!ativo);		
>>>>>>> 0633f60c3e82e64d64529e34cc1e28a25bfd4b62:3. JAVA_1/Cain√£/Projeto_Final_1.2.1/src/main/SistemaInterno.java

		do {
			op = sc.nextInt();
			switch (op) {
			case 1:
				Telas.telaSaque(usuarioLogado, contaLogada, mapaContaCorrente, mapaContaPoupanca);
				break;
			case 2:
				Telas.telaDeposito(usuarioLogado, contaLogada, mapaContaCorrente, mapaContaPoupanca);
				break;
			case 3:
				Telas.telaTransferencia(usuarioLogado, contaLogada, mapaContaCorrente, mapaContaPoupanca);
				break;
			case 4:
				Telas.telaSeguro(usuarioLogado, mapaCliente);
				break;
			case 5:
				Telas.telaSaldo(usuarioLogado, contaLogada, mapaContaCorrente, mapaContaPoupanca);
				break;
			case 6:
				Telas.telaRelatorioTributo(usuarioLogado, contaLogada, mapaContaCorrente, mapaContaPoupanca);
				break;
			case 7:
				Telas.telaRelatorioRendimento(usuarioLogado, contaLogada, mapaContaPoupanca);
				break;
			case 8:
				if (mapaFuncionario.get(usuarioLogado.getCpf()).getCargo().equals("Gerente")) {
					Telas.telaRelatorioGerente(usuarioLogado, mapaFuncionario, mapaContaCorrente, mapaContaPoupanca);
				} else if (mapaFuncionario.get(usuarioLogado.getCpf()).getCargo().equals("Diretor")) {
					Telas.telaRelatorioDiretor(usuarioLogado, mapaFuncionario, mapaContaCorrente, mapaContaPoupanca);
				} else if (mapaFuncionario.get(usuarioLogado.getCpf()).getCargo().equals("Presidente")) {
					Telas.telaRelatorioPresidente(usuarioLogado, mapaFuncionario, mapaContaCorrente, mapaContaPoupanca);
				}
				break;
			case 0:
				System.out.println("Programa Finalizado!");
				System.exit(0);
				break;
			default:
				System.out.println("OpÁ„o Inv·lida!");
				break;
			}
			if (mapaFuncionario.get(usuarioLogado.getCpf()) != null) {
				Telas.telaPrincipal();
				Telas.telaRelatorioFuncionario();
			} else {
				Telas.telaPrincipal();
			}

		} while (op != 0);
	}

	public static Usuario verificaUsuario(Map<String, Cliente> mapaCliente, Map<String, Funcionario> mapaFuncionario,
			String cpf, String senha) {

		Usuario usuarioLogado = null;

		if (mapaFuncionario.get(cpf) != null) {
			String cargo = mapaFuncionario.get(cpf).getCargo();

			if (cargo.endsWith("Presidente")) {
				usuarioLogado = (Presidente) mapaFuncionario.get(cpf);
				if (logar(usuarioLogado, senha)) {
					Telas.telaPrincipal();
					Telas.telaRelatorioFuncionario();
				} else {
					System.out.println("Dados incorretos!");
				}
				return usuarioLogado;
			} else if (cargo.endsWith("Diretor")) {
				usuarioLogado = (Diretor) mapaFuncionario.get(cpf);

				if (logar(usuarioLogado, senha)) {
					Telas.telaPrincipal();
					Telas.telaRelatorioFuncionario();
				} else {
					System.out.println("Dados incorretos!");
				}
				return usuarioLogado;
			} else {
				usuarioLogado = (Gerente) mapaFuncionario.get(cpf);

				if (logar(usuarioLogado, senha)) {
					Telas.telaPrincipal();
					Telas.telaRelatorioFuncionario();
				} else {
					System.out.println("Dados incorretos!");
				}
				return usuarioLogado;
			}
		} else if (mapaCliente.get(cpf) != null) {
			usuarioLogado = (Cliente) mapaCliente.get(cpf);
			if (logar(usuarioLogado, senha)) {
				Telas.telaPrincipal();
			} else {
				System.out.println("Dados incorretos!");
			}
			return usuarioLogado;

		} else {
			System.out.println("N„o Cadastrado!");
		}

		throw new NullPointerException();
	}

	public static boolean logar(Usuario usuario, String senha) {

		if (usuario.getSenha().endsWith(senha)) {
			return true;
		}
		throw new RuntimeException("Senha incorreta!");
	}

	public static Conta buscaConta(Map<String, ContaCorrente> mapaContaCorrente,
			Map<String, ContaPoupanca> mapaContaPoupanca, Usuario usuarioLogado) {

		Conta contaLogada = null;

		if (mapaContaCorrente.get(usuarioLogado.getCpf()) != null) {
			contaLogada = (ContaCorrente) mapaContaCorrente.get(usuarioLogado.getCpf());
			return contaLogada;
		}

		if (mapaContaPoupanca.get(usuarioLogado.getCpf()) != null) {
			contaLogada = (ContaPoupanca) mapaContaPoupanca.get(usuarioLogado.getCpf());
			return contaLogada;
		}

		return contaLogada;

	}

}
