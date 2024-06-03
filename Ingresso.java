
import java.text.SimpleDateFormat;
import java.util.*;

public class Ingresso {

    int id;
    Sessao sessao;
    float valor;
    Date dataCompra;
    boolean meiaEntrada;
    String codigoTransacao;
    int lugar;
    EstrategiaPreco estrategiaPreco; // Estratégia de cálculo de preço

    public Ingresso(int id, int lugar, Sessao sessao, float valor, Date dataCompra, boolean meiaEntrada, EstrategiaPreco estrategiaPreco) {
        this.id = id;
        this.sessao = sessao;
        this.valor = valor;
        this.dataCompra = dataCompra;
        this.meiaEntrada = meiaEntrada;
        this.estrategiaPreco = estrategiaPreco; // Define a estratégia de preço
        this.lugar = lugar;
    }

    public void Cancelar() {
        // Implementação para cancelar ingresso
    }

    public void ImprimirIngresso() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat sdfHorario = new SimpleDateFormat("HH:mm");
        StringBuilder ticket = new StringBuilder();

        ticket.append("---------- INGRESSO ----------\n")
              .append("Sala: ").append(sessao.GetSala().GetNumero()).append("\n")
              .append("Filme: ").append(sessao.GetFilme().GetTitulo()).append("\n")
              .append("Horário da Sessão: ").append(sdfHorario.format(sessao.GetHorarioInicio())).append("\n")
              .append("Meia Entrada: ").append(meiaEntrada ? "Sim" : "Não").append("\n")
              .append("Data da Compra: ").append(sdf.format(dataCompra)).append("\n")
              .append("Lugar: ").append(lugar).append("\n")
              .append("------------------------------\n");

        System.out.println(ticket.toString());
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