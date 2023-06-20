package src.View.DataArea;

import src.Controller.ConexaoDB;
import src.Controller.Registers.PutRegister;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class MeusDados extends JFrame {
    private JLabel h1;
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
    public String nome;
    public String email;
    public String endereco;
    public String acesso;

    public MeusDados(int codigo, String acesso, String nome, String endereco, String email) throws Exception {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.acesso = acesso;

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
            toggleFields(labelNome, inputNome);
            if (inputNome.isVisible()) {
                inputNome.requestFocus();
            }
        });

        this.editarEmail.addActionListener(e -> {
            toggleFields(labelEmail, inputEmail);
            if (inputEmail.isVisible()) {
                inputEmail.requestFocus();
            }
        });

        this.editarEndereco.addActionListener(e -> {
            toggleFields(labelEndereco, inputEndereco);
            if (inputEndereco.isVisible()) {
                inputEndereco.requestFocus();
            }
        });

        inputNome.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateNome(codigo);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        inputEmail.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateEmail(codigo);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        inputEndereco.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateEndereco(codigo);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConexaoDB db = new ConexaoDB();
        db.CriaConexaoMysql();
    }

    private void toggleFields(JLabel label, JTextField field) {
        label.setVisible(!label.isVisible());
        field.setVisible(!field.isVisible());
    }

    private void updateNome(int codigo) {
        String novoNome = inputNome.getText();
        if (!novoNome.equals(nome)) {
            nome = novoNome;
            labelNome.setText("Nome: " + nome);
            toggleFields(labelNome, inputNome);
            try {
                PutRegister putRegister = new PutRegister(codigo, nome, "", "", "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            toggleFields(labelNome, inputNome);
        }
    }

    private void updateEmail(int codigo) {
        String novoEmail = inputEmail.getText();
        if (!novoEmail.equals(email)) {
            email = novoEmail;
            labelEmail.setText("Email: " + email);
            toggleFields(labelEmail, inputEmail);
            try {
                PutRegister putRegister = new PutRegister(codigo, "", "", email, "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            toggleFields(labelEmail, inputEmail);
        }
    }

    private void updateEndereco(int codigo) {
        String novoEndereco = inputEndereco.getText();
        if (!novoEndereco.equals(endereco)) {
            endereco = novoEndereco;
            labelEndereco.setText("Endereço: " + endereco);
            toggleFields(labelEndereco, inputEndereco);
            try {
                PutRegister putRegister = new PutRegister(codigo, "", "", "", endereco);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            toggleFields(labelEndereco, inputEndereco);
        }
    }
}
