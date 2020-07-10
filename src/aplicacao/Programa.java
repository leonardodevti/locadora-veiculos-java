package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.AluguelCarros;
import modelo.entidades.Veiculo;
import modelo.servicos.ImpostoServicoBrasil;
import modelo.servicos.ServicoAluguel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner ent = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Informe a data do aluguel");
		System.out.print("\nModelo do carro: ");
		String modeloCarro = ent.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:ss): ");
		Date inicio = sdf.parse(ent.nextLine());
		System.out.print("Retorno (dd/MM/yyyy HH:ss): ");
		Date fim = sdf.parse(ent.nextLine());
		
		AluguelCarros ac = new AluguelCarros(inicio, fim, new Veiculo(modeloCarro));
		
		System.out.print("Informe o preço por hora: ");
		double precoPorHora = ent.nextDouble();
		System.out.print("Informe o preço por dia: ");
		double precoPorDia = ent.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorDia, precoPorHora, new ImpostoServicoBrasil());
		
		servicoAluguel.processoFatura(ac);
		
		System.out.println("Aluguel: ");
		System.out.println("Pagamento básico: " + String.format("%.2f", ac.getFatura().getPagamentoBasico()));
		System.out.println("Imposto: " + String.format("%.2f", ac.getFatura().getImposto()));
		System.out.println("Pagamento total: " + String.format("%.2f", ac.getFatura().getPagamenTotal()));
		
		
		ent.close();
	}

}
