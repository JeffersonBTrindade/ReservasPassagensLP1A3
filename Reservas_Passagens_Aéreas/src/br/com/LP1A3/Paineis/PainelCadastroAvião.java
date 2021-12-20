package br.com.LP1A3.Paineis;

import javax.swing.*;

import br.com.LP1A3.src.Aviao;
import br.com.LP1A3.src.Store;

import java.awt.event.*;

public class PainelCadastroAvião extends InterfacePainelGeral implements ActionListener {
	
	JButton submit;
	JTextField modeloField, fileiraField, assentosField;
	
	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Cadastro de Avião");

		JLabel modelo = new JLabel("Modelo:");
		JLabel fileira = new JLabel("Quantidade de fileiras:");
		JLabel assentos = new JLabel("Quantidade de assentos por fileira:");

		modeloField = new JTextField();
		fileiraField = new JTextField();
		assentosField = new JTextField();
		
		submit = new JButton("Cadastrar");
		
		modelo.setBounds(25,20,325,25);
		modeloField.setBounds(25,50,325,25);
		fileira.setBounds(25,105,325,25);
		fileiraField.setBounds(25,135,325,25);
		assentos.setBounds(25,190,325,25);
		assentosField.setBounds(25,220,325,25);
		submit.setBounds(25,280,325,50);
		
		modeloField.addActionListener(this);
		fileiraField.addActionListener(this);
		assentosField.addActionListener(this);
		submit.addActionListener(this);
		
		frame.add(modelo);
		frame.add(modeloField);
		frame.add(fileira);
		frame.add(fileiraField);
		frame.add(assentos);
		frame.add(assentosField);
		frame.add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {			
			int fileiraContent = 0;
			int assentosContent = 0;
			String modeloContent = modeloField.getText();
			
			try {
				fileiraContent = Integer.parseInt(fileiraField.getText());
				if (fileiraContent < 1) {
					System.out.println("O valor deve ser positivo");
					return;
				}
			} catch (Exception eFileira) {
				System.out.println("Erro ao inserir fileiras: " + eFileira.getMessage());
				return;
			}
			
			try {
				assentosContent = Integer.parseInt(assentosField.getText());
				if (assentosContent < 1) {
					System.out.println("O valor deve ser positivo");
					return;
				}
			} catch (Exception eAssentos) {
				System.out.println("Erro ao inserir assentos: " + eAssentos.getMessage());
				return;
			}
			
			Aviao aviao = new Aviao(modeloContent, fileiraContent, assentosContent);
			Store store = new Store();
			store.setAviao(aviao);
			
			PainelParametrosSistema parametro = new PainelParametrosSistema();
			parametro.setInterface();
		}
	}
}
