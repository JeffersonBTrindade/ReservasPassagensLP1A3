package br.com.LP1A3.Paineis;

import javax.swing.JFrame;

public abstract class InterfacePainelGeral {
	static JFrame frame = null;
	
	public InterfacePainelGeral() {
		if (frame == null) {
			frame = new JFrame();
			frame.setBounds(200,200,400,400);
			frame.getContentPane().setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}
	
	abstract void setInterface();
	
	protected void limpaFrame() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}
}
