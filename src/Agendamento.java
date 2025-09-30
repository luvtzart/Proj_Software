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
    public String getData() { return data; }
    public Area getArea() { return area; }
    public Drone getDrone() { return drone; }
} 
