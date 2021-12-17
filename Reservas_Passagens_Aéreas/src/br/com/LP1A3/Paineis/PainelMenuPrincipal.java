package br.com.LP1A3.Paineis;

import javax.swing.*;

import br.com.LP1A3.src.Main;

import java.awt.event.*;

public class PainelMenuPrincipal extends InterfacePainelGeral {
	JButton btParametros, btReservas, btSair;
	Main main = new Main();

	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Menu Principal");

		btParametros = new JButton("Parametros do Sistema");
		btReservas = new JButton("Reserva de Passagens");
		btSair = new JButton("Sair");
		btParametros.setBounds(25,100,350,50);
		btReservas.setBounds(25,175,350,50);
		btSair.setBounds(50,250,300,50);
		
		btParametros.addActionListener(main);
		btReservas.addActionListener(main);
		btSair.addActionListener(main);
				
		frame.add(btParametros);
		frame.add(btReservas);
		frame.add(btSair);
	}  
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btParametros) {
			System.out.println(e.getSource().getClass().getName());
			PainelParametrosSistema parametrosSistema = new PainelParametrosSistema();
			parametrosSistema.setInterface();
		}
		
		if (e.getSource() == btReservas) {
			limpaFrame();
			PainelReservaPassagens reservaPassagens = new PainelReservaPassagens();
			reservaPassagens.setInterface();
		}
		
		if (e.getSource() == btSair) {
			frame.dispose();
			return;
		}*/
		
	
}
