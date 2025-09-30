public class Main{
    public static void main(String[] args) {
        // Criando instâncias de Area e Drone
        Area area1 = new Area(1000, "A1", "Fazendinha", "Milho");
        Drone drone1 = new Drone("D1", "Disponível");

        // Criando um Agendamento
        Agendamento agendamento1 = new Agendamento("AG1", "2024-06-01", area1, drone1);

        // Criando um RegistroPlantacao
        RegistroPlantacao registro1 = new RegistroPlantacao("imagem1.jpg", agendamento1, drone1);

        // Criando um Relatorio
        Relatorio relatorio1 = new Relatorio(registro1);

        // Gerando o resumo do relatório
        relatorio1.gerarResumo();
    }
}
