package br.com.LP1A3.Paineis;

import javax.swing.*;

import br.com.LP1A3.src.Main;
import br.com.LP1A3.src.Store;
import br.com.LP1A3.src.Voo;

import java.awt.event.*;

public class PainelCadastroVoo extends InterfacePainelGeral implements ActionListener {
	
	JButton submit;
	JTextField modeloField, numeroField, dataField, horaField;
	
	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Cadastro de Voo");

		JLabel aviao = new JLabel("Avi�o:");
		JLabel modeloAviao = new JLabel("N�mero do modelo (ex: 1):");
		JLabel numero = new JLabel("N�mero do voo:");
		JLabel data = new JLabel("Data:");
		JLabel hora = new JLabel("Hora:");

		modeloField = new JTextField();
		numeroField = new JTextField();
		dataField = new JTextField();
		horaField = new JTextField();

		submit = new JButton("Cadastrar");
		
		aviao.setBounds(25,10,325,25);
		modeloAviao.setBounds(25,45,325,25);
		modeloField.setBounds(25,80,325,25);
		numero.setBounds(25,125,325,25);
		numeroField.setBounds(25,170,325,25);
		data.setBounds(25,215,325,25);
		dataField.setBounds(25,260,325,25);
		hora.setBounds(25,305,325,25);
		horaField.setBounds(25,350,325,25);
		submit.setBounds(25,395,325,50);
		
		modeloField.addActionListener(this);
		numeroField.addActionListener(this);
		dataField.addActionListener(this);
		horaField.addActionListener(this);
		submit.addActionListener(this);
		
		frame.add(aviao);
		frame.add(modeloAviao);
		frame.add(modeloField);
		frame.add(numero);
		frame.add(numeroField);
		frame.add(data);
		frame.add(dataField);
		frame.add(hora);
		frame.add(horaField);
		frame.add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			Main main = new Main();
			int modelo = Integer.parseInt(modeloField.getText());
			int numero = Integer.parseInt(numeroField.getText());
			String data = dataField.getText();
			String hora = horaField.getText();
			
			Store aviao = new Store();
			
			Voo voo = new Voo(aviao.getAviao(modelo), numero, data, hora);
			
			main.setVoo(voo);
		}
	}
}
