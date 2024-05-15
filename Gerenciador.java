public class Gerenciador {
    Cinema cinema;

    public Gerenciador(Cinema cinema) {
        this.cinema = cinema;
    }

    void venderIngresso(Usuario funcionario, Sessao sessao, IPagamento metodoPagamento)
    {
        // Implementação para vender ingresso
        //TODO: Em caso de pagamento realizado com sucesso, chama a impressao do ticket
        //TODO: Calculo do valor do ingresso computado a partir da sessao
        //TODO: Decrementa a quantidade de vagas na sessao
    }

    void cancelarIngresso(Ingresso ingresso) {
        // Implementação para cancelar ingresso
        //TODO: Incrementa a quantidade de vagas da sessao
    }

    void imprimirTicket(Ingresso ingresso) {
        // Implementação para imprimir ticket
        // TODO: Fazer o print das informações do ingresso depois de imprimir
        // TODO: como Sala, sessao, horario etc
    }
}
