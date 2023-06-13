
package src.Model;

public class Instituicao {
    
    public String nome;
    public String regiaoDados;

    public Instituicao(String nome, String regiaoDados) {
        this.nome = nome;
        this.regiaoDados = regiaoDados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiaoDados() {
        return regiaoDados;
    }

    public void setRegiaoDados(String regiaoDados) {
        this.regiaoDados = regiaoDados;
    }

    public String get_nome() {
        return nome;
    }

    public void set_nome(String nome) {
        this.nome = nome;
    }

    public void atribuirPesquisador(int id_pesquisador) {
        
    }
}

