package aplicacacao;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumerosAleatorios {

	private Scanner scanner;
	private int limitador = 0;
	private String resp = "";
	
	public static void main(String[] args) {
		NumerosAleatorios teste = new NumerosAleatorios();
		teste.perguntar();
	}

	public int aleatorio(int dig) {
		int minimo = 0;
		int maximo = 0;
		int resultado = 0;
		Random random = new Random();
		
		if(dig == 5) {
			minimo = -59999;
			maximo = 59999;
			resultado = random.nextInt((maximo - minimo) + 1) + minimo;
		}else if(dig == 6) {
			minimo = -599999;
			maximo = 599999;
			resultado = random.nextInt((maximo - minimo) + 1) + minimo;
		}else if(dig == 7) {
			minimo = -5999999;
			maximo = 5999999;
			resultado = random.nextInt((maximo - minimo) + 1) + minimo;
		}		
		return resultado;
	}
	
	private void perguntar() {
		try {
			scanner = new Scanner(System.in);
			System.out.print("Digite um numero: ");
			limitador = scanner.nextInt();
			
			if (limitador >= 5 && limitador <= 7) { 
				System.out.println(String.format("%05d", aleatorio(limitador)));
				sair();	
			}
			else
			{
				System.out.println("Favor, digite um numero maior que 5 ou menor que 7");
				System.out.println("");
				perguntar();					
			}
		}catch(InputMismatchException ime)
		{
			System.out.println("Por favor, digite apenas a numero. ");
			System.out.println("");
			perguntar();
		}
	}

	private void sair() {
		System.out.println();
		System.out.print("Deseja repetir? (S/N): ");
		
		resp = scanner.next();
		
		if(resp.length() == 1) 
		{
			if(resp.toUpperCase().equals("S")) {
				perguntar();
			} else if(resp.toUpperCase().equals("N")){
				System.out.println("Fim da aplicação");
				scanner.close();
				System.exit(0);
			}
			else{
				System.out.println();
				System.out.print("Por favor, digite apenas S ou N ");
				sair();
			}
		}
		else
		{
			System.out.println();
			System.out.print("Texto muito grande. ");
			System.out.print("Por favor, digite apenas S ou N ");
			sair();
		}
	}	
}
