package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {

		ProdutoController controller = new ProdutoController();

		Produto novoProduto = new Produto(); //metodo utilizado para cadastrar u novo produto.
		novoProduto.setDescricao(JOptionPane.showInputDialog("Descrição do Produto "));
		controller.cadastrar(novoProduto);

		Scanner scan = new Scanner(System.in);

		List<Produto> lista = new ArrayList<Produto>();

		lista = controller.listarTodos();

		String mensagemLista = "".concat("-Lista de Produtos-").concat("\n Cód.  Descrição");

		for (Produto produto : lista) {
			mensagemLista = mensagemLista.concat("\n    ").concat(String.valueOf(produto.getId())).concat("      ")
					.concat(produto.getDescricao());
		}

		JOptionPane.showMessageDialog(null, mensagemLista);

	}

}
