package src.Controller.CRUDPesquisas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import src.Controller.ConexaoDB;
import src.Model.DadosCidade;

/**
 * Classe responsável por realizar a atualização de dados de pesquisa no banco de dados.
 */
public class PutPesquisa {
    private ConexaoDB db = new ConexaoDB();
    private Connection conn = null;
    private PreparedStatement pstm = null;

    /**
     * Atualiza os dados de uma pesquisa no banco de dados.
     *
     * @param cidade Objeto DadosCidade contendo os dados atualizados da pesquisa.
     * @throws Exception Caso ocorra algum erro durante a atualização.
     */
    public void updatePesquisa(DadosCidade cidade) throws Exception {
        conn = db.CriaConexaoMysql();

        StringBuilder sql = new StringBuilder("UPDATE poluicaoglobal SET ");
        boolean hasSetClause = false;

        if (cidade.getCountry() != null) {
            sql.append("`ï»¿Country` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getAqiValue() != 0) {
            sql.append("`AQI Value` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getAqiCategory() != null) {
            sql.append("`AQI Category` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getCOaqiValue() != 0) {
            sql.append("`CO AQI Value` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getCOaqiCategory() != null) {
            sql.append("`CO AQI Category` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getOzoneAqiValue() != 0) {
            sql.append("`Ozone AQI Value` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getOzoneAqiCategory() != null) {
            sql.append("`Ozone AQI Category` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getNO2aqiValue() != 0) {
            sql.append("`NO2 AQI Value` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getNO2aqiCategory() != null) {
            sql.append("`NO2 AQI Category` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getPM25aqiValue() != 0) {
            sql.append("`PM2.5 AQI Value` = ?, ");
            hasSetClause = true;
        }

        if (cidade.getPM25aqiCategory() != null) {
            sql.append("`PM2.5 AQI Category` = ?, ");
            hasSetClause = true;
        }

        if (!hasSetClause) {
            throw new Exception("Nenhum parâmetro fornecido para atualização.");
        }

        sql.setLength(sql.length() - 2); // Remove a vírgula extra no final
        sql.append(" WHERE city = ? LIMIT 1");

        pstm = conn.prepareStatement(sql.toString());

        int parameterIndex = 1;

        if (cidade.getCountry() != null) {
            pstm.setString(parameterIndex++, cidade.getCountry());
        }

        if (cidade.getAqiValue() != 0) {
            pstm.setInt(parameterIndex++, cidade.getAqiValue());
        }

        if (cidade.getAqiCategory() != null) {
            pstm.setString(parameterIndex++, cidade.getAqiCategory());
        }

        if (cidade.getCOaqiValue() != 0) {
            pstm.setInt(parameterIndex++, cidade.getCOaqiValue());
        }

        if (cidade.getCOaqiCategory() != null) {
            pstm.setString(parameterIndex++, cidade.getCOaqiCategory());
        }

        if (cidade.getOzoneAqiValue() != 0) {
            pstm.setInt(parameterIndex++, cidade.getOzoneAqiValue());
        }

        if (cidade.getOzoneAqiCategory() != null) {
            pstm.setString(parameterIndex++, cidade.getOzoneAqiCategory());
        }

        if (cidade.getNO2aqiValue() != 0) {
            pstm.setInt(parameterIndex++, cidade.getNO2aqiValue());
        }

        if (cidade.getNO2aqiCategory() != null) {
            pstm.setString(parameterIndex++, cidade.getNO2aqiCategory());
        }

        if (cidade.getPM25aqiValue() != 0) {
            pstm.setInt(parameterIndex++, cidade.getPM25aqiValue());
        }

        if (cidade.getPM25aqiCategory() != null) {
            pstm.setString(parameterIndex++, cidade.getPM25aqiCategory());
        }

        pstm.setString(parameterIndex, cidade.getCity());

        pstm.executeUpdate();
        System.out.println("Dados de pesquisa atualizados com sucesso!");
    }

    public static void main(String[] args) throws Exception {
        // Exemplo de uso da classe
        DadosCidade cidade = new DadosCidade("Brasil", "teste", 50, "categoria teste put", 10, "Baixa", 30, "Boa", 20, "Moderada", 15, "Boa");
        PutPesquisa putPesquisa = new PutPesquisa();
        putPesquisa.updatePesquisa(cidade);
    }
}
