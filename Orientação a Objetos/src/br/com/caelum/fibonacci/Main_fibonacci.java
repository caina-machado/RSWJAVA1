package br.com.caelum.fibonacci;
import java.util.Scanner;

public class Main_fibonacci 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Fibonacci_recursivo fibonacci = new Fibonacci_recursivo();
		
		System.out.print("Digite quantos n�meros da sequ�ncia Fibonacci deseja ver: ");
		int num = scan.nextInt();
		
		for(int i = 1; i <= num; i++)
		{
			int resultado = fibonacci.calculaFibonacci(i);
			System.out.print(resultado + " ");
		}
		scan.close();
	}
}
