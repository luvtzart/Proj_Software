import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String login;
    private String senhaHash;
    private List<Drone> dronesControlados;

    public Usuario(String login, String senhaHash) {
        this.login = login;
        this.senhaHash = senhaHash;
        this.dronesControlados = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void adicionarDrone(Drone drone) {
        dronesControlados.add(drone);
    }

    public List<Drone> getDronesControlados() {
        return dronesControlados;
    }
}
