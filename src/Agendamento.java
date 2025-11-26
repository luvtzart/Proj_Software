import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Agendamento {
    private String id;
    private LocalDate data;
    private Area area;
    private Drone drone;

    public Agendamento(String id, String data, Area area, Drone drone) {
        this.id = id;
        this.area = area;
        this.drone = drone;

        try {
            this.data = LocalDate.parse(data);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida! Use o formato YYYY-MM-DD.");
        }
    }

    public String getId() { return id; }
    public LocalDate getData() { return data; }
    public Area getArea() { return area; }
    public Drone getDrone() { return drone; }

    public boolean agendarVoo() {
        if (drone == null) {
            System.out.println("Erro: drone não encontrado!");
            return false;
        }

        if (drone.reservarDrone()) {
            System.out.println("Voo agendado na área " + area.getId() + " para " + data);
            return true;
        } else {
            System.out.println("Erro: Drone " + drone.getId() + " está ocupado.");
            return false;
        }
    }

    public void concluirVoo() {
        System.out.println("Voo concluído na área " + area.getId() + " com o drone " + drone.getId());
        drone.liberarDrone();
    }
}
