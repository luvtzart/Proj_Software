public class Drone{
    private String id;
    private String status;

    public Drone(String id,  String status) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID do drone não pode ser nulo ou vazio.");
        }
        this.id = id;
        this.status = status;
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
    
    
    public boolean reservarDrone() {
        if (this.status.equalsIgnoreCase("livre")) {
            this.status = "ocupado";
            return true;
        }
        return false; 
    }
    
    public boolean liberarDrone() {
        if (this.status.equalsIgnoreCase("ocupado")) {
            this.status = "livre";
            return true;
        }
        return false;
    }
     
}
