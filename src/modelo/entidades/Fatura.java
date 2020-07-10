package modelo.entidades;

public class Fatura {

	
	private Double pagamentoBasico;
	private Double imposto;
	
	public Fatura() {
		
	}

	public Fatura(Double pagamentoBasico, Double taxa) {
		this.pagamentoBasico = pagamentoBasico;
		this.imposto = taxa;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	public Double getPagamenTotal() {
		return getPagamentoBasico() + getImposto();
	}
	
	
}
