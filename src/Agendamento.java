public class Agendamento{
    private String id;
    private String data;
    private Area area;
    private Drone drone;

    public Agendamento(String id, String data, Area area, Drone drone) {
        this.id = id;
        this.data = data;
        this.area = area;
        this.drone = drone;
    }

    public String getId() {
        return id;
    }
    public String getData() {
        return data;
    }
    public Area getArea() {
        return area;
    }
    public Drone getDrone() {
        return drone;
    }
    
    public boolean agendarVoo() {
        if (drone.reservarDrone()) {  
            System.out.println("Voo agendado na área " + area.getId() + " para o drone " + drone.getId());
            return true;
        } else {
            System.out.println("Erro ao agendar o voo! O drone está ocupado.");
            return false;
        }
    }
    
    public void concluirVoo() {
        System.out.println("Voo concluído na área " + area.getId() + " com o drone " + drone.getId());
        drone.liberarDrone();
    }

} 
