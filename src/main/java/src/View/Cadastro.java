
package src.View;
import src.Controller.InsertRegister;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame {
    private JTextField textFieldEmail;
    private JTextField textFieldNome;
    private JTextField textFieldTelefone;
    private JTextField textFieldEndereco;
    private JPasswordField passwordField;

    public void setCadastro() {
        setTitle("Formulário de Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 3, 10, 10));

        JLabel labelEmail = new JLabel("E-mail:");
        formPanel.add(labelEmail);
        textFieldEmail = new JTextField();
        formPanel.add(textFieldEmail);

        JLabel labelNome = new JLabel("Nome:");
        formPanel.add(labelNome);

        textFieldNome = new JTextField();
        formPanel.add(textFieldNome);

        JLabel labelTelefone = new JLabel("Telefone:");
        formPanel.add(labelTelefone);

        textFieldTelefone = new JTextField();
        formPanel.add(textFieldTelefone);

        JLabel labelEndereco = new JLabel("Endereço:");
        formPanel.add(labelEndereco);

        textFieldEndereco = new JTextField();
        formPanel.add(textFieldEndereco);

        JLabel labelSenha = new JLabel("Senha:");
        formPanel.add(labelSenha);

        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        panel.add(formPanel, BorderLayout.CENTER);

        JButton buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                String nome = textFieldNome.getText();
                String telefone = textFieldTelefone.getText();
                String endereco = textFieldEndereco.getText();
                String senha = new String(passwordField.getPassword());

                // Aqui você pode adicionar a lógica para cadastrar os dados
                // Por exemplo, você pode exibir os valores em uma mensagem de diálogo
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                dispose();

                // Limpar os campos após o cadastro, se necessário
                textFieldEmail.setText("");
                textFieldNome.setText("");
                textFieldTelefone.setText("");
                textFieldEndereco.setText("");
                passwordField.setText("");
                InsertRegister register = new InsertRegister();
                register.Insert(email,nome,senha,endereco,"user");
            } 
        });

        panel.add(buttonCadastrar, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
  
}
