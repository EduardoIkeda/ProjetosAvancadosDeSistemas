package ProjetosAvancadosDeSistemas;

import java.util.*;

public class Cinema {
    private String nome;
    private String endereco;
    private List<Sala> salas;
    private float precoBase;
    private float precoBase3D;

    public Cinema(String nome, String endereco, float precoBase, float precoBase3D) {
        this.nome = nome;
        this.endereco = endereco;
        this.salas = new ArrayList<>();
        this.precoBase = precoBase;
        this.precoBase3D = precoBase3D;
    }

    // #region Gets e Sets
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

    public float getPrecoBase() {
        return this.precoBase;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    public float getPrecoBase3D() {
        return this.precoBase3D;
    }

    public void setPrecoBase3D(float precoBase3D) {
        this.precoBase3D = precoBase3D;
    }
    // #endregion

    // #region Gestão das salas

    public List<Sala> getSalas() {
        return salas;
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public void removerSala(int numeroSala) {
        salas.remove(numeroSala);
    }
    // #endregion

}
