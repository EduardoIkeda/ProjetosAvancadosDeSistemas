import java.util.*;

public class Sala {
    private int numero;
    private int capacidadeTotal;
    private int lugaresDisponiveis;
    private IEquipamentoSala equipamento;
    private List<Sessao> sessoes;

    public Sala(int numero, int capacidadeTotal, IEquipamentoSala equipamento) {
        this.numero = numero;
        this.capacidadeTotal = capacidadeTotal;
        this.lugaresDisponiveis = capacidadeTotal;
        this.equipamento = equipamento;
        this.sessoes = new ArrayList<>();
    }

    boolean verificarDisponibilidade() {
        return lugaresDisponiveis > 0;
    }
}
