import java.util.*;

public class Sessao {
    Date horarioInicio;
    Filme filme;
    Sala sala;

    public Sessao(Date horarioInicio, Filme filme, Sala sala) {
        this.horarioInicio = horarioInicio;
        this.filme = filme;
        this.sala = sala;
    }
}
