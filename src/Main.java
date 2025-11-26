import java.util.*;

public class Main {

    private static final Usuario USUARIO_FIXO = new Usuario("admin", "password123");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // LOGIN
        System.out.println("===== SISTEMA DE DRONES AGRÍCOLAS =====");

        boolean autenticado = false;

        while (!autenticado) {
            System.out.print("Usuário: ");
            String user = scanner.nextLine();

            System.out.print("Senha: ");
            String pass = scanner.nextLine();

            if (user.equals(USUARIO_FIXO.getLogin()) && USUARIO_FIXO.validarSenha(pass)) {
                System.out.println("\nLogin realizado!\n");
                autenticado = true;
            } else {
                System.out.println("Usuário ou senha incorretos. Tente novamente.\n");
            }
        }

        // DADOS
        List<Agendamento> agendamentos = new ArrayList<>();
        List<RegistroPlantacao> registros = new ArrayList<>();

        Area area1 = new Area(1000, "A1", "Fazendinha", "Milho");
        Area area2 = new Area(2000, "B1", "Sitio Lagos", "Soja");

        Drone drone1 = new Drone("D1", "Disponível");
        Drone drone2 = new Drone("D2", "Disponível");

        boolean rodando = true;

        while (rodando) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Agendar Voo");
            System.out.println("2 - Concluir Voo");
            System.out.println("3 - Gerar Relatórios");
            System.out.println("4 - Registrar Plantação");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.\n");
                continue;
            }

 switch (opcao) {

    case 1:
        // AGENDAR VOO
        System.out.println("Escolha a área:");
        System.out.println("1 - " + area1.getLocalizacao());
        System.out.println("2 - " + area2.getLocalizacao());

        int a;
        try {
            a = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Entrada inválida.\n");
            break;
        }

        Area areaEscolhida = (a == 1) ? area1 : area2;
        Drone drone = (a == 1) ? drone1 : drone2;

        System.out.print("Data (YYYY-MM-DD): ");
        String dataStr = scanner.nextLine();

        System.out.print("Código do agendamento: ");
        String cod = scanner.nextLine();

        // verificar ID duplicado
        boolean existe = false;
        for (Agendamento ag : agendamentos) {
            if (ag.getId().equals(cod)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("Esse ID já existe! Escolha outro.\n");
            break;
        }

        try {
            Agendamento ag = new Agendamento(cod, dataStr, areaEscolhida, drone);
            if (ag.agendarVoo()) {
                agendamentos.add(ag);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        break;

    case 2:
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento.\n");
            break;
        }

        System.out.println("Agendamentos:");
        for (int i = 0; i < agendamentos.size(); i++) {
            System.out.println(i + " - " + agendamentos.get(i).getId());
        }

        System.out.print("Escolha índice: ");
        int idx;
        try {
            idx = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Entrada inválida.\n");
            break;
        }

        if (idx < 0 || idx >= agendamentos.size()) {
            System.out.println("Índice inválido.\n");
            break;
        }

        agendamentos.get(idx).concluirVoo();
        break;

    case 3:
        System.out.println("=== RELATÓRIOS ===");
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro ainda.\n");
            break;
        }
        for (RegistroPlantacao r : registros) {
            Relatorio rel = new Relatorio(r);
            rel.gerarResumo();
        }
        break;

    case 4:
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum voo agendado.\n");
            break;
        }

        System.out.println("Escolha o voo a registrar:");
        for (int i = 0; i < agendamentos.size(); i++) {
            System.out.println(i + " - " + agendamentos.get(i).getId());
        }

        int rIdx;
        try {
            rIdx = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Entrada inválida.\n");
            break;
        }

        if (rIdx < 0 || rIdx >= agendamentos.size()) {
            System.out.println("Índice inválido.\n");
            break;
        }

        System.out.print("Nome da imagem: ");
        String img = scanner.nextLine();

        RegistroPlantacao reg = new RegistroPlantacao(
                img,
                agendamentos.get(rIdx),
                agendamentos.get(rIdx).getDrone()
        );

        registros.add(reg);
        System.out.println("Registro criado!\n");
        break;

    case 0:
        rodando = false;
        System.out.println("Encerrando...\n");
        break;

    default:
        System.out.println("Opção inválida.\n");
        break;
}

        }
        scanner.close();
    }
}
