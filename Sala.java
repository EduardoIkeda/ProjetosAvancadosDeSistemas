import java.util.*;

public class Sala {
    int numero;
    int capacidadeTotal;
    int lugaresDisponiveis;
    IEquipamentoSala equipamento;
    List<Sessao> sessoes;

    public Sala(int numero, int capacidadeTotal, EquipamentoSala equipamento) {
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
