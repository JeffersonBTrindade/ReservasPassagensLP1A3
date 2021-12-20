package br.com.LP1A3.Paineis;

import javax.swing.*;

import br.com.LP1A3.src.Main;
import br.com.LP1A3.src.Store;
import br.com.LP1A3.src.Voo;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class PainelCadastroVoo extends InterfacePainelGeral implements ActionListener {
	
	JButton submit;
	JTextField modeloField, numeroField, dataField, horaField;
	
	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Cadastro de Voo");

		JLabel modeloAviao = new JLabel("Número do modelo do Avião (ex: 1):");
		JLabel numero = new JLabel("Número do voo:");
		JLabel data = new JLabel("Data do voo (formato: dd/MM/yyyy):");
		JLabel hora = new JLabel("Hora do voo: (ex: 12:00)");

		modeloField = new JTextField();
		numeroField = new JTextField();
		dataField = new JTextField();
		horaField = new JTextField();

		submit = new JButton("Cadastrar");
		
		modeloAviao.setBounds(25,10,325,25);
		modeloField.setBounds(25,45,325,25);
		numero.setBounds(25,80,325,25);
		numeroField.setBounds(25,115,325,25);
		data.setBounds(25,150,325,25);
		dataField.setBounds(25,185,325,25);
		hora.setBounds(25,220,325,25);
		horaField.setBounds(25,255,325,25);
		
		submit.setBounds(25,295,325,50);
		
		modeloField.addActionListener(this);
		numeroField.addActionListener(this);
		dataField.addActionListener(this);
		horaField.addActionListener(this);
		submit.addActionListener(this);
		
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
			Store aviao = new Store();
			
			int modelo = 0;
			int numero = 0;
			String dataValida = null;
			String hora = null;
			
			try {
				modelo = Integer.parseInt(modeloField.getText());
			} catch (Exception eModelo) {
				System.out.println("Erro ao inserir modelo: " + eModelo.getMessage());
				return;
			}
		
			try {
				numero = Integer.parseInt(numeroField.getText());
			} catch (Exception eNumero) {
				System.out.println("Erro ao inserir número do avião: " + eNumero.getMessage());
				return;
			}
	
			try {
				DateTimeFormatter dataFormater = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
				dataValida = LocalDate.parse(dataField.getText(), dataFormater).toString();
			} catch (Exception eData) {
				System.out.println("Erro ao inserir data: " + eData.getMessage());
				return;
			}

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				sdf.setLenient(false);
				hora = sdf.parse(horaField.getText()).toString();
			} catch (Exception eHora) {
				System.out.println("Erro ao inserir hora: " + eHora.getMessage());
				return;
			}
					
			Voo voo = new Voo(aviao.getAviao(modelo), numero, dataValida, hora);
			
			main.setVoo(voo);
			
			PainelParametrosSistema parametro = new PainelParametrosSistema();
			parametro.setInterface();
		}
	}
}
