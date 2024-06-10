package ProjetosAvancadosDeSistemas;
public class PagamentoPix implements IPagamento {

    public PagamentoPix() {
    }

    @Override
    public String RealizarPagamento()
    {
        System.out.println("Pagamento Realizado com Pix!");
        return "codigo";
    }

    @Override
    public void CancelarPagamento()
    {
        System.out.println("Estorno será realizado no prazo de 90 dias para a conta bancária correspondente.");
    }
}
