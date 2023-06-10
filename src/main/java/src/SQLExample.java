package src;

import java.sql.*;

public class SQLExample {
    
    public static void main(String[] args) {
        // Informações de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/nome_do_seu_db"; // URL do banco de dados
        String username = "root"; // Nome de usuário do banco de dados
        String password = "12345"; // Senha do banco de dados

        String sql = "select * from poluicaoglobal where ï»¿Country ='Brazil'";

        try {
            // Estabelecer conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, username, password);

            // Criar uma declaração
            Statement statement = connection.createStatement();

            // Executar a consulta SQL e obter o resultado
            ResultSet resultSet = statement.executeQuery(sql);

            // Processar os resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

