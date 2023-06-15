package src.Controller;
import src.View.Home;
import src.View.DataArea.MeusDados;
import src.Model.DadosUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Validation {
   public String acesso="";
   public String nome = "";
    public String endereco= "";
    public String email= "";
    
    public boolean ValidationLogin(String email, String senha) throws Exception {
        ConexaoDB db = new ConexaoDB();
        String sql = "SELECT * FROM tb_usuarios WHERE email = ?";
        boolean loginCorreto = false;
       
        
       
        try (Connection conn = db.CriaConexaoMysql();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String mail = rs.getString("email");
                String password = rs.getString("senha");
                int cod_user = rs.getInt("codigo");
                System.out.println(cod_user);
                System.out.println(mail);

                // Verifica se a senha corresponde
                if (senha.equals(password)) {
                    loginCorreto = true;
                    nome = rs.getString("nome");
                    email = rs.getString("email"); 
                    endereco = rs.getString("endereco");
                   acesso = rs.getString("TipoAcesso");
                  // nome = rs.getString("nome");  Armazena o nome do usuário
                  DadosUsuario dataUser = new DadosUsuario(nome,email,endereco,acesso);
                    break;
                }
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (loginCorreto) {
         System.out.println("Login correto");
       
          return true;
                }
            else {
            System.out.println("Login incorreto");
            JOptionPane.showMessageDialog(null, "Login incorreto. Verifique suas credenciais.",
                    "Login incorreto", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public void RunHome(){
        new Home(acesso,email,endereco,nome);
    }
    public static void main(String args[]) throws Exception {
        Validation validacao = new Validation();
        boolean loginValido = validacao.ValidationLogin("master@gmail.com", "master102030");
        System.out.println("Login válido: " + loginValido);
    }
}
