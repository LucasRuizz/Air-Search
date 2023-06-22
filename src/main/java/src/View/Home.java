package src.View;

import src.View.DataArea.MeusDados;
import src.View.forms.NovaPesquisa;
import src.View.DataArea.Pesquisas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.Controller.ConexaoDB;

public class Home extends JFrame {
    protected String nome;
    protected String email;
    protected String endereco;
    protected String acesso;

    public Home(String acesso, String email, String endereco, String nome, int codigo) {
        setTitle("Opções do Sistema");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new GridLayout(2, 2, 10, 10));
        getContentPane().setBackground(Color.WHITE);

        if (acesso.equals("user")) {
            JButton buttonConsulta = new JButton("Fazer Consulta");
            buttonConsulta.setBackground(new Color(128, 128, 128)); 
            buttonConsulta.setForeground(Color.WHITE);
            buttonConsulta.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Input input = new Input();
                    input.Run();
                    // Lógica para a opção "Fazer Consulta"
                }
            });
            add(buttonConsulta);

            JButton buttonMeusDados = new JButton("Meus Dados");
            buttonMeusDados.setBackground(new Color(128, 128, 128));
            buttonMeusDados.setForeground(Color.WHITE);
            buttonMeusDados.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        MeusDados data = new MeusDados(codigo, acesso, nome, endereco, email);
                        // Lógica para a opção "Meus Dados"
                    } catch (Exception ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            add(buttonMeusDados);
        } else {
            JButton buttonConsulta = new JButton("Fazer Consulta");
            buttonConsulta.setBackground(new Color(128, 128, 128)); 
            buttonConsulta.setForeground(Color.WHITE);
            buttonConsulta.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Input input = new Input();
                    input.Run();
                    
                }
            });
            add(buttonConsulta);

            JButton buttonPublicarPesquisa = new JButton("Publicar Pesquisa");
            buttonPublicarPesquisa.setBackground(new Color(128, 128, 128)); 
            buttonPublicarPesquisa.setForeground(Color.WHITE);
            buttonPublicarPesquisa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new NovaPesquisa();

                }
            });
            add(buttonPublicarPesquisa);

            JButton buttonEditarPesquisa = new JButton("Editar Pesquisa");
            buttonEditarPesquisa.setBackground(new Color(128, 128, 128));
            buttonEditarPesquisa.setForeground(Color.WHITE);
            buttonEditarPesquisa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   Pesquisas JframePesquisas = new Pesquisas();
                   JframePesquisas.Run();
                }
            });
            add(buttonEditarPesquisa);

            JButton buttonMeusDados = new JButton("Meus Dados");
            buttonMeusDados.setBackground(new Color(128, 128, 128)); 
            buttonMeusDados.setForeground(Color.WHITE);
            buttonMeusDados.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        new MeusDados(codigo, acesso, nome, endereco, email);
                    } catch (Exception ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            add(buttonMeusDados);
        }
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
