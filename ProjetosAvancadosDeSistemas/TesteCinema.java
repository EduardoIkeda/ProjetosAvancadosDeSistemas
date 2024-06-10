package ProjetosAvancadosDeSistemas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TesteCinema {
    public static void main(String[] args) {
        // Criar instância do cinema
        Cinema cineMais = new Cinema("CineMais", "Rua A, 123");

        PreencherBanco(cineMais);

        Gerenciador gerenciador = new Gerenciador(cineMais);

        EstrategiaPreco estrategiaPadrao = new EstrategiaPrecoPadrao();
        EstrategiaPreco estrategiaPromocional = new EstrategiaPrecoPromocional(0.2f); // 20% de desconto

        // Sell ticket
        Usuario funcionario = new Usuario("João", "123456");

        if (!funcionario.ValidarLogin()) {
            System.err.println("Credenciais inválidas, tente novamente");
            return;
        }

        // Gerenciador

        // Scanner para entrada do funcionário
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Selecione a opção desejada:");
            System.out.print("1 - Realizar compra");
            System.out.print("2 - Cancelar compra");
            System.out.print("3 - Cadastrar/Atualizar banco");
            System.out.print("0 - Sair");

            int escolha = scanner.nextInt();
            if (escolha == 0) {
                break;
            }

            switch (escolha) {
                case 1:
                    while (true) {
                        // Perguntar ao funcionário se deseja comprar um ingresso ou sair
                        System.out.print("Digite 1 para comprar um ingresso ou 0 para voltar: ");
                        escolha = scanner.nextInt();
                        if (escolha == 0) {
                            break;
                        }

                        // Perguntar ao funcionário qual filme desejado e mostrar lista de filmes
                        // disponíveis
                        System.out.println("Escolha o filme desejado:");
                        List<Filme> filmesDisponiveis = gerenciador.GetFilmesComSessoesCadastradas();
                        for (int i = 0; i < filmesDisponiveis.size(); i++) {
                            System.out.println((i + 1) + ". " + filmesDisponiveis.get(i).GetTitulo());
                        }
                        System.out.print("Digite o número do filme desejado: ");
                        int escolhaFilme = scanner.nextInt();
                        Filme filmeEscolhido = filmesDisponiveis.get(escolhaFilme - 1);

                        // Mostrar dias disponíveis para aquele filme
                        System.out.println("Dias disponíveis para o filme " + filmeEscolhido.GetTitulo() + ":");
                        List<Date> diasDisponiveis = gerenciador.GetDiasDisponiveisParaFilme(filmeEscolhido);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        for (int i = 0; i < diasDisponiveis.size(); i++) {
                            System.out.println((i + 1) + ". " + sdf.format(diasDisponiveis.get(i)));
                        }
                        System.out.print("Digite o número do dia desejado: ");
                        int escolhaDia = scanner.nextInt();
                        Date diaEscolhido = diasDisponiveis.get(escolhaDia - 1);

                        // Mostrar as sessões disponíveis para o dia escolhido
                        System.out.println("Sessões disponíveis para o dia " + sdf.format(diaEscolhido) + ":");
                        List<Sessao> sessoesDisponiveis = gerenciador.GetSessoesDisponiveisParaFilmeNaData(
                                filmeEscolhido,
                                diaEscolhido);
                        for (int i = 0; i < sessoesDisponiveis.size(); i++) {
                            System.out.println((i + 1) + ". " + sessoesDisponiveis.get(i).GetHorarioInicio());
                        }
                        System.out.print("Digite o número da sessão desejada: ");
                        int escolhaSessao = scanner.nextInt();
                        Sessao sessaoEscolhida = sessoesDisponiveis.get(escolhaSessao - 1);

                        // Mostrar lugares disponíveis para a sessão escolhida
                        System.out.println("Lugares disponíveis para a sessão escolhida:");
                        List<Integer> lugaresDisponiveis = gerenciador.GetLugaresDisponiveisPorSessao(sessaoEscolhida);
                        for (int lugar : lugaresDisponiveis) {
                            System.out.print(lugar + " ");
                        }
                        System.out.println();
                        System.out.print("Digite o número do lugar desejado: ");
                        int escolhaLugar = scanner.nextInt();

                        // Verificar se o lugar está disponível
                        if (!lugaresDisponiveis.contains(escolhaLugar)) {
                            System.out.println("Lugar indisponível. Por favor, escolha outro lugar.");
                            continue;
                        }

                        // Criar ingresso
                        Ingresso ingresso = new Ingresso(1, escolhaLugar, sessaoEscolhida, 20.0f, new Date(), false,
                                estrategiaPadrao);

                        System.out.print("Qual foi a forma de pagamento?");
                        System.out.print("1 - Pix");
                        System.out.print("2 - Pagamento Cartão");
                        escolha = scanner.nextInt();

                        IPagamento pagamento;

                        if(escolha == 1)
                        {
                            pagamento = new PagamentoPix();
                            pagamento.CancelarPagamento();
                        }
                        else
                        {
                            System.out.print("Digite o numero do cartao:");
                            escolha = scanner.nextInt();
                            pagamento = new PagamentoCartao(escolha);
                        }

                        // Vender ingresso
                        gerenciador.VenderIngresso(funcionario, ingresso, pagamento);
                    }
                    break;

                case 2:
                    while (true) {
                        // Perguntar ao funcionário se deseja comprar um ingresso ou sair
                        System.out.print("Digite o ID do ingresso a ser cancelado ou 0 para voltar: ");
                        escolha = scanner.nextInt();
                        if (escolha == 0) {
                            break;
                        }

                        System.out.print("Qual foi a forma de pagamento?");
                        System.out.print("1 - Pix");
                        System.out.print("2 - Pagamento Cartão");
                        escolha = scanner.nextInt();

                        IPagamento pagamento;

                        if(escolha == 1)
                        {
                            pagamento = new PagamentoPix();
                        }
                        else
                        {
                            System.out.print("Digite o numero do cartao:");
                            escolha = scanner.nextInt();
                            pagamento = new PagamentoCartao(escolha);
                        }

                        gerenciador.CancelarIngresso(funcionario, escolha, pagamento);
                    }
                    break;
                case 3:
                    
                    break;

                default:
                    break;
            }
        }

    }

    private static void PreencherBanco(Cinema cinema) {
        // Criar equipamento para as salas
        IEquipamentoSala equipamento3D = new Equipamento3D();
        IEquipamentoSala equipamentoPadrao = new EquipamentoPadrao();

        // Criar salas
        Sala sala1 = new Sala(1, 50, equipamento3D);
        Sala sala2 = new Sala(2, 40, equipamentoPadrao);
        Sala sala3 = new Sala(3, 60, equipamentoPadrao);

        // Adicionar salas ao cinema
        cinema.adicionarSala(sala1);
        cinema.adicionarSala(sala2);
        cinema.adicionarSala(sala3);

        // Criar filmes
        Filme filme1 = new Filme("The Matrix", "Lana Wachowski", "Keanu Reeves", 136, "14 anos", Categoria.ACAO);
        Filme filme2 = new Filme("Inception", "Christopher Nolan", "Leonardo DiCaprio", 148, "14 anos", Categoria.SUSPENSE);
        Filme filme3 = new Filme("Interstellar", "Christopher Nolan", "Matthew McConaughey", 169, "10 anos", Categoria.FICCAO);
        Filme filme4 = new Filme("The Godfather", "Francis Ford Coppola", "Marlon Brando", 175, "16 anos", Categoria.DRAMA);

        // Criar sessões
        Sessao sessao1 = new Sessao(new Date(), filme1, sala1);
        Sessao sessao2 = new Sessao(new Date(), filme2, sala2);
        Sessao sessao3 = new Sessao(new Date(), filme3, sala3);
        Sessao sessao4 = new Sessao(new Date(), filme4, sala1);

        // Adicionar sessões ao banco de dados
        BancoDeDados bancoDeDados = BancoDeDados.getInstance();
        bancoDeDados.AdicionaSessao(sessao1);
        bancoDeDados.AdicionaSessao(sessao2);
        bancoDeDados.AdicionaSessao(sessao3);
        bancoDeDados.AdicionaSessao(sessao4);

        // Criar ingressos falsos
        Ingresso ingresso1 = new Ingresso(1, 1, sessao1, 20.0f, new Date(), false, new EstrategiaPrecoPadrao());
        Ingresso ingresso2 = new Ingresso(2, 2, sessao2, 20.0f, new Date(), true, new EstrategiaPrecoPadrao());
        Ingresso ingresso3 = new Ingresso(3, 3, sessao3, 25.0f, new Date(), false, new EstrategiaPrecoPromocional(0.1f));
        Ingresso ingresso4 = new Ingresso(4, 4, sessao4, 15.0f, new Date(), true, new EstrategiaPrecoPromocional(0.2f));

        // Adicionar ingressos ao banco de dados
        bancoDeDados.AdicionaIngresso(ingresso1);
        bancoDeDados.AdicionaIngresso(ingresso2);
        bancoDeDados.AdicionaIngresso(ingresso3);
        bancoDeDados.AdicionaIngresso(ingresso4);
    }
}