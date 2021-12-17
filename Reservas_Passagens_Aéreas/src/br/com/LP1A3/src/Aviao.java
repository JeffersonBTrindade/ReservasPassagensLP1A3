package br.com.LP1A3.src;

public class Aviao extends Aeronave{

	Passageiro[][] lugares;
	private int fileiras;
	private int assentosPorFileira;
	
	public Aviao(String modelo, int fileiras, int assentosPorFileira) {
		super(modelo);
		this.fileiras = fileiras;
		this.assentosPorFileira = assentosPorFileira;
	}
	
	public boolean verificaLugarOcupado(int x, int y) {
		if(lugares[x][y].getNome().isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	public void setPassageiro(int x, int y, Passageiro passageiro) {
		lugares[x][y] = passageiro;
	}

	public Passageiro getPassageiro(int x, int y) {
		Passageiro passageiro = lugares[x][y];
		return passageiro;
	}
}
