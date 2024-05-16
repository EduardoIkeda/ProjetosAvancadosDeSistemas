public class PagamentoPix implements IPagamento {
    private String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public String RealizarPagamento()
    {
        System.out.println("Pagamento Realizado com Pix!");
        return "codigo";
    }
}
