package br.com.projetoMvc;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.projetoMvc.DAO.GenericDAO;
import br.com.projetoMvc.DAO.ProdutoDAOImpl;
import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		ProdutoController controller = new ProdutoController();
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
				//JOptionPane.showMessageDialog(null, "listar todos!");
				
				List<Produto> lista = new ArrayList<Produto>();
				lista = controller.listarTodos();
				
				if (lista.size() > 0) {
					String mensagemLista = ""
							.concat("-Lista de Produtos-")
							.concat("\n Cód.  Descrição");

					for (Produto produto : lista) {
						mensagemLista = mensagemLista
								.concat("\n    ")
								.concat(String.valueOf(produto.getId()))
								.concat("      ")
								.concat(produto.getDescricao());
					} 
					JOptionPane.showMessageDialog(null, mensagemLista);
				} else {
					JOptionPane.showMessageDialog(null, "Não existem produtos cadastrados!");
				}
				break;
			}

			case 2: {
				//JOptionPane.showMessageDialog(null, "Listar por ID!");
				int idListar = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id: "));
				
			Produto produtoEncontrado = (Produto)controller.listarPorId(idListar);
			
					if (produtoEncontrado != null) {
						JOptionPane.showMessageDialog(null, "Produto encontrado: " + produtoEncontrado.getDescricao() );
						} else {
						JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para o ID: " + idListar);
						}
				break;
			}
			case 3: {
				//JOptionPane.showMessageDialog(null, "Cadastrar!");
				Produto novoProduto = new Produto(); // metodo utilizado para cadastrar um novo produto.
				novoProduto.setDescricao(JOptionPane.showInputDialog("Descrição do Produto "));
				controller.cadastrar(novoProduto);
				break;
			}
			
			case 4: {
				//JOptionPane.showMessageDialog(null, "Alterar!");
				Produto alterarProduto = new Produto();
				int idAlterar = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id do produto a ser alterado: "));
				alterarProduto.setDescricao(JOptionPane.showInputDialog("Informe a nova descrição do Produto: "));		
				alterarProduto.setId(idAlterar);
				controller.alterar(alterarProduto);
				break;
			}
			
			case 5: {
				//JOptionPane.showMessageDialog(null, "excluir!");			
				int idExcluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id para excluir: "));
				if (controller.excluir(idExcluir) ) {
				JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
				}else {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir produto com id: " + idExcluir);
				}
				break;
			}

			default:
				JOptionPane.showMessageDialog(null, "opção inválida!");
			}
		} while (opcao >= 1 && opcao <= 5);
	}
}
