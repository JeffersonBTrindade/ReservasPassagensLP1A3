package br.com.LP1A3.Paineis;

import javax.swing.*;

import java.awt.event.*;

public class PainelConsultaReservas extends InterfacePainelGeral implements ActionListener {
	
	JButton submit;
	JTextField nomePassageiroField, cpfPassageiroField, posicaoDoPassageiroField;
	
	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Consultar Reservas");

		JLabel nomePassageiro = new JLabel("Nome do passageiro:");
		JLabel cpfPassageiro = new JLabel("CPF do passageiro:");
		JLabel posicaoPassageiro = new JLabel("Qual a posi��o do passageiro na aeronave:");

		nomePassageiroField = new JTextField();
		cpfPassageiroField = new JTextField();
		posicaoDoPassageiroField = new JTextField();
		
		submit = new JButton("Registrar este passageiro");
		
		nomePassageiro.setBounds(25,20,325,25);
		nomePassageiroField.setBounds(25,50,325,25);
		cpfPassageiro.setBounds(25,105,325,25);
		cpfPassageiroField.setBounds(25,135,325,25);
		posicaoPassageiro.setBounds(25,190,325,25);
		posicaoDoPassageiroField.setBounds(25,220,325,25);
		submit.setBounds(25,280,325,50);
		
		nomePassageiroField.addActionListener(this);
		cpfPassageiroField.addActionListener(this);
		posicaoDoPassageiroField.addActionListener(this);
		submit.addActionListener(this);
		
		frame.add(nomePassageiro);
		frame.add(nomePassageiroField);
		frame.add(cpfPassageiro);
		frame.add(cpfPassageiroField);
		frame.add(posicaoPassageiro);
		frame.add(posicaoDoPassageiroField);
		frame.add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			PainelReservaPassagens reserva = new PainelReservaPassagens();
			reserva.setInterface();
		}
	}
}
