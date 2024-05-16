
import java.util.*;

public class Ingresso {

    int id;
    Filme filme;
    Sala sala;
    Sessao sessao;
    float valor;
    Date dataCompra;
    boolean meiaEntrada;
    String codigoTransacao;
    int lugar;

    public Ingresso(int id, Filme filme, Sala sala, Sessao sessao, float valor, Date dataCompra, boolean meiaEntrada) {
        this.id = id;
        this.filme = filme;
        this.sala = sala;
        this.sessao = sessao;
        this.valor = valor;
        this.dataCompra = dataCompra;
        this.meiaEntrada = meiaEntrada;
    }

    void Cancelar() {
        // Implementação para cancelar ingresso
    }

    void ImprimirIngresso() {
        // Implementação para imprimir ticket
    }

    public void SetCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }
    
    public Sessao GetSessao()
    {
        return sessao;
    }
    
    public int GetLugar()
    {
        return lugar;
    }
}
