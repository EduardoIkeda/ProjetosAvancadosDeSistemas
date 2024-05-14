import java.util.*;

public class Cinema {
    String nome;
    String endereco;
    List<Sala> salas;

    public Cinema(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.salas = new ArrayList<>();
    }

    void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    void removerSala(int numeroSala) {
        // Implementação para remover sala
    }

    List<Filme> consultarFilmesEmExibicao(Date data) {
        // Implementação para consultar filmes em exibição
        return new ArrayList<>();
    }
}
