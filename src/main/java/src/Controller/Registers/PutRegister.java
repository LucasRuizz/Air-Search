/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller.Registers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import src.Controller.ConexaoDB;
import src.Model.DadosCidade;
/**
 *
 * @author Juan
 */
public class PutRegister {
    public PutRegister(int id,String nome,String email,String endereco) throws Exception{
        ConexaoDB db = new ConexaoDB();
         Connection conn = null;
            PreparedStatement pstm = null;
            ResultSet rset = null;
          String sql = "update poluicaoglobal set ? where ?" ;
          
         try {
            conn = db.CriaConexaoMysql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
               
                
            }
            
        } catch (Exception x) {
            
            x.printStackTrace();
        }
                    
    }
}
