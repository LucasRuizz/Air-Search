package src.View.DataArea;
import src.Model.DadosCidade;
import src.Controller.GetPesquisas;
import javax.swing.*;
import java.awt.Font;
import java.util.List;

public class Pesquisas extends JFrame {
    private JList<String> cidadeList;

    public Pesquisas() {
        this.setSize(1920, 1080);
        this.setTitle("Pesquisas Cadastradas");

        // Criar um modelo de lista
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Obter a lista de dados da classe GetPesquisas
        GetPesquisas getPesquisas = new GetPesquisas();
        List<DadosCidade> dadosCidades = getPesquisas.getPesquisas();

        // Adicionar as cidades ao modelo de lista
        for (DadosCidade dadosCidade : dadosCidades) {
            listModel.addElement(dadosCidade.getCity());
        }

        // Criar o componente de lista
        cidadeList = new JList<>(listModel);

        // Configurar o layout e adicionar a lista ao JFrame
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.getContentPane().add(cidadeList);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Pesquisas pesquisas = new Pesquisas();
        pesquisas.setVisible(true);
    }
}
