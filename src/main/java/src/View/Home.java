/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.Controller.ConexaoDB;
/**
 *
 * @author Juan
 */
public class Home extends JFrame {

    public Home() {
        setTitle("Opções do Sistema");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(2, 2, 10, 10));

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
        buttonPublicarPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para a opção "Publicar Pesquisa"
            }
        });
        add(buttonPublicarPesquisa);

        JButton buttonEditarPesquisa = new JButton("Editar Pesquisa");
        buttonEditarPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para a opção "Editar Pesquisa"
            }
        });
        add(buttonEditarPesquisa);

        JButton buttonMeusDados = new JButton("Meus Dados");
        buttonMeusDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MeusDados data= new MeusDados();
                // Lógica para a opção "Meus Dados"
            }
        });
        add(buttonMeusDados);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home();
            }
        });
    }
}

