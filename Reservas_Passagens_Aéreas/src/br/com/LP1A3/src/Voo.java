package br.com.LP1A3.src;

public class Voo {

	private Aviao aviao;
	private int nro;
	private String data;
	private String hora;
	
	public Voo(Aviao aviao, int nro, String data, String hora) {
		this.aviao = aviao;
		this.nro = nro;
		this.data = data;
		this.hora = hora;
	}

	public int getNro() {
		return nro;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}
	
	public Aviao getAviao() {
		return aviao;
	}
}
