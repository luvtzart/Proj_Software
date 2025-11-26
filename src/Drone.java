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
        if ("Disponível".equals(this.status)) {
            this.status = "Ocupado";
            System.out.println("Drone " + id + " reservado com sucesso!");
            return true;
        } else {
            System.out.println("Drone " + id + " não está disponível!");
            return false;
        }
    }
    
    public void liberarDrone() {
        this.status = "Disponível";
        System.out.println("O drone " + id + " está liberado!");
    }

}
