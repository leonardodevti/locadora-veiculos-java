package modelo.servicos;
//Implementando a interface ServicoImposto, dando flexibilidade para alteração de imposto(Para outro país, por exemplo).
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
