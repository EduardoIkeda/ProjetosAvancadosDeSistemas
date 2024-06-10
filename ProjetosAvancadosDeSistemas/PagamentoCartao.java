package ProjetosAvancadosDeSistemas;
public class PagamentoCartao implements IPagamento
{
    private int numero;

    public PagamentoCartao(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String RealizarPagamento()
    {
        System.out.println("Pagamento Realizado com cartão final " + numero + "!");
        return "codigo";
    }

    @Override
    public void CancelarPagamento()
    {
        System.out.println("Pagamento cancelado com cartão final XXXX! Prazo de até 3 dias para retornar.");
    }
}
