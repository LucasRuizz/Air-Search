package src.View.forms;

import src.View.Graph;
import java.awt.Font;
import src.Model.DadosCidade;
import src.Controller.ConexaoDB;
import javax.swing.*;
import javax.swing.JButton;
import org.jfree.chart.ChartPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPesquisaFrame extends JFrame {
    private JPanel panel;
    private JLabel labelCity;
    private JLabel labelAqiValue;
    private JLabel labelAqiCategory;
    private JLabel labelCOaqiValue;
    private JLabel labelCOaqiCategory;
    private JLabel labelOzoneAqiValue;
    private JLabel labelOzoneAqiCategory;
    private JLabel labelNO2aqiValue;
    private JLabel labelNO2aqiCategory;
    private JLabel labelPM25aqiValue;
    private JLabel labelPM25aqiCategory;
    private JPanel graphPanel;
    private JButton GraphConsult;

    public EditPesquisaFrame(DadosCidade cidade) {
        this.setSize(800, 600);
        this.getContentPane().setBackground(Color.WHITE); // Define o fundo branco

        this.panel = new JPanel();
        this.panel.setLayout(new GridBagLayout());
        this.panel.setBackground(Color.WHITE);

        this.labelCity = new JLabel("Nome: " + cidade.getCity());
        this.labelCity.setFont(new Font("Arial", Font.BOLD, 16));
        this.labelCity.setHorizontalAlignment(SwingConstants.CENTER); // Alinha o texto ao centro

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridBagLayout());
        dataPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o texto
        gbc.insets = new Insets(10, 10, 10, 10); // Adiciona espaçamento entre os componentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Define a largura da célula
        dataPanel.add(labelCity, gbc);

        gbc.gridwidth = 1; // Reseta a largura da célula

        gbc.gridx = 0;
        gbc.gridy = 1;
        labelAqiValue = new JLabel("AQI Value: " + cidade.getAqiValue());
        labelAqiValue.setFont(new Font("Arial", Font.BOLD, 14));
        labelAqiValue.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelAqiValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        labelAqiCategory = new JLabel("AQI Category: " + cidade.getAqiCategory());
        labelAqiCategory.setFont(new Font("Arial", Font.BOLD, 14));
        labelAqiCategory.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelAqiCategory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        labelCOaqiValue = new JLabel("CO AQI Value: " + cidade.getCOaqiValue());
        labelCOaqiValue.setFont(new Font("Arial", Font.BOLD, 14));
        labelCOaqiValue.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelCOaqiValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        labelCOaqiCategory = new JLabel("CO AQI Category: " + cidade.getCOaqiCategory());
        labelCOaqiCategory.setFont(new Font("Arial", Font.BOLD, 14));
        labelCOaqiCategory.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelCOaqiCategory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        labelOzoneAqiValue = new JLabel("Ozone AQI Value: " + cidade.getOzoneAqiValue());
        labelOzoneAqiValue.setFont(new Font("Arial", Font.BOLD, 14));
        labelOzoneAqiValue.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelOzoneAqiValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        labelOzoneAqiCategory = new JLabel("Ozone AQI Category: " + cidade.getOzoneAqiCategory());
        labelOzoneAqiCategory.setFont(new Font("Arial", Font.BOLD, 14));
        labelOzoneAqiCategory.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelOzoneAqiCategory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        labelNO2aqiValue = new JLabel("NO2 AQI Value: " + cidade.getNO2aqiValue());
        labelNO2aqiValue.setFont(new Font("Arial", Font.BOLD, 14));
        labelNO2aqiValue.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelNO2aqiValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        labelNO2aqiCategory = new JLabel("NO2 AQI Category: " + cidade.getNO2aqiCategory());
        labelNO2aqiCategory.setFont(new Font("Arial", Font.BOLD, 14));
        labelNO2aqiCategory.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelNO2aqiCategory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        labelPM25aqiValue = new JLabel("PM2.5 AQI Value: " + cidade.getPM25aqiValue());
        labelPM25aqiValue.setFont(new Font("Arial", Font.BOLD, 14));
        labelPM25aqiValue.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelPM25aqiValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        labelPM25aqiCategory = new JLabel("PM2.5 AQI Category: " + cidade.getPM25aqiCategory());
        labelPM25aqiCategory.setFont(new Font("Arial", Font.BOLD, 14));
        labelPM25aqiCategory.setForeground(Color.BLACK); // Define a cor do texto
        dataPanel.add(labelPM25aqiCategory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
        GraphConsult = new JButton("Consultar Gráfico");
        dataPanel.add(GraphConsult, gbc);

        this.panel.add(dataPanel, new GridBagConstraints());

        GraphConsult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graph grafico = new Graph(cidade.getCOaqiValue(), cidade.getNO2aqiValue(),
                        cidade.getOzoneAqiValue(), cidade.getPM25aqiValue(), cidade.getAqiValue());
                grafico.criarGrafico();
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}
