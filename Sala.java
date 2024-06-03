import java.util.*;

public class Sala {
    private int numero;
    private int capacidadeTotal;
    private IEquipamentoSala equipamento;
    private List<Sessao> sessoes;

    public Sala(int numero, int capacidadeTotal, IEquipamentoSala equipamento)
    {
        this.numero = numero;
        this.capacidadeTotal = capacidadeTotal;
        this.equipamento = equipamento;
        this.sessoes = new ArrayList<>();
    }
    
    public int GetCapacidadeTotal()
    {
        return this.capacidadeTotal;
    }

    public int GetNumero() {
        return numero;
    }

}
