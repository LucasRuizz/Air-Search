package src;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ProjetoTeste extends JFrame{
    public int valor1;
    public int valor2;
    public int valor3;
    public int valor4;
    public int valor5;
    public int valor6;
    public int valor7;
    
    public ProjetoTeste(int nvalor1){
        valor1 = nvalor1;
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gráfico de Barras");
        setSize(950, 700);
        setLocationRelativeTo(null);
        criarGrafico();
        setVisible(true);
    }

    
    public void criarGrafico(){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
       
        barra.setValue(valor1, "São Paulo", "");
        barra.setValue(222, "Cubatão", "");
        barra.setValue(333, "Santos", "");
        barra.setValue(1000, "Guarulhos", "");
        barra.setValue(600, "São Bernardo do Campo", "");        
        barra.setValue(900, "Campinas", "");
        barra.setValue(1200, "Santo André", ""); 
        
      
        JFreeChart grafico = ChartFactory.createBarChart3D
        ("Cidades com maior numero de mortes em São Paulo(2022)","Cidades","Mortes",
                barra,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
    
    public static void main(String[] args) {
                                  
    }
}