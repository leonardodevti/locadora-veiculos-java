package modelo.servicos;

import modelo.entidades.AluguelCarros;
import modelo.entidades.Fatura;

public class ServicoAluguel {

	private Double precoPorDia;
	private Double precoPorHora;
	
	private ImpostoServicoBrasil impostoServico;

	
	public ServicoAluguel () {
		
	}
	
	public ServicoAluguel(Double precoPorDia, Double precoPorHora, ImpostoServicoBrasil impostoServico) {
		super();
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
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		}
		else {
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
		}
		//Calculando o imposto.
		double imposto = impostoServico.imposto(pagamentoBasico);
		
		//Criando um novo objeto de nota de pagamento de associando ele a com o objeto de aluguel.
		aluguelCarros.setFatura(new Fatura(pagamentoBasico, imposto));
	}
	
}
