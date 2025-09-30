public class Drone{
    private String id;
    private Sensores sensor;
    private String status;

    public Drone(String id,  String status) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID do drone não pode ser nulo ou vazio.");
        }
        this.id = id;
        this.status = status;
        this.sensor = new Sensores();
    }

    public String getId() {
        return id;
    }
    
    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        return this.status = status;
    }

      public Sensores getSensor() {
        return sensor;
    }    
}

