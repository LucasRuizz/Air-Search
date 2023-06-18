package src.View;

import src.Controller.ConexaoDB;
import src.Controller.AreaController.SearchCidade;
import src.View.DataArea.AreaDadosCidade;
import src.Model.DadosCidade;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import src.Controller.ConexaoDB;

public class Input extends JFrame {
    private JComboBox<String> inputComboBox;
    
    public Input() {
        super("Exemplo de JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel selectionLabel = new JLabel("Selecione uma cidade:");
        selectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(selectionLabel);

        inputComboBox = new JComboBox<>();
        inputComboBox.setPreferredSize(new Dimension(200, 25));
        panel.add(inputComboBox);

        JButton searchButton = new JButton("Pesquisar");
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCity = (String) inputComboBox.getSelectedItem();

                if (selectedCity != null && !selectedCity.isEmpty()) {
                    ConexaoDB db = new ConexaoDB();
                    //db.Input(selectedCity);
        String sql = "SELECT * FROM poluicaoglobal WHERE ï»¿Country = 'Brazil' AND city LIKE '%" + selectedCity + "%'";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = db.CriaConexaoMysql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
               SearchCidade datacity = new SearchCidade();
            DadosCidade objetcity =  datacity.searchcity(selectedCity);
             new AreaDadosCidade(objetcity);
               
            }

        } catch (Exception x) {
            
            x.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma cidade válida");
                }
            }
        });
        panel.add(searchButton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public void populateComboBox(List<String> cities) {
        for (String city : cities) {
            inputComboBox.addItem(city);
        }
    }
public void Run() {
                Input frame = new Input();
                frame.setVisible(true);

                // Preencher o ComboBox com as cidades do banco de dados
                ConexaoDB db = new ConexaoDB();
                List<String> cities = db.getAllCities();
                frame.populateComboBox(cities);
            }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Input frame = new Input();
                frame.setVisible(true);

                // Preencher o ComboBox com as cidades do banco de dados
                ConexaoDB db = new ConexaoDB();
                List<String> cities = db.getAllCities();
                frame.populateComboBox(cities);
            }
        });
    }
}
