import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TesteCinema {
    public static void main(String[] args) {
        // Criar instância do cinema
        Cinema cineMais = new Cinema("CineMais", "Rua A, 123");

        // Criar equipamento para as salas
        IEquipamentoSala equipamento3D = new Equipamento3D();
        IEquipamentoSala equipamentoPadrao = new EquipamentoPadrao();

        // Criar salas
        Sala sala1 = new Sala(1, 50, equipamento3D);
        Sala sala2 = new Sala(2, 40, equipamentoPadrao);

        // Adicionar salas ao cinema
        cineMais.adicionarSala(sala1);
        cineMais.adicionarSala(sala2);

        // Criar filmes
        Filme filme1 = new Filme("The Matrix", "Lana Wachowski", "Keanu Reeves", 136, "14 anos", Categoria.ACAO);
        Filme filme2 = new Filme("Inception", "Christopher Nolan", "Leonardo DiCaprio", 148, "14 anos", Categoria.SUSPENSE);

        // Criar sessões
        Sessao sessao1 = new Sessao(new Date(), filme1, sala1);
        Sessao sessao2 = new Sessao(new Date(), filme2, sala2);

        EstrategiaPreco estrategiaPadrao = new EstrategiaPrecoPadrao();
        EstrategiaPreco estrategiaPromocional = new EstrategiaPrecoPromocional(0.2f); // 20% de desconto

        // Adicionar sessões ao banco de dados
        BancoDeDados bancoDeDados = BancoDeDados.getInstance();
        bancoDeDados.AdicionaSessao(sessao1);
        bancoDeDados.AdicionaSessao(sessao2);

        // Sell ticket
        Usuario funcionario = new Usuario("João", "123456");

        if (!funcionario.ValidarLogin()) {
            System.err.println("Credenciais inválidas, tente novamente");
            return;
        }

        // Gerenciador
        Gerenciador gerenciador = new Gerenciador(cineMais);

        // Scanner para entrada do funcionário
        Scanner scanner = new Scanner(System.in);

        // Perguntar ao funcionário qual filme desejado e mostrar lista de filmes disponíveis
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
        List<Sessao> sessoesDisponiveis = gerenciador.GetSessoesDisponiveisParaFilmeNaData(filmeEscolhido, diaEscolhido);
        for (int i = 0; i < sessoesDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + sessoesDisponiveis.get(i).GetHorarioInicio());
        }
        System.out.print("Digite o número da sessão desejada: ");
        int escolhaSessao = scanner.nextInt();
        Sessao sessaoEscolhida = sessoesDisponiveis.get(escolhaSessao - 1);

        // Create ticket
        Ingresso ingresso1 = new Ingresso(1, filme1, sala1, sessao1, 20.0f, new Date(), false, estrategiaPadrao);
        Ingresso ingressoPadrao = new Ingresso(1, filme1, sala1, sessao1, 20.0f, new Date(), false, estrategiaPadrao);
        Ingresso ingressoPromocional = new Ingresso(2, filme2, sala2, sessao2, 20.0f, new Date(), true, estrategiaPromocional); // Meia-entrada

        IPagamento pagamentoCartao = new PagamentoCartao("1234567890123456", "João Silva", "12/23", "Visa");

        // Vender ingresso
        gerenciador.venderIngresso(funcionario, ingresso1, pagamentoCartao);
    }
}
