package modelo.servicos;

import modelo.entidades.AluguelCarros;
import modelo.entidades.Fatura;

public class ServicoAluguel {

	private Double precoPorDia;
	private Double precoPorHora;
	
	private ImpostoServico impostoServico;

	
	public ServicoAluguel () {
		
	}
	
	public ServicoAluguel(Double precoPorDia, Double precoPorHora, ImpostoServico impostoServico) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.impostoServico = impostoServico;
	}
	
	//Gerando a nota de pagamento
	public void processoFatura(AluguelCarros aluguelCarros) {
		long t1 = aluguelCarros.getInicio().getTime();
		long t2 = aluguelCarros.getFim().getTime();
		
		double horas = (double) (t2 - t1) / 1000 / 60 / 60;//Transformando de milissegundos para hora.
		
		double pagamentoBasico;
		
		if (horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;//Arredondando para mais a hora e multiplicando pelo preço por hora.
		}
		else {//Arredondando para mais a hora e multiplicando pelo preço por hora, tranformando em dias, e multiplicando por preço or dia.
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
		}
		//Calculando o imposto.
		double imposto = impostoServico.imposto(pagamentoBasico);
		
		//Criando um novo objeto de nota de pagamento de associando ele a com o objeto de aluguel.
		aluguelCarros.setFatura(new Fatura(pagamentoBasico, imposto));
	}
	
}
