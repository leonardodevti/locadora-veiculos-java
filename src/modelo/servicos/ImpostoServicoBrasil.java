package modelo.servicos;
//Implementando a interface ServicoImposto, dando flexibilidade para altera��o de imposto(Para outro pa�s, por exemplo).
public class ImpostoServicoBrasil implements ImpostoServico {

	public double imposto (double quantia) {
		if (quantia <= 100.0) {
			return quantia * 0.2;
		}
		else {
			return quantia * 0.15;
		}
	}	
}
