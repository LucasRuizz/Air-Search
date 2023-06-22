package src.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.Controller.Validation;

public class Login extends JFrame {
    private JTextField textFieldLogin;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(700, 600);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.blue);

        JLabel labelLogo = new JLabel();
        ImageIcon logoImage = new ImageIcon("caminho/para/sua/logo.png");
        labelLogo.setIcon(logoImage);
        panel.add(labelLogo, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelLogin = new JLabel("Login:");
        formPanel.add(labelLogin);

        textFieldLogin = new JTextField();
        formPanel.add(textFieldLogin);

        JLabel labelPassword = new JLabel("Senha:");
        formPanel.add(labelPassword);

        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        JLabel labelcad = new JLabel("Não possui login?");
        labelcad.setForeground(Color.WHITE);
        JButton buttoncadastro = new JButton("Me cadastrar");
        buttoncadastro.setBackground(Color.cyan);
        buttoncadastro.setForeground(Color.black);
        formPanel.add(labelcad);
        formPanel.add(buttoncadastro);
        panel.add(formPanel, BorderLayout.CENTER);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBackground(Color.cyan);

        buttoncadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cadastro cadastro = new Cadastro();
                cadastro.setCadastro();
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = textFieldLogin.getText();
                String senha = new String(passwordField.getPassword());
                Validation validation = new Validation();
                try {
                    boolean loginCorreto = validation.ValidationLogin(login, senha);
                    if (loginCorreto) {
                        dispose(); // Fecha a tela de login
                        validation.RunHome();
                    } else {
                        // Credenciais incorretas, exibe uma mensagem de erro
                        JOptionPane.showMessageDialog(null, "Login ou senha incorretos. Tente novamente.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        panel.add(buttonLogin, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
