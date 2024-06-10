package ProjetosAvancadosDeSistemas;
enum Categoria {
    ACAO,
    COMEDIA,
    INFANTIL,
    SUSPENSE,
    TERROR,
    FICCAO,
    DRAMA
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

    public String GetTitulo()
    {
        return titulo;
    }
}
