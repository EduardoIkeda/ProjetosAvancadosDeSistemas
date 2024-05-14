import java.util.*;

public class Ingresso {
    int id;
    Filme filme;
    Sala sala;
    Sessao sessao;
    float valor;
    Date dataCompra;
    boolean meiaEntrada;

    public Ingresso(int id, Filme filme, Sala sala, Sessao sessao, float valor, Date dataCompra, boolean meiaEntrada) {
        this.id = id;
        this.filme = filme;
        this.sala = sala;
        this.sessao = sessao;
        this.valor = valor;
        this.dataCompra = dataCompra;
        this.meiaEntrada = meiaEntrada;
    }

    void cancelar() {
        // Implementação para cancelar ingresso
    }

    void imprimirTicket() {
        // Implementação para imprimir ticket
    }
}
