public class Drone{
    private String id;
    private boolean sensorDisponivel;
    private String status;

    public Drone(String id, boolean sensorDisponivel, String status) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID do drone não pode ser nulo ou vazio.");
        }
        this.id = id;
        this.sensorDisponivel = sensorDisponivel;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public boolean isSensorDisponivel() {
        return sensorDisponivel;
    }
    
    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        return this.status = status;
    }

    public void setSensorDisponivel(boolean sensorDisponivel) {
        this.sensorDisponivel = sensorDisponivel;
    }
}
