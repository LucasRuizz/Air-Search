package src.View.forms;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPesquisaFrame extends JFrame {

    private JTextField countryTextField;
    private JTextField cityTextField;
    private JTextField aqiValueTextField;
    private JTextField aqiCategoryTextField;
    private JTextField coAqiValueTextField;
    private JTextField coAqiCategoryTextField;
    private JTextField ozoneAqiValueTextField;
    private JTextField ozoneAqiCategoryTextField;
    private JTextField no2AqiValueTextField;
    private JTextField no2AqiCategoryTextField;
    private JTextField pm25AqiValueTextField;
    private JTextField pm25AqiCategoryTextField;

    public EditPesquisaFrame() {
        setTitle("Edit Pesquisa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel countryLabel = new JLabel("Country:");
        countryTextField = new JTextField(20);

        JLabel cityLabel = new JLabel("City:");
        cityTextField = new JTextField(20);

        JLabel aqiValueLabel = new JLabel("AQI Value:");
        aqiValueTextField = new JTextField(20);

        JLabel aqiCategoryLabel = new JLabel("AQI Category:");
        aqiCategoryTextField = new JTextField(20);

        JLabel coAqiValueLabel = new JLabel("CO AQI Value:");
        coAqiValueTextField = new JTextField(20);

        JLabel coAqiCategoryLabel = new JLabel("CO AQI Category:");
        coAqiCategoryTextField = new JTextField(20);

        JLabel ozoneAqiValueLabel = new JLabel("Ozone AQI Value:");
        ozoneAqiValueTextField = new JTextField(20);

        JLabel ozoneAqiCategoryLabel = new JLabel("Ozone AQI Category:");
        ozoneAqiCategoryTextField = new JTextField(20);

        JLabel no2AqiValueLabel = new JLabel("NO2 AQI Value:");
        no2AqiValueTextField = new JTextField(20);

        JLabel no2AqiCategoryLabel = new JLabel("NO2 AQI Category:");
        no2AqiCategoryTextField = new JTextField(20);

        JLabel pm25AqiValueLabel = new JLabel("PM2.5 AQI Value:");
        pm25AqiValueTextField = new JTextField(20);

        JLabel pm25AqiCategoryLabel = new JLabel("PM2.5 AQI Category:");
        pm25AqiCategoryTextField = new JTextField(20);
    }}
        
            
                