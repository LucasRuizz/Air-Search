package src.Controller.CRUDPesquisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import src.Controller.ConexaoDB;
import src.Controller.ConexaoDB;
import src.Model.DadosCidade;

public class InsertPesquisa {
    ConexaoDB db = new ConexaoDB();
    Connection conn = null;
    PreparedStatement pstm = null;

    public void Insertpesquisa(DadosCidade cidade) {
        String sql = "INSERT INTO poluicaoglobal (`ï»¿Country`, City, `AQI Value`, `AQI Category`, `CO AQI Category`, `CO AQI Value`, `Ozone AQI Value`, `Ozone AQI Category`, `NO2 AQI Value`,`NO2 AQI Category`, `PM2.5 AQI Value`, `PM2.5 AQI Category`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.CriaConexaoMysql();
            pstm = conn.prepareStatement(sql);

            // Configurando os parâmetros da consulta
        pstm.setString(1, cidade.getCountry());
        pstm.setString(2, cidade.getCity());
        pstm.setInt(3, cidade.getAqiValue());
        pstm.setString(4, cidade.getAqiCategory());
        pstm.setString(5, cidade.getCOaqiCategory());
        pstm.setInt(6, cidade.getCOaqiValue());
        pstm.setInt(7, cidade.getOzoneAqiValue());
        pstm.setString(8, cidade.getOzoneAqiCategory());
        pstm.setInt(9, cidade.getNO2aqiValue());
        pstm.setString(10, cidade.getNO2aqiCategory());
        pstm.setInt(11, cidade.getPM25aqiValue());
        pstm.setString(12, cidade.getPM25aqiCategory());

            // Executando o POST
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechando as conexões
            try {
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
    
    public static void main(String args[]) throws Exception{
        DadosCidade cidadeTeste = new DadosCidade("Brazil","sao paulo",1,"good",2,"teste",2,"teste",4,"teste",5,"teste");
        InsertPesquisa pesquisaTeste = new InsertPesquisa();
        pesquisaTeste.Insertpesquisa(cidadeTeste);
    }
}
