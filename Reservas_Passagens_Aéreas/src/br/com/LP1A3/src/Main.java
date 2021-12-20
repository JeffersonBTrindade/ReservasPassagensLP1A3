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
	
	public void setVooInIndex(Voo voo, int index) {
		voos[index] = voo;
	}
	
	public Voo[] getVoos() {
		return voos;
	}
	
	public Voo getVoo(int nro) {
		for (Voo voo : voos) {
			if (voo.getNro() == nro) {
				return voo;
			}
		}
		
		throw new IndexOutOfBoundsException();
	}
	
	public int getIndexVoo(int nro) {
		for (int i = 0; i < voos.length; i++) {
			if (voos[i].getNro() == nro) {
				return i;
			}
		}
		
		return -1;
	}
}
