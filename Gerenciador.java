import java.text.SimpleDateFormat;
import java.util.*;

public class Gerenciador {
    Cinema cinema;
    BancoDeDados bancoDeDados;

    public Gerenciador(Cinema cinema) {
        this.cinema = cinema;
        bancoDeDados = BancoDeDados.getInstance();
        bancoDeDados.Conectar();
    }

    // #region Consulta de filme

    //TODO: Get lista de filmes com sessoes cadastradas
    public List<Filme> GetFilmesComSessoesCadastradas() {
        List<Filme> filmesComSessoes = new ArrayList<>();
        List<Sessao> sessoes = bancoDeDados.GetListaSessoes();

        for (Sessao sessao : sessoes) {
            Filme filme = sessao.GetFilme();
            if (!filmesComSessoes.contains(filme)) {
                filmesComSessoes.add(filme);
            }
        }

        return filmesComSessoes;
    }

    //TODO: Get dias disponiveis para um certo filme
    public List<Date> GetDiasDisponiveisParaFilme(Filme filme) {
        List<Date> diasDisponiveis = new ArrayList<>();
        List<Sessao> sessoes = bancoDeDados.GetListaSessoes();

        for (Sessao sessao : sessoes) {
            if (sessao.GetFilme().equals(filme)) {
                diasDisponiveis.add(sessao.GetHorarioInicio());
            }
        }

        return diasDisponiveis;
    }

    //TODO: Get Lista de sessoes disponiveis para um filme em uma certa data
    public List<Sessao> GetSessoesDisponiveisParaFilmeNaData(Filme filme, Date data) {
        List<Sessao> sessoesDisponiveis = new ArrayList<>();
        List<Sessao> sessoes = bancoDeDados.GetListaSessoes();

        for (Sessao sessao : sessoes) {
            if (sessao.GetFilme().equals(filme) && sessao.GetHorarioInicio().equals(data)) {
                sessoesDisponiveis.add(sessao);
            }
        }

        return sessoesDisponiveis;
    }

    // Pegar Lugares disponíveis com base na sessão escolhida
    public List<Integer> GetLugaresDisponiveisPorSessao(Sessao sessao) {
        List<Integer> lugaresDisponiveis = new ArrayList<>();
        int[] lugares = sessao.lugares;

        for (int i = 0; i < lugares.length; i++) {
            if (lugares[i] == 0) { // 0 indica lugar livre
                lugaresDisponiveis.add(i);
            }
        }

        return lugaresDisponiveis;
    }
    //#endregion

    //#region Venda de ingresso
    void venderIngresso(Usuario funcionario, Ingresso ingresso, IPagamento metodoPagamento) {
        // Implementação para vender ingresso
        //TODO: Em caso de pagamento realizado com sucesso, chama a impressão do ticket
        //TODO: Cálculo do valor do ingresso computado a partir da sessão
        //TODO: Decrementa a quantidade de vagas na sessão
        
        String codigoTransacao = metodoPagamento.RealizarPagamento();
        
        if(codigoTransacao != null) {
            System.out.println("Pagamento bem sucedido");
            bancoDeDados.AdicionaIngresso(ingresso);
            
            Sessao sessao = ingresso.GetSessao();
            sessao.SetLugarOcupado(ingresso.GetLugar());
           
            ingresso.ImprimirIngresso();
        } else {
            System.out.println("Pagamento recusado.");
        }
    }

    void cancelarIngresso(Usuario funcionario, Ingresso ingresso, IPagamento metodoPagamento) {
        // Implementação para cancelar ingresso
        //TODO: Incrementa a quantidade de vagas da sessão
        
        // Exemplo de implementação:
        Sessao sessao = ingresso.GetSessao();
        sessao.SetLugarLivre(ingresso.GetLugar());
        
        bancoDeDados.RemoverIngresso(ingresso);
        System.out.println("Ingresso cancelado com sucesso.");
    }
    //#endregion
}
