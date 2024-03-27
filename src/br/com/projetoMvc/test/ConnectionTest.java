package br.com.projetoMvc.test;

import java.sql.Connection;

import br.com.projetoMvc.util.ConnenctionFactory;

public class ConnectionTest {

	public static void main(String[] args) {
		
		
	
		
		try {
			Connection connection = ConnenctionFactory.getConnection();
			
			if(connection != null) {
				System.out.println("Conexão estabelecida com sucesso!");
			}
			
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao conectar: "+ e.getMessage());
			e.printStackTrace();
		}
		
	}

}
