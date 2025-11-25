import java.util.HashSet;
import java.util.Set;

public class Sensor {
    private static final Set<String> IDS_USADOS = new HashSet<>();

    private String idSensor;
    private double temperatura;
    private double umidade;
    private boolean pragas;

    public Sensor(String idSensor, double temperatura, double umidade, boolean pragas) {

        if (idSensor == null || idSensor.isBlank()) {
            throw new IllegalArgumentException("ID do sensor não pode ser nulo ou vazio.");
        }
        
        if (IDS_USADOS.contains(idSensor)) {
            throw new IllegalArgumentException("ID de sensor já está em uso: " + idSensor);
        }

        IDS_USADOS.add(idSensor);

        this.idSensor = idSensor;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pragas = pragas;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public boolean getPragas() {
        return pragas;
    }
    
    public Sensor getSensor() {
        return this.sensor;
    }
    
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
    
    public void atualizarLeituras(double temperatura, double umidade, boolean pragas) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pragas = pragas;
    }
}
