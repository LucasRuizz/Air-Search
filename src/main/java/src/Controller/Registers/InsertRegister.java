/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller.Registers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import src.Controller.ConexaoDB;

/**
 *
 * @author Juan
 */
public class InsertRegister {
    public void Insert(String email, String nome, String password, String endereco, String TipoUsuario) {
        ConexaoDB db = new ConexaoDB();
        String sql = "INSERT INTO tb_usuarios (nome, senha, email, TipoAcesso, Endereco) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = db.CriaConexaoMysql();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, ""); // Insira o valor para TipoAcesso
            stmt.setString(5, endereco);
            
            stmt.executeUpdate();
            
            System.out.println("Registro inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir o registro.");
        }
    }
}
