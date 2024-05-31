
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
    EstrategiaPreco estrategiaPreco; // Estratégia de cálculo de preço

    public Ingresso(int id, Filme filme, Sala sala, Sessao sessao, float valor, Date dataCompra, boolean meiaEntrada, EstrategiaPreco estrategiaPreco) {
        this.id = id;
        this.filme = filme;
        this.sala = sala;
        this.sessao = sessao;
        this.valor = valor;
        this.dataCompra = dataCompra;
        this.meiaEntrada = meiaEntrada;
        this.estrategiaPreco = estrategiaPreco; // Define a estratégia de preço
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

    public Sessao GetSessao() {
        return sessao;
    }

    public int GetLugar() {
        return lugar;
    }

    // Método para calcular o preço do ingresso usando a estratégia definida
    public float calcularPrecoIngresso() {
        float precoBase = valor;
        if (meiaEntrada) {
            precoBase /= 2; // Meia-entrada, preço é metade do valor base
        }
        return estrategiaPreco.calcularPreco(precoBase);
    }
}