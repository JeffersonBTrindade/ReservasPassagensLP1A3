package br.com.LP1A3.src;

public class Store {
	static Aviao[] avioes = new Aviao[10];
	
	public void setAviao(Aviao aviao) {
		for (int i = 0; i < avioes.length; i++) {
			if (avioes[i] == null) {
				avioes[i] = aviao;
				return;
			}
		}
	}
	
	public Aviao getAviao(int index) {
		return avioes[index-1];
	}
	
	public Aviao[] getAvioes() {
		return avioes;
	}
}
