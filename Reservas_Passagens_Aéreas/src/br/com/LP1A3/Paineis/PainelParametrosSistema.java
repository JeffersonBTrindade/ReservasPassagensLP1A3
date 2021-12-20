package br.com.LP1A3.Paineis;

import javax.swing.*;

import br.com.LP1A3.src.Store;

import java.awt.event.*;

public class PainelParametrosSistema extends InterfacePainelGeral implements ActionListener {
	JButton btCadastrarAeronave, btCadastrarVoo, btVoltar;

	@Override
	public void setInterface() {
		limpaFrame();
		frame.setTitle("Parâmetros do Sistema");

		btCadastrarAeronave = new JButton("Cadastrar Aeronave");
		btCadastrarVoo = new JButton("Cadastrar Voo");
		btVoltar = new JButton("Voltar");
		btCadastrarAeronave.setBounds(25,100,350,50);
		btCadastrarVoo.setBounds(25,175,350,50);
		btVoltar.setBounds(50,250,300,50);

		btCadastrarAeronave.addActionListener(this);
		btCadastrarVoo.addActionListener(this);
		btVoltar.addActionListener(this);
		
		frame.add(btCadastrarAeronave);
		frame.add(btCadastrarVoo);
		frame.add(btVoltar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btCadastrarAeronave) {
			Store store = new Store();
			if (store.getAviao(10) != null) {
				System.out.println("Foi atingido o limite de aviões suportados para cadastro.");
				return;
			}
			PainelCadastroAvião aviao = new PainelCadastroAvião();
			aviao.setInterface();
		}
		
		if (e.getSource() == btCadastrarVoo) {
			Store store = new Store();
			if (store.getAvioes()[0] == null) {
				System.out.println("Não tem avioes cadastrados");
				return;
			}
			PainelCadastroVoo voo = new PainelCadastroVoo();
			voo.setInterface();
		}
		
		if (e.getSource() == btVoltar) {
			PainelMenuPrincipal menu = new PainelMenuPrincipal();
			menu.setInterface();
		}
	}
}
