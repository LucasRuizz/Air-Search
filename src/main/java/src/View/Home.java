/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.View;
import src.View.DataArea.MeusDados;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.Controller.ConexaoDB;
/**
 *
 * @author Juan
 */
public class Home extends JFrame {
    protected String nome;
    protected String email;
    protected String endereco;
    protected String acesso;
    private JTextField textFieldLogin;
    private JTextField intValueTextField = new JTextField();

    
    public Home(String acesso,String email,String endereco,String nome) {
         
        
        setTitle("Opções do Sistema");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(2, 2, 10, 10));
        if(acesso.equals("user")){
         JButton buttonConsulta = new JButton("Fazer Consulta");
        buttonConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Input input = new Input();
                input.Run();
                // Lógica para a opção "Fazer Consulta"
            }
        });
        add(buttonConsulta);
        
        JButton buttonMeusDados = new JButton("Meus Dados");
        buttonMeusDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MeusDados data= new MeusDados(acesso, nome, endereco,email);
                    // Lógica para a opção "Meus Dados"
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        add(buttonMeusDados);
        }else{
              JButton buttonConsulta = new JButton("Fazer Consulta");
        buttonConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Input input = new Input();
                input.Run();
                // Lógica para a opção "Fazer Consulta"
            }
        });
        add(buttonConsulta);

        JButton buttonPublicarPesquisa = new JButton("Publicar Pesquisa");
        buttonPublicarPesquisa.setVisible(true);
        buttonPublicarPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // Lógica para a opção "Publicar Pesquisa"
            }
        });
        add(buttonPublicarPesquisa);

        JButton buttonEditarPesquisa = new JButton("Editar Pesquisa");
        buttonEditarPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        add(buttonEditarPesquisa);

        JButton buttonMeusDados = new JButton("Meus Dados");
        buttonMeusDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                 new MeusDados(acesso, nome, endereco,email);
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
