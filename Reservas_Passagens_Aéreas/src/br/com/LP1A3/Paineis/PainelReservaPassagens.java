package br.com.LP1A3.Paineis;

import javax.swing.*;
import java.awt.event.*;

public class PainelReservaPassagens extends InterfacePainelGeral implements ActionListener {
	JButton btFazerReserva, btLugaresVazios, btReservasRealizadas, btVoltar;
	
	@Override
	public void setInterface() {
		frame.setTitle("Reserva de Passagens");

		btFazerReserva = new JButton("Fazer reserva");
		btLugaresVazios = new JButton("Consultar lugares vazios");
		btReservasRealizadas = new JButton("Consultar reservas realizadas");
		btVoltar = new JButton("Voltar");

		btFazerReserva.setBounds(25,75,350,50);
		btLugaresVazios.setBounds(25,150,350,50);
		btReservasRealizadas.setBounds(25,225,350,50);
		btVoltar.setBounds(50,300,300,50);
		
		btFazerReserva.addActionListener(this);
		btLugaresVazios.addActionListener(this);
		btReservasRealizadas.addActionListener(this);
		btVoltar.addActionListener(this);
		
		frame.add(btFazerReserva);
		frame.add(btLugaresVazios);
		frame.add(btReservasRealizadas);
		frame.add(btVoltar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btFazerReserva) {
			System.out.println("teste fazer reserva");
		}
		
		if (e.getSource() == btLugaresVazios) {
			System.out.println("teste lugares vazios");
		}
		
		if (e.getSource() == btReservasRealizadas) {
			System.out.println("teste reservas realizadas");
		}
		
		if (e.getSource() == btVoltar) {
			limpaFrame();
			PainelMenuPrincipal menu = new PainelMenuPrincipal();
			menu.setInterface();
		}
	}
}
