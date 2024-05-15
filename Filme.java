enum Categoria {
    ACAO,
    COMEDIA,
    INFANTIL,
    SUSPENSE,
    TERROR
}

public class Filme {
    String titulo;
    String diretor;
    String atorPrincipal;
    int duracao;
    String classificacaoEtaria;
    Categoria categoria;

    public Filme(String titulo, String diretor, String atorPrincipal, int duracao, String classificacaoEtaria, Categoria categoria) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.atorPrincipal = atorPrincipal;
        this.duracao = duracao;
        this.classificacaoEtaria = classificacaoEtaria;
        this.categoria = categoria;
    }
}
