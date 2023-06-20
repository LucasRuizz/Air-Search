package src.View.DataArea;
import src.View.Graph;
import java.awt.Font;
import src.Model.DadosCidade;
import src.Controller.ConexaoDB;
import javax.swing.*;
import javax.swing.JButton;
import org.jfree.chart.ChartPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaDadosCidade extends JFrame {
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

    public AreaDadosCidade(DadosCidade cidade) {
        this.setSize(1080, 1920);
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());

        this.labelCity = new JLabel("Nome: " + cidade.getCity());
        this.labelCity.setFont(new Font("Arial", Font.BOLD, 16));
        this.panel.add(labelCity, BorderLayout.NORTH);

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.add(new JLabel("AQI Value: " + cidade.getAqiValue()));
        dataPanel.add(new JLabel("AQI Category: " + cidade.getAqiCategory()));
        dataPanel.add(new JLabel("CO AQI Value: " + cidade.getCOaqiValue()));
        dataPanel.add(new JLabel("CO AQI Category: " + cidade.getCOaqiCategory()));
        dataPanel.add(new JLabel("Ozone AQI Value: " + cidade.getOzoneAqiValue()));
        dataPanel.add(new JLabel("Ozone AQI Category: " + cidade.getOzoneAqiCategory()));
        dataPanel.add(new JLabel("NO2 AQI Value: " + cidade.getNO2aqiValue()));
        dataPanel.add(new JLabel("NO2 AQI Category: " + cidade.getNO2aqiCategory()));
        dataPanel.add(new JLabel("PM2.5 AQI Value: " + cidade.getPM25aqiValue()));
        dataPanel.add(new JLabel("PM2.5 AQI Category: " + cidade.getPM25aqiCategory()));
        this.panel.add(dataPanel, BorderLayout.WEST);
        this.GraphConsult = new JButton("Consultar Gráfico");
        this.panel.add(GraphConsult, BorderLayout.SOUTH);
        
         this.GraphConsult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graph grafico = new Graph(cidade.COaqiValue,cidade.NO2aqiValue,
                cidade.OzoneAqiValue,cidade.PM25aqiValue, cidade.aqiValue );
                grafico.criarGrafico();
            }
        });
        this.add(panel);
        this.setVisible(true);
    }
}
