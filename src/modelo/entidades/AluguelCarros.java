package modelo.entidades;

import java.util.Date;

public class AluguelCarros {
	
	private Date inicio;
	private Date fim;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public AluguelCarros () {
		
	}

	public AluguelCarros(Date inicio, Date fim, Veiculo veiculo) {
		this.inicio = inicio;
		this.fim = fim;
		this.veiculo = veiculo;
	}//fatura n�o est� no construtor, pois o aluguel pode n�o ter sido processado ainda(Pode n�o ter nota de pagamento)

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
}
