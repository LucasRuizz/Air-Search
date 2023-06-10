
package src;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

public class App extends JFrame {
    public void Run() {
        setTitle("AirSearch");
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));

        // Caminho completo do arquivo de imagem no computador
        String imagePath = "./assets/logo-removebg-preview.png";
        File file = new File(imagePath);
        if (file.exists()) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(scaledIcon);
            label.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
            panel.add(label);
        }

        JButton button = new JButton("Fazer uma consulta");
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.addActionListener(e -> {
       new Search().setVisible(true);
        
        });
        panel.add(button);

        getContentPane().add(panel);
    }

    public static void main(String args[]) {
        App app = new App();
        app.Run();
    }
}
