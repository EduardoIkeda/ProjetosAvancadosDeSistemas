import java.util.*;

public class Cinema {
    private String nome;
    private String endereco;
    private List<Sala> salas;

    public Cinema(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.salas = new ArrayList<>();
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    void removerSala(int numeroSala) {
        salas.remove(numeroSala);
    }

    List<Filme> consultarFilmesEmExibicao(Date data) {
        // Implementação para consultar filmes em exibição
        return new ArrayList<>();
    }
}
