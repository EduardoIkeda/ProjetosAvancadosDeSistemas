public class PagamentoCartao implements IPagamento
{
    private String numero;
    private String nome;
    private String dataValidade;
    private String bandeira;

    public PagamentoCartao(String numero, String nome, String dataValidade, String bandeira) {
        this.numero = numero;
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.bandeira = bandeira;
    }
    
    @Override
    public boolean RealizarPagamento()
    {
        System.out.println("Pagamento Realizado com cartão final XXXX!");
        return true;
    }
}
