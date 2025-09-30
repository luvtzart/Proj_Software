import java.util.Random;

public class Sensores{
    private double temperatura;
    private double umidade;
    private boolean pragas;
    private final Random random = new Random();

     public Sensores() {
        this.temperatura = random.nextDouble() * 60;
        this.umidade = random.nextDouble() * 100;
        this.pragas = random.nextBoolean();
    }

    public double getTemperatura() { return temperatura; }
    public double getUmidade() { return umidade; }
    public boolean getPragas() { return pragas; }
}