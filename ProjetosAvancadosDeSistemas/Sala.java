package ProjetosAvancadosDeSistemas;

public class Sala {
    private int numero;
    private int capacidadeTotal;
    private boolean sala3D;


    public Sala(int numero, int capacidadeTotal, boolean sala3D)
    {
        this.numero = numero;
        this.capacidadeTotal = capacidadeTotal;
        this.sala3D = sala3D;
    }
    
    public int GetCapacidadeTotal()
    {
        return this.capacidadeTotal;
    }

    public int GetNumero() {
        return numero;
    }

    public boolean getSala3D()
    {
        return this.sala3D;
    }

}
