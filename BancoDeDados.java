import java.util.List;

public class BancoDeDados
{
    private static BancoDeDados instance = new BancoDeDados();

    private BancoDeDados() {}

    public static BancoDeDados getInstance()
    {
        return instance;
    }
    
    private List<Ingresso> ingressos;
    private List<Filme> filmes;
    private List<Sessao> sessoes;

    public void AdicionaIngresso(Ingresso ingresso)
    {
        ingressos.add(ingresso);
    }
    
    public void AdicionaFilme(Filme filme)
    {
        filmes.add(filme);
    }
    
    public void AdicionaSessao(Sessao sessao)
    {
        sessoes.add(sessao);
    }
    
    public void Conectar()
    {
        System.out.println("Conectado");
    }

    public void Desconectar()
    {
        System.out.println("Desconectado");
    }
}
