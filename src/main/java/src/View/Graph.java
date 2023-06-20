package src.View;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Graph extends JFrame{
    public int valor1;
    public int valor2;
    public int valor3;
    public int valor4;
    public int valor5;
    public int valor6;
    public int valor7;
    
    
    public Graph(int nvalor1, int nvalor2, int nvalor3, int nvalor4, int nvalor5){
        valor1 = nvalor1;
        valor2 = nvalor2;
        valor3 = nvalor3;
        valor4 = nvalor4;
        valor5 = nvalor5;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gráfico de Barras");
        setSize(950, 700);
        setLocationRelativeTo(null);
        criarGrafico();
        setVisible(true);
    }

    
    public void criarGrafico(){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
       
        barra.setValue(valor1,  "Valor do índice de qualidade do ar", "");
        barra.setValue(valor2, "Valor do índice de qualidade do ar de CO", "");
        barra.setValue(valor3, "Valor da qualidade do ar de ozonio", "");
        barra.setValue(valor4, "Valor da qualidade do ar de NO2", "");
        barra.setValue(valor5, "Valor da qualidade do ar de PM2.5", "");
        
      
        JFreeChart grafico = ChartFactory.createBarChart3D
        ("","","",
                barra,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }
    
    public static void main(String[] args) {
                                  
    }
}