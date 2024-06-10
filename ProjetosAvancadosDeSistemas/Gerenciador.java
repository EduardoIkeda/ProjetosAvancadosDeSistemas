package ProjetosAvancadosDeSistemas;

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
    public List<Filme> GetFilmesComSessoesCadastradas() {
        List<Filme> filmesComSessoes = new ArrayList<>();
        List<Sessao> sessoes = bancoDeDados.GetListaSessoes();

        for (Sessao sessao : sessoes) {
            if(sessao.GetSessaoLivre())
            {
                Filme filme = sessao.GetFilme();
            
                if (!filmesComSessoes.contains(filme))
                    filmesComSessoes.add(filme);
            }
        }

        return filmesComSessoes;
    }

    public List<Date> GetDiasDisponiveisParaFilme(Filme filme) {
        List<Date> diasDisponiveis = new ArrayList<>();
        List<Sessao> sessoes = bancoDeDados.GetListaSessoes();

        for (Sessao sessao : sessoes) {
            if (sessao.GetFilme().equals(filme)) {
                if(sessao.GetSessaoLivre())
                    diasDisponiveis.add(sessao.GetHorarioInicio());
            }
        }

        return diasDisponiveis;
    }

    public List<Sessao> GetSessoesDisponiveisParaFilmeNaData(Filme filme, Date data) {
        List<Sessao> sessoesDisponiveis = new ArrayList<>();
        List<Sessao> sessoes = bancoDeDados.GetListaSessoes();

        for (Sessao sessao : sessoes) {
            if (sessao.GetFilme().equals(filme) && sessao.GetHorarioInicio().equals(data)) {
                if(sessao.GetSessaoLivre())
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
    // #endregion

    // #region Venda de ingresso

    void VenderIngresso(Usuario funcionario, Ingresso ingresso, IPagamento metodoPagamento) {
        Sessao sessao = ingresso.GetSessao();
        int lugar = ingresso.GetLugar();

        if (sessao.lugares[lugar] == 1) { // Lugar ocupado
            System.out.println("O lugar selecionado já está ocupado. Por favor, escolha outro lugar.");
            return;
        }

        // Realizar pagamento
        String codigoTransacao = metodoPagamento.RealizarPagamento();

        if (codigoTransacao != null) {
            System.out.println("Pagamento bem sucedido");
            ingresso.SetCodigoTransacao(codigoTransacao);
            bancoDeDados.AdicionaIngresso(ingresso);

            // Marcar o lugar como ocupado
            sessao.SetLugarOcupado(lugar);

            ingresso.ImprimirIngresso();
        } else {
            System.out.println("Pagamento recusado.");
        }
    }

    void CancelarIngresso(Usuario funcionario, int idingresso, IPagamento metodoPagamento) {
        List<Ingresso> ingressos = bancoDeDados.GetListaIngressos();
        Ingresso ingressoParaCancelar = null;

        for (Ingresso ingresso : ingressos) {
            if (ingresso.GetID() == idingresso) {
                ingressoParaCancelar = ingresso;
                break;
            }
        }

        if (ingressoParaCancelar != null) {
            Sessao sessao = ingressoParaCancelar.GetSessao();
            sessao.SetLugarLivre(ingressoParaCancelar.GetLugar());

            bancoDeDados.RemoverIngresso(ingressoParaCancelar);
            metodoPagamento.CancelarPagamento();

            System.out.println("Ingresso cancelado com sucesso.");
        }
    }
    // #endregion
}
