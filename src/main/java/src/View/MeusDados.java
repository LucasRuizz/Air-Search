package src.View;
import src.Controller.ConexaoDB;
import java.awt.Font;
import javax.swing.*;

public class MeusDados extends JFrame {
    
    public MeusDados() throws Exception{
    ConexaoDB db = new ConexaoDB();
    db.CriaConexaoMysql();
    }
    private JLabel h1;
    private String nome;
    private String email;
    private String endereco;
    private String acesso;
    private JPanel panel;
    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelEndereco;
    private JLabel labelAcesso;
    private JButton editarNome;
    private JButton editarEmail;
    private JButton editarEndereco;
    private JButton editarAcesso;
    private JTextField inputNome;
    private JTextField inputEmail;
    private JTextField inputEndereco;
    private JTextField inputAcesso;
    
    
 
    public void setDados(String nome, String email, String endereco, String acesso) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.acesso = acesso;
    }
    
    public void render() {
        this.setSize(600, 400);
        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.h1 = new JLabel("Dados do usuário");
        this.h1.setBounds(50, 30, 300, 50);
        this.h1.setFont(new Font("Arial", Font.BOLD, 20));
        this.panel.add(h1);

        this.labelNome = new JLabel("Nome: " + nome);
        this.labelNome.setBounds(50, 100, 200, 30);
        this.labelNome.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelNome);

        this.editarNome = new JButton("Editar");
        this.editarNome.setBounds(250, 100, 80, 30);
        this.panel.add(editarNome);

        this.inputNome = new JTextField(nome);
        this.inputNome.setBounds(350, 100, 200, 30);
        this.inputNome.setVisible(false);
        this.panel.add(inputNome);

        this.labelEmail = new JLabel("Email: " + email);
        this.labelEmail.setBounds(50, 150, 200, 30);
        this.labelEmail.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelEmail);

        this.editarEmail = new JButton("Editar");
        this.editarEmail.setBounds(250, 150, 80, 30);
        this.panel.add(editarEmail);

        this.inputEmail = new JTextField(email);
        this.inputEmail.setBounds(350, 150, 200, 30);
        this.inputEmail.setVisible(false);
        this.panel.add(inputEmail);

        this.labelEndereco = new JLabel("Endereço: " + endereco);
        this.labelEndereco.setBounds(50, 200, 200, 30);
        this.labelEndereco.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelEndereco);

        this.editarEndereco = new JButton("Editar");
        this.editarEndereco.setBounds(250, 200, 80, 30);
        this.panel.add(editarEndereco);

        this.inputEndereco = new JTextField(endereco);
        this.inputEndereco.setBounds(350, 200, 200, 30);
        this.inputEndereco.setVisible(false);
        this.panel.add(inputEndereco);

        this.labelAcesso = new JLabel("Acesso: " + acesso);
        this.labelAcesso.setBounds(50, 250, 200, 30);
        this.labelAcesso.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelAcesso);

        this.inputAcesso = new JTextField(acesso);
        this.inputAcesso.setBounds(350, 250, 200, 30);
        this.inputAcesso.setVisible(false);
        this.panel.add(inputAcesso);

        this.editarNome.addActionListener(e -> {
            labelNome.setVisible(false);
            inputNome.setVisible(true);
            inputNome.requestFocus();
        });

        this.editarEmail.addActionListener(e -> {
            labelEmail.setVisible(false);
            inputEmail.setVisible(true);
            inputEmail.requestFocus();
        });

        this.editarEndereco.addActionListener(e -> {
            
            labelEndereco.setVisible(false);
            inputEndereco.setVisible(true);
            inputEndereco.requestFocus();
        });

      

        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
