public class Usuario {
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public boolean ValidarLogin() {
        // Checando no banco de dados
        if (this.nome != null && this.senha != null) {
            System.err.println("Login realizado com sucesso!");
            return true;
        } else {
            return false;
        }
    }
}
