package src.View.forms;
import src.Model.DadosCidade;
import src.Controller.InsertPesquisa;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovaPesquisa extends JFrame {
    public NovaPesquisa() {
        // Configurar o JFrame
        setTitle("Formulário de Cadastro");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Adicionar os componentes ao JFrame
        JLabel lblCountry = new JLabel("País:");
        lblCountry.setBounds(50, 50, 100, 20);
        add(lblCountry);

        JTextField txtCountry = new JTextField();
        txtCountry.setBounds(150, 50, 200, 20);
        add(txtCountry);

        JLabel lblCity = new JLabel("Cidade:");
        lblCity.setBounds(50, 80, 100, 20);
        add(lblCity);

        JTextField txtCity = new JTextField();
        txtCity.setBounds(150, 80, 200, 20);
        add(txtCity);

        JLabel lblAqiValue = new JLabel("Valor AQI:");
        lblAqiValue.setBounds(50, 110, 100, 20);
        add(lblAqiValue);

        JTextField txtAqiValue = new JTextField();
        txtAqiValue.setBounds(150, 110, 200, 20);
        add(txtAqiValue);

        JLabel lblAqiCategory = new JLabel("Categoria AQI:");
        lblAqiCategory.setBounds(50, 140, 100, 20);
        add(lblAqiCategory);

        JTextField txtAqiCategory = new JTextField();
        txtAqiCategory.setBounds(150, 140, 200, 20);
        add(txtAqiCategory);

        JLabel lblCOaqiValue = new JLabel("Valor CO AQI:");
        lblCOaqiValue.setBounds(50, 170, 100, 20);
        add(lblCOaqiValue);

        JTextField txtCOaqiValue = new JTextField();
        txtCOaqiValue.setBounds(150, 170, 200, 20);
        add(txtCOaqiValue);

        JLabel lblCOaqiCategory = new JLabel("Categoria CO AQI:");
        lblCOaqiCategory.setBounds(50, 200, 100, 20);
        add(lblCOaqiCategory);

        JTextField txtCOaqiCategory = new JTextField();
        txtCOaqiCategory.setBounds(150, 200, 200, 20);
        add(txtCOaqiCategory);

        JLabel lblOzoneAqiValue = new JLabel("Valor Ozone AQI:");
        lblOzoneAqiValue.setBounds(50, 230, 100, 20);
        add(lblOzoneAqiValue);

        JTextField txtOzoneAqiValue = new JTextField();
        txtOzoneAqiValue.setBounds(150, 230, 200, 20);
        add(txtOzoneAqiValue);

        JLabel lblOzoneAqiCategory = new JLabel("Categoria Ozone AQI:");
        lblOzoneAqiCategory.setBounds(50, 260, 100, 20);
        add(lblOzoneAqiCategory);

        JTextField txtOzoneAqiCategory = new JTextField();
        txtOzoneAqiCategory.setBounds(150, 260, 200, 20);
        add(txtOzoneAqiCategory);

        JLabel lblNO2aqiValue = new JLabel("Valor NO2 AQI:");
        lblNO2aqiValue.setBounds(50, 290, 100, 20);
        add(lblNO2aqiValue);

        JTextField txtNO2aqiValue = new JTextField();
        txtNO2aqiValue.setBounds(150, 290, 200, 20);
        add(txtNO2aqiValue);

        JLabel lblNO2aqiCategory = new JLabel("Categoria NO2 AQI:");
        lblNO2aqiCategory.setBounds(50, 320, 100, 20);
        add(lblNO2aqiCategory);

        JTextField txtNO2aqiCategory = new JTextField();
        txtNO2aqiCategory.setBounds(150, 320, 200, 20);
        add(txtNO2aqiCategory);

        JLabel lblPM25aqiValue = new JLabel("Valor PM2.5 AQI:");
        lblPM25aqiValue.setBounds(50, 350, 100, 20);
        add(lblPM25aqiValue);

        JTextField txtPM25aqiValue = new JTextField();
        txtPM25aqiValue.setBounds(150, 350, 200, 20);
        add(txtPM25aqiValue);

        JLabel lblPM25aqiCategory = new JLabel("Categoria PM2.5 AQI:");
        lblPM25aqiCategory.setBounds(50, 380, 100, 20);
        add(lblPM25aqiCategory);

        JTextField txtPM25aqiCategory = new JTextField();
        txtPM25aqiCategory.setBounds(150, 380, 200, 20);
        add(txtPM25aqiCategory);

        JButton btnSubmit = new JButton("Enviar");
        btnSubmit.setBounds(150, 420, 100, 30);
        add(btnSubmit);

        // Ação do botão de envio
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os valores dos campos
                String country = txtCountry.getText();
                String city = txtCity.getText();
                int aqiValue = Integer.parseInt(txtAqiValue.getText());
                String aqiCategory = txtAqiCategory.getText();
                int COaqiValue = Integer.parseInt(txtCOaqiValue.getText());
                String COaqiCategory = txtCOaqiCategory.getText();
                int ozoneAqiValue = Integer.parseInt(txtOzoneAqiValue.getText());
                String ozoneAqiCategory = txtOzoneAqiCategory.getText();
                int NO2aqiValue = Integer.parseInt(txtNO2aqiValue.getText());
                String NO2aqiCategory = txtNO2aqiCategory.getText();
                int PM25aqiValue = Integer.parseInt(txtPM25aqiValue.getText());
                String PM25aqiCategory = txtPM25aqiCategory.getText();

                // Criar a instância completa da classe DadosCidade
                DadosCidade dadosCidade = new DadosCidade(country, city, aqiValue, aqiCategory, COaqiValue,
                        COaqiCategory, ozoneAqiValue, ozoneAqiCategory, NO2aqiValue, NO2aqiCategory, PM25aqiValue,
                        PM25aqiCategory);
                       InsertPesquisa novaPesquisa = new InsertPesquisa();
                       novaPesquisa.Insertpesquisa(dadosCidade);
                      JOptionPane.showMessageDialog(null, "Nova pesquisa inserida com sucesso!");
                      dispose();
               
            }
        });

        // Exibir o JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new NovaPesquisa();
    }
}
