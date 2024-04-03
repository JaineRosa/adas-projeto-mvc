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

		int opcao = 0;

		do {

			String menu = "Menu do sistema"
					.concat("\n [1] Listar todos")
					.concat("\n [2] Listar por ID")
					.concat("\n [3] Cadastrar")
					.concat("\n [4] Alterar")
					.concat("\n [5] Excluir")
					.concat("\n [0] Sair")
					.concat("\n\n Escolha uma opção!");

			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcao) {

			case 0: {
				JOptionPane.showMessageDialog(null, "Saindo do Menu...!");
				break;
			}

			case 1: {
				JOptionPane.showMessageDialog(null, "Listar Todos!");
				ProdutoController controller = new ProdutoController();
				List<Produto> lista = new ArrayList<Produto>();

				lista = controller.listarTodos();

				String mensagemLista = "".concat("-Lista de Produtos-").concat("\n Cód.  Descrição");

				for (Produto produto : lista) {
					mensagemLista = mensagemLista.concat("\n    ").concat(String.valueOf(produto.getId()))
							.concat("      ").concat(produto.getDescricao());
				}

				JOptionPane.showMessageDialog(null, mensagemLista);
				break;
			}

			case 2: {
				JOptionPane.showMessageDialog(null, "Listar por ID!");
				
				break;
			}
			case 3: {
				JOptionPane.showMessageDialog(null, "Cadastrar!");
				ProdutoController controller = new ProdutoController();

				Produto novoProduto = new Produto(); // metodo utilizado para cadastrar u novo produto.
				novoProduto.setDescricao(JOptionPane.showInputDialog("Descrição do Produto "));
				controller.cadastrar(novoProduto);

				break;
			}
			case 4: {
				JOptionPane.showMessageDialog(null, "Alterar!");
				break;
			}
			case 5: {
				JOptionPane.showMessageDialog(null, "Excluir!");
				break;
			}

			default:
				JOptionPane.showMessageDialog(null, "opção inválida!");
			}
		} while (opcao >= 1 && opcao <= 5);
	}
}
