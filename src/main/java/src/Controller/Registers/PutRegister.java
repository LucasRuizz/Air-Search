package src.Controller.Registers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import src.Controller.ConexaoDB;
import src.Model.DadosCidade;

/**
 * 
 * @autor Juan
 */
public class PutRegister {
    public PutRegister(int codigo, String nome, String senha, String email, String endereco) throws Exception {
        ConexaoDB db = new ConexaoDB();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        String sql = "UPDATE tb_usuarios SET ";

        // Montar a query de UPDATE dinamicamente
        boolean hasUpdates = false;
        if (!nome.isEmpty()) {
            sql += "nome=?, ";
            hasUpdates = true;
        }

        if (!senha.isEmpty()) {
            sql += "senha=?, ";
            hasUpdates = true;
        }

        if (!email.isEmpty()) {
            sql += "email=?, ";
            hasUpdates = true;
        }

        if (!endereco.isEmpty()) {
            sql += "endereco=?, ";
            hasUpdates = true;
        }

        // Remover a vírgula final e adicionar a cláusula WHERE
        sql = sql.substring(0, sql.length() - 2) + " WHERE codigo=?";

        try {
            conn = db.CriaConexaoMysql();
            pstm = conn.prepareStatement(sql);

            // Definir os valores correspondentes para os campos atualizados
            int parametro = 1;
            if (!nome.isEmpty()) {
                pstm.setString(parametro++, nome);
            }

            if (!senha.isEmpty()) {
                pstm.setString(parametro++, senha);
            }

            if (!email.isEmpty()) {
                pstm.setString(parametro++, email);
            }

            if (!endereco.isEmpty()) {
                pstm.setString(parametro++, endereco);
            }

            pstm.setInt(parametro, codigo); // Adiciona o valor do código para a condição WHERE

            if (hasUpdates) {
                pstm.executeUpdate();
                System.out.println("Cadastro editado com sucesso!");
            } else {
                System.out.println("Nenhum campo foi alterado.");
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
