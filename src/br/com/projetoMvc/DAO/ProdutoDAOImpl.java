package br.com.projetoMvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoMvc.model.Produto;
import br.com.projetoMvc.util.ConnenctionFactory;

public class ProdutoDAOImpl implements GenericDAO {

	private Connection conn;

	public ProdutoDAOImpl() throws Exception {
		try {
			this.conn = ConnenctionFactory.getConnection();
			System.out.println("Conectado com sucesso!");
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Object> listarTodos() {
		List<Object> lista = new ArrayList<Object>();
		PreparedStatement stmt = null; //classe respondavel por ir no banco  e executar a sql
		ResultSet rs = null;
		String sql = "SELECT * FROM produto ORDER BY descricao";

		try {
			stmt = conn.prepareStatement(sql);//prepareStatement  prepara o conteudo para ser executado no banco;
			rs = stmt.executeQuery();//executa o comando dentro so banco de dados.
			while (rs.next()) { // resultset  armazena o valor do banco dentro desta variavel e retorna.
				Produto produto = new Produto();//construtor vazio
				produto.setId(rs.getInt("id"));// pegando o valor do banco e  jogando dentro da varialve id.
				produto.setDescricao(rs.getString("descricao"));
				lista.add(produto); //busco os produtos do banco e adcicionando p produto na lista produto do java.
			}
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Produto! Erro: " + ex.getMessage());
			ex.printStackTrace();
		} finally { // utilizando para fechar a conexao com o banco. sempre que abro a conexao devo fechar em seguida.
			try {
				ConnenctionFactory.closeConnetion(conn, stmt, rs);
			} catch (Exception ex) {
				System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
			}
		}
		
		return lista;
	}

	@Override
	public Object listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cadastrar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alterar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub

	}

}
