package br.com.LP1A3.Paineis;

import javax.swing.*;

import java.awt.Color;

import br.com.LP1A3.src.Aviao;
import br.com.LP1A3.src.Main;
import br.com.LP1A3.src.Passageiro;
import br.com.LP1A3.src.Voo;

import java.awt.event.*;

public class PainelConsultaLugares extends InterfacePainelGeral implements ActionListener {
	JButton submit;
	JTextField numeroVooField;
	Voo voo = null;
	Aviao aviaoVoo = null;
	Passageiro passageiro = null;
	Main main = new Main();
	
	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Consultar assentos disponíveis e indisponíveis");

		JLabel numeroVoo = new JLabel("Número do Voo");

		numeroVooField = new JTextField();

		submit = new JButton("Verificar assentos");
		
		numeroVoo.setBounds(25,10,325,25);
		numeroVooField.setBounds(25,40,325,25);
		submit.setBounds(25,280,325,50);
		
		numeroVooField.addActionListener(this);
		submit.addActionListener(this);
		
		frame.add(numeroVoo);
		frame.add(numeroVooField);
		frame.add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			int numeroVoo = 0;
			
			try {
				numeroVoo = Integer.parseInt(numeroVooField.getText());
				voo = main.getVoo(numeroVoo);
			} catch (Exception eVoo) {
				System.out.println("Voo invalido: " + eVoo.getMessage());
				return;
			}
			
			aviaoVoo = voo.getAviao();
			int fileirasAviao = aviaoVoo.getFileiras();
			int assentosAviao = aviaoVoo.getAssentosPorFileira();
			
			limpaFrame();
			frame.setBounds(200,200,1400,800);
			
			int i = 0;
			int j = 0;
			for (i = 0; i < fileirasAviao; i++) {
				for (j = 0; j < assentosAviao; j++) {
					JLabel assento = new JLabel(Integer.toString(i+1)+ ", " + Integer.toString(j+1), SwingConstants.CENTER);
					assento.setBounds(105*(j+1),35*(i+1),100,30);
					assento.setOpaque(true);
					if (aviaoVoo.verificaLugarOcupado(i+1, j+1)) {
						assento.setBackground(Color.GREEN);
					} else {
						assento.setBackground(Color.RED);
					}
					frame.add(assento);
				}
			}
			
			JButton voltar = new JButton("Voltar");
			voltar.setBounds(105,35*(i+1), 105*j, 50);
			voltar.addActionListener(this);
			frame.add(voltar);
		} else {
			frame.setBounds(200,200,400,400);
			PainelReservaPassagens painelReservas = new PainelReservaPassagens();
			painelReservas.setInterface();
		}
	}
}
