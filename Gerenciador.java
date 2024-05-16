public class Gerenciador {
    Cinema cinema;
    BancoDeDados bancoDeDados;

    public Gerenciador(Cinema cinema) {
        this.cinema = cinema;
        bancoDeDados = BancoDeDados.getInstance();
        bancoDeDados.Conectar();
    }

    void venderIngresso(Usuario funcionario, Ingresso ingresso, IPagamento metodoPagamento)
    {
        // Implementação para vender ingresso
        //TODO: Em caso de pagamento realizado com sucesso, chama a impressao do ticket
        //TODO: Calculo do valor do ingresso computado a partir da sessao
        //TODO: Decrementa a quantidade de vagas na sessao
        
        String codigoTransacao = metodoPagamento.RealizarPagamento();
        
        if(codigoTransacao != null)
        {
            System.out.println("Pagamento bem sucedido");
            bancoDeDados.AdicionaIngresso(ingresso);
            
            Sessao sessao = ingresso.GetSessao();
            sessao.SetLugarOcupado(ingresso.GetLugar());
           
            ingresso.ImprimirIngresso();
        }
        else
        {
            System.out.println("Pagamento recusado.");
        }
        
    }

    void cancelarIngresso(Usuario funcionario, Ingresso ingresso, IPagamento metodoPagamento) {
        // Implementação para cancelar ingresso
        //TODO: Incrementa a quantidade de vagas da sessao
    }
}
