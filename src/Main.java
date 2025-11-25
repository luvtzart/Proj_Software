public class Main {
    public static void main(String[] args) {
        
        Area area1 = new Area(1000, "A1", "Fazendinha", "Milho");
        Area area2 = new Area(2000, "B1", "Sítio Lagos", "Soja");
        
        Drone drone1 = new Drone("D1", "Disponível");
        Drone drone2 = new Drone("D2", "Disponível");
        
        Agendamento ag1 = new Agendamento("AG1", "2024-06-01", area1, drone1);
        Agendamento ag2 = new Agendamento("AG2", "2024-06-02", area2, drone2);
        Agendamento ag3 = new Agendamento("AG3", "2024-06-03", area1, drone1);
        
        System.out.println("\nVoos agendados: ");
        ag1.agendarVoo();
        ag2.agendarVoo();
        ag3.agendarVoo();
        
        RegistroPlantacao registro1 = new RegistroPlantacao("imagem1.jpg", ag1, drone1);
        RegistroPlantacao registro2 = new RegistroPlantacao("imagem2.jpg", ag2, drone2);

        Relatorio rel1 = new Relatorio(registro1);
        Relatorio rel2 = new Relatorio(registro2);
        
        System.out.println("\nRelatorio dos voos ");
        rel1.gerarResumo();
        rel2.gerarResumo();
        
        System.out.println("\nVoos concluidos: ");
        ag1.concluirVoo();
        ag2.concluirVoo();
        
        System.out.println("\nAgendar voo:");
        ag3.agendarVoo(); 
    }
}

