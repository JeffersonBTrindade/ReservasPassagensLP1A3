package br.com.LP1A3.Paineis;

import javax.naming.InvalidNameException;
import javax.swing.*;

import br.com.LP1A3.src.Aviao;
import br.com.LP1A3.src.Main;
import br.com.LP1A3.src.Passageiro;
import br.com.LP1A3.src.Voo;

import java.awt.event.*;

public class PainelFazerReserva extends InterfacePainelGeral implements ActionListener {
	
	JButton submit;
	JTextField nomePassageiroField, cpfPassageiroField, numeroVooField;
	Voo voo = null;
	Aviao aviaoVoo = null;
	Passageiro passageiro = null;
	Main main = new Main();
	
	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Fazer Reserva");

		JLabel numeroVoo = new JLabel("Número do Voo");
		JLabel nomePassageiro = new JLabel("Nome do passageiro:");
		JLabel cpfPassageiro = new JLabel("CPF do passageiro:");

		numeroVooField = new JTextField();
		nomePassageiroField = new JTextField();
		cpfPassageiroField = new JTextField();
		
		submit = new JButton("Selecionar o assento");
		
		numeroVoo.setBounds(25,10,325,25);
		numeroVooField.setBounds(25,40,325,25);
		nomePassageiro.setBounds(25,80,325,25);
		nomePassageiroField.setBounds(25,110,325,25);
		cpfPassageiro.setBounds(25,150,325,25);
		cpfPassageiroField.setBounds(25,180,325,25);
		submit.setBounds(25,280,325,50);
		
		numeroVooField.addActionListener(this);
		nomePassageiroField.addActionListener(this);
		cpfPassageiroField.addActionListener(this);
		submit.addActionListener(this);
		
		frame.add(numeroVoo);
		frame.add(numeroVooField);
		frame.add(nomePassageiro);
		frame.add(nomePassageiroField);
		frame.add(cpfPassageiro);
		frame.add(cpfPassageiroField);
		frame.add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			int numeroVoo = 0;
			String nome = null;
			String cpf = cpfPassageiroField.getText();
			
			try {
				numeroVoo = Integer.parseInt(numeroVooField.getText());
				voo = main.getVoo(numeroVoo);
			} catch (Exception eVoo) {
				System.out.println("Voo invalido: " + eVoo.getMessage());
				return;
			}
			
			try {
				nome = nomePassageiroField.getText();
				for (int i = 0; i < nome.length(); i++) {
					if (!Character.isAlphabetic(nome.charAt(i))) {
						throw new InvalidNameException();
					}
				}
			} catch (Exception eNome) {
				System.out.println("Nome inválido: " + eNome.getMessage());
				return;
			}
			
			passageiro = new Passageiro(nome, cpf);
			
			aviaoVoo = voo.getAviao();
			int fileirasAviao = aviaoVoo.getFileiras();
			int assentosAviao = aviaoVoo.getAssentosPorFileira();
			
			limpaFrame();
			frame.setBounds(200,200,1400,800);
			for (int i = 0; i < fileirasAviao; i++) {
				for (int j = 0; j < assentosAviao; j++) {
					if (aviaoVoo.verificaLugarOcupado(i+1, j+1)) {
						JButton assento = new JButton(Integer.toString(i+1)+ ", " + Integer.toString(j+1));
						assento.setBounds(105*(j+1),35*(i+1),100,30);
						assento.addActionListener(this);
						frame.add(assento);
					}
				}
			}
		} 
		
		else {
			JButton assentoSelecionado = (JButton) e.getSource();
			
			String[] parts = assentoSelecionado.getText().split(", ");
			
			int fileira = Integer.parseInt(parts[0]);
			int assento = Integer.parseInt(parts[1]);
			
			aviaoVoo.setPassageiro(fileira, assento, passageiro);
			
			Voo vooCadastrado = new Voo(aviaoVoo, voo.getNro(), voo.getData(), voo.getHora());
			main.setVooInIndex(vooCadastrado, main.getIndexVoo(voo.getNro()));
			
			frame.setBounds(200,200,400,400);
			PainelReservaPassagens painelReservas = new PainelReservaPassagens();
			painelReservas.setInterface();
		}
	}
}
