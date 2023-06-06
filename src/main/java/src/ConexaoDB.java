package src;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JFrame.*;
import javax.swing.JTextField;

public class ConexaoDB{
    
    public static Connection CriaConexaoMysql() throws Exception{
        String url = "jdbc:mysql://localhost:3306/nome_do_seu_db";
        String user = "root";
        String password = "12345";  
        //try {
    Connection connection = DriverManager.getConnection(url, user, password);
    return connection;
    
//} catch (SQLException e) {
    //e.printStackTrace();
//}
    }
    public static void SearchData(String cidade){
         String sql = "SELECT * FROM poluicaoglobal WHERE ï»¿Country = 'Brazil' AND city LIKE '%" + cidade + "%'";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try{
            conn = ConexaoDB.CriaConexaoMysql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
               System.out.println(rset.getString("city"));
            }
            
        } catch(Exception e){
          JOptionPane.showMessageDialog(null, "alerta","alerta", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }finally {
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
    
    
    public static void main(String args[]){
        
}
}
