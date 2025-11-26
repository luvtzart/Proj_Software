import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                System.out.println("\nLogin realizado com sucesso!\n");
                autenticado = true;
            } else {
                System.out.println("Usuário ou senha incorretos! Tente novamente.\n");
            }
        }

        // DADOS INICIAIS
        List<Agendamento> agendamentos = new ArrayList<>();
        List<RegistroPlantacao> registros = new ArrayList<>();

        Area area1 = new Area(1000, "A1", "Fazendinha", "Milho");
        Area area2 = new Area(2000, "B1", "Sítio Lagos", "Soja");

        Drone drone1 = new Drone("D1", "Disponível");
        Drone drone2 = new Drone("D2", "Disponível");

        boolean rodando = true;

        while (rodando) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1 - Agendar Voo");
            System.out.println("2 - Concluir Voo");
            System.out.println("3 - Gerar Relatórios");
            System.out.println("4 - Registrar Plantação");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    // AGENDAR VOO
                    System.out.println("\nEscolha a área:");
                    System.out.println("1 - Fazendinha (Milho)");
                    System.out.println("2 - Sítio Lagos (Soja)");
                    int areaEscolhida = scanner.nextInt();
                    scanner.nextLine();

                    Area area = (areaEscolhida == 1) ? area1 : area2;
                    Drone drone = (areaEscolhida == 1) ? drone1 : drone2;

                    System.out.print("Data do voo (YYYY-MM-DD): ");
                    String data = scanner.nextLine();

                    System.out.print("Código do agendamento: ");
                    String cod = scanner.nextLine();

                    Agendamento ag = new Agendamento(cod, data, area, drone);
                    ag.agendarVoo();
                    agendamentos.add(ag);

                    System.out.println("Voo agendado com sucesso!\n");
                    break;

                case 2:
                    // CONCLUIR VOO
                    System.out.println("\nAgendamentos pendentes:");
                    for (int i = 0; i < agendamentos.size(); i++) {
                        System.out.println(i + " - " + agendamentos.get(i).getId());
                    }

                    System.out.print("Escolha o índice do voo: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();

                    if (idx >= 0 && idx < agendamentos.size()) {
                        agendamentos.get(idx).concluirVoo();
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;

                case 3:
                    // RELATÓRIOS
                    System.out.println("\n=== RELATÓRIOS ===");
                    for (RegistroPlantacao r : registros) {
                        Relatorio rel = new Relatorio(r);
                        rel.gerarResumo();
                    }
                    System.out.println();
                    break;

                case 4:
                    // REGISTRAR PLANTAÇÃO
                    if (agendamentos.isEmpty()) {
                        System.out.println("Nenhum voo realizado ainda.\n");
                        break;
                    }

                    System.out.println("\nEscolha qual voo deseja registrar:");
                    for (int i = 0; i < agendamentos.size(); i++) {
                        System.out.println(i + " - " + agendamentos.get(i).getId());
                    }
                    int rIdx = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome da imagem: ");
                    String img = scanner.nextLine();

                    RegistroPlantacao reg = new RegistroPlantacao(
                            img,
                            agendamentos.get(rIdx),
                            agendamentos.get(rIdx).getDrone()
                    );

                    registros.add(reg);
                    System.out.println("Registro criado com sucesso!\n");
                    break;

                case 0:
                    rodando = false;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }

        scanner.close();
    }
}
