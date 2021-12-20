package br.com.LP1A3.Paineis;

import javax.swing.*;

import java.awt.event.*;

public class PainelReservaPassagens extends InterfacePainelGeral implements ActionListener {
	JButton btFazerReserva, btLugaresVazios, btReservasRealizadas, btVoltar;
	
	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Reserva de Passagens");

		btFazerReserva = new JButton("Fazer reserva");
		btLugaresVazios = new JButton("Consultar lugares");
		btVoltar = new JButton("Voltar");

		btFazerReserva.setBounds(25,25,350,50);
		btLugaresVazios.setBounds(25,100,350,50);
		btVoltar.setBounds(50,175,300,50);
		
		btFazerReserva.addActionListener(this);
		btLugaresVazios.addActionListener(this);
		btVoltar.addActionListener(this);
		
		frame.add(btFazerReserva);
		frame.add(btLugaresVazios);
		frame.add(btVoltar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btFazerReserva) {
			PainelFazerReserva fazerReserva = new PainelFazerReserva();
			fazerReserva.setInterface();
		}
		
		if (e.getSource() == btLugaresVazios) {
			PainelConsultaLugares consulta = new PainelConsultaLugares();
			consulta.setInterface();
		}
		
		if (e.getSource() == btVoltar) {
			limpaFrame();
			PainelMenuPrincipal menu = new PainelMenuPrincipal();
			menu.setInterface();
		}
	}
}
