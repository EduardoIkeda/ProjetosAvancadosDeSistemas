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

    //#region Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    //#endregion

    //#region Gestão das salas
    
    public List<Sala> getSalas() {
        return salas;
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public void removerSala(int numeroSala) {
        salas.remove(numeroSala);
    }
    //#endregion

}
