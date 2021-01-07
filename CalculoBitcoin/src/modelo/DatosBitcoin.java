package modelo;

import java.text.DecimalFormat;

public class DatosBitcoin {
	
	private float valorActual;
	private float valorComprado;
	private float cantidadComprado;
	private float cantidadCompradoBitcoin;
	private float gananciaNeta;
	private float porcentajeRetorno;
	private float cantidadActual;

	
	//Constructores
	public DatosBitcoin() {}
	
	public DatosBitcoin(float valorActual, float valorComprado, float cantidadComprado, float ganaciaNeta ) {
		this.valorActual = valorActual;
		this.valorComprado = valorComprado;
		this.cantidadComprado = cantidadComprado;
		this.gananciaNeta = ganaciaNeta;
	}

	public float getValorActual() {
		return valorActual;
	}

	public void setValorActual(float valorActual) {
		this.valorActual = valorActual;
	}

	public float getValorComprado() {
		return valorComprado;
	}

	public void setValorComprado(float valorComprado) {
		this.valorComprado = valorComprado;
	}

	public float getCantidadComprado() {
		return cantidadComprado;
	}

	public void setCantidadComprado(float cantidadComprado) {
		this.cantidadComprado = cantidadComprado;
	}

	public float getGananciaNeta() {
		return gananciaNeta;
	}

	public void setGananciaNeta(float gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}
	
	public float getPorcentajeRetorno() {
		return porcentajeRetorno;
	}

	public void setPorcentajeRetorno(float porcentajeRetorno) {
		this.porcentajeRetorno = porcentajeRetorno;
	}

	public float getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(float cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	
	public float getCantidadCompradoBitcoin() {
		return cantidadCompradoBitcoin;
	}

	public void setCantidadCompradoBitcoin(float cantidadCompradoBitcoin) {
		this.cantidadCompradoBitcoin = cantidadCompradoBitcoin;
	}

	
	//Calcula las ganacias netas
	public float calcularGananciasNetas() {
		
		this.cantidadCompradoBitcoin = (this.cantidadComprado * 1) / this.valorComprado ; //Regla de 3 que convierte la cantidad en dolares a cantidad en bitcoin
		this.cantidadActual = ((this.valorActual * this.cantidadCompradoBitcoin) / 1); /*Regla de 3 que calcula la cantidad actual en dolares(Si invirtio 50 dolares, 
																						 esos 50 dolares valdran menos o mas dependiendo del precio actual del bitcoin)
																						*/
		this.gananciaNeta = this.cantidadActual - this.cantidadComprado;/*Se resta las cantidades para obtener la ganacia neta EJ:
		 																(Se invirtio 50$, el bitcoin subio y ahora esa cantidad vale 58
		 																entonces se resta 58-50 y se obtiene 8 dolare de ganancia)						*/
				
		return this.gananciaNeta; //La ganancia neta es retornada para ser mostrada por pantalla
	}
	
	public float calcularPorcentajeRetorno() {
		
		this.porcentajeRetorno = (100 * this.gananciaNeta) / this.cantidadComprado;
		
		return porcentajeRetorno;//Retorna el retorno de la inversion
	
	}

	@Override
	public String toString() {
		return "DatosBitcoin [valorActual=" + valorActual + ", valorComprado=" + valorComprado + ", cantidadComprado="
				+ cantidadComprado + ", gananciaNeta=" + gananciaNeta + "]";
	}
}
