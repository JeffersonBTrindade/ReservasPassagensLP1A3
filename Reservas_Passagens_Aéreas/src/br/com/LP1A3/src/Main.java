package br.com.LP1A3.src;

import br.com.LP1A3.Paineis.PainelMenuPrincipal;
import br.com.LP1A3.Paineis.PainelParametrosSistema;

import java.awt.event.*;

import javax.swing.JButton;

public class Main implements ActionListener {
	Voo[] voos = new Voo[10];
	
	public static void main(String[] args) {
		PainelMenuPrincipal menu = new PainelMenuPrincipal();
		menu.setInterface();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = null;
		if (e.getSource().getClass().getName() == "javax.swing.JButton") {
			button = (JButton) e.getSource();
		}
		
		if (button == null) {
			return;
		}
		
		if (button.getText() == "Parametros do Sistema") {
			PainelParametrosSistema parametrosSistema = new PainelParametrosSistema();
			parametrosSistema.setInterface();
		}
		
		if (button.getText() == "Reserva de Passagens") {
			PainelParametrosSistema parametrosSistema = new PainelParametrosSistema();
			parametrosSistema.setInterface();
		}
		
		if (button.getText() == "Sair") {
			System.exit(0);
		}
		
	}

	
}
