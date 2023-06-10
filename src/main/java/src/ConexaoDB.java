package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConexaoDB {
    public Connection CriaConexaoMysql() throws Exception {
        String url = "jdbc:mysql://localhost:3306/nome_do_seu_db";
        String user = "root";
        String password = "12345";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public List<String> getAllCities() {
    List<String> cities = new ArrayList<>();
    String sql = "SELECT DISTINCT city FROM poluicaoglobal WHERE ï»¿Country = 'Brazil'";

    try (Connection conn = CriaConexaoMysql();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String city = rs.getString("city");
            cities.add(city);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return cities;
}

    public void Input(String cidade) {
        String sql = "SELECT * FROM poluicaoglobal WHERE ï»¿Country = 'Brazil' AND city LIKE '%" + cidade + "%'";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = CriaConexaoMysql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                System.out.println("Cidade: " + rset.getString("city"));
                System.out.println("Valor do índice de qualidade do ar: " + rset.getInt("AQI Value"));
                System.out.println("Categoria de qualidade do ar: " + rset.getString("AQI Category"));
                System.out.println("Valor do índice de qualidade do ar de CO: " + rset.getInt("CO AQI Value"));
                System.out.println("Categoria de qualidade do ar de CO: " + rset.getString("CO AQI Category"));
                System.out.println("Valor da qualidade do ar de ozonio: " + rset.getInt("Ozone AQI Value"));
                System.out.println("Categoria de qualidade do ar de ozonio: " + rset.getString("Ozone AQI Category"));
                System.out.println("Valor da qualidade do ar de NO2: " + rset.getInt("NO2 AQI Value"));
                System.out.println("Categoria da qualidade do ar de NO2: " + rset.getString("NO2 AQI Category"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
    }
}
