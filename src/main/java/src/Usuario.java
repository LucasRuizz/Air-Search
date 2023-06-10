
package src;

public class Usuario {
    
    private int id_usuario;
    public String nome;
    private String telefone;
    private String email;

    public Usuario(int id_usuario, String nome, String telefone, String email) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String get_email() {
        return email;
    }

}
