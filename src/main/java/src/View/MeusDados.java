package src.View;

import java.awt.Font;
import javax.swing.*;

public class MeusDados extends JFrame {
    private String nome;
    private String email;
    private String endereco;
    private String acesso;
    private JPanel panel;
    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelEndereco;
    private JLabel labelAcesso;

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

        this.labelNome = new JLabel("Nome: " + nome);
        this.labelNome.setBounds(50, 50, 200, 30);
        this.labelNome.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelNome);

        this.labelEmail = new JLabel("Email: " + email);
        this.labelEmail.setBounds(50, 100, 200, 30);
        this.labelEmail.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelEmail);

        this.labelEndereco = new JLabel("Endereço: " + endereco);
        this.labelEndereco.setBounds(50, 150, 200, 30);
        this.labelEndereco.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelEndereco);

        this.labelAcesso = new JLabel("Acesso: " + acesso);
        this.labelAcesso.setBounds(50, 200, 200, 30);
        this.labelAcesso.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelAcesso);

        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
