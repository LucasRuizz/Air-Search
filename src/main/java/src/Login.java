
package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    
    public Login() {
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 500);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JLabel labelLogo = new JLabel();
        ImageIcon logoImage = new ImageIcon("caminho/para/sua/logo.png");
        labelLogo.setIcon(logoImage);
        panel.add(labelLogo, BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 10, 10));
        
        JLabel labelLogin = new JLabel("Login:");
        formPanel.add(labelLogin);
        
        textFieldLogin = new JTextField();
        formPanel.add(textFieldLogin);
        
        JLabel labelPassword = new JLabel("Senha:");
        formPanel.add(labelPassword);
        
        passwordField = new JPasswordField();
        formPanel.add(passwordField);
        
        panel.add(formPanel, BorderLayout.CENTER);
        
        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = textFieldLogin.getText();
                String senha = new String(passwordField.getPassword());
                // Verifique as credenciais e faça a lógica de autenticação aqui
                
                if (login.equals("admin") && senha.equals("admin")) {
                    // Credenciais corretas, faça algo, como abrir a próxima tela
                    App app = new App();
                    app.Run();
                    dispose(); // Fecha a tela de login
                    // Chame a próxima tela aqui
                } else {
                    // Credenciais incorretas, exiba uma mensagem de erro
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos. Tente novamente.");
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

