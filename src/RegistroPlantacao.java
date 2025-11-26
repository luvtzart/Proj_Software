import java.util.Random;

public class RegistroPlantacao {
    private String imagens;
    private Agendamento missao;
    private double temperatura;
    private double umidade;
    private boolean pragas;

    private static final Random random = new Random();

    public RegistroPlantacao(String imagens, Agendamento missao, Drone drone) {
        this.imagens = imagens;
        this.missao = missao;

        // Gera valores aleatórios
        this.temperatura = 15 + (40 - 15) * random.nextDouble();  // 15°C a 40°C
        this.umidade = 20 + (100 - 20) * random.nextDouble();     // 20% a 100%
        this.pragas = random.nextBoolean();                       // true/false
    }

    public String getImagens() { return imagens; }
    public Agendamento getMissao() { return missao; }
    public double getTemperatura() { return temperatura; }
    public double getUmidade() { return umidade; }
    public boolean isPragas() { return pragas; }
}
