package br.com.LP1A3.src;

import br.com.LP1A3.Paineis.PainelMenuPrincipal;

public class Main {
	static Voo[] voos = new Voo[10];
	
	public static void main(String[] args) {
		PainelMenuPrincipal menu = new PainelMenuPrincipal();
		menu.setInterface();
		
	}
	
	public void setVoo(Voo voo) {
		for (int i = 0; i < voos.length; i++) {
			if (voos[i] == null) {
				voos[i] = voo;
				return;
			}
		}
	}
}
