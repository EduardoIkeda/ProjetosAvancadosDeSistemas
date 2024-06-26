package ProjetosAvancadosDeSistemas;
import java.util.*;

public class Sessao {

    Date horarioInicio;
    Filme filme;
    Sala sala;
    int lugares[]; // 0 livrem 1 ocupado

    public Sessao(Date horarioInicio, Filme filme, Sala sala) {
        this.horarioInicio = horarioInicio;
        this.filme = filme;
        this.sala = sala;
        this.lugares = new int[sala.GetCapacidadeTotal()];
    }

    public void SetLugarOcupado(int lugar) {
        lugares[lugar] = 1;
    }

    public void SetLugarLivre(int lugar) {
        lugares[lugar] = 0;
    }

    public Date GetHorarioInicio() {
        return this.horarioInicio;
    }

    public Filme GetFilme() {
        return this.filme;
    }

    public Sala GetSala() {
        return this.sala;
    }

    public boolean GetSessaoLivre()
    {
        for (int i : lugares) {
            if (i == 0)
            {
                return true;
            }
        }
        return false;
    }
}
