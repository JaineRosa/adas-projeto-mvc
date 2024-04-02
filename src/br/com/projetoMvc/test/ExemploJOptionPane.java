package br.com.projetoMvc.test;

import javax.swing.JOptionPane;

public class ExemploJOptionPane {

	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite seu nome ");
		JOptionPane.showMessageDialog(null, "Nome digitado: "  + nome);
				
		String menu= "Menu do sistema"+
				"\n [1] Cadastrar" + 
				"\n [2] Listar todos" +
				"\n\n Escolha uma opção!";
		
		// exemplo de conversao de dados, convertendo de string para integer.
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		JOptionPane.showMessageDialog(null, opcao);
	}

}
