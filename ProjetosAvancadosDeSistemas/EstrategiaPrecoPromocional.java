package ProjetosAvancadosDeSistemas;
class EstrategiaPrecoPromocional implements EstrategiaPreco {
    private float desconto;

    public EstrategiaPrecoPromocional(float desconto) {
        this.desconto = desconto;
    }

    @Override
    public float calcularPreco(float precoBase) {
        return precoBase * (1 - desconto);
    }
}