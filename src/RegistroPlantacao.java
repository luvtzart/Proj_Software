public class RegistroPlantacao {
    private String imagens;
    private Agendamento missao;
    private double temperatura;
    private double umidade;
    private boolean pragas;

    public RegistroPlantacao(String imagens, Agendamento missao, Drone drone) {
        this.imagens = imagens;
        this.missao = missao;
        this.temperatura = drone.getSensor().getTemperatura();
        this.umidade = drone.getSensor().getUmidade();
        this.pragas = drone.getSensor().getPragas();
    }

    public String getImagens() { return imagens; }
    public Agendamento getMissao() { return missao; }
    public double getTemperatura() { return temperatura; }
    public double getUmidade() { return umidade; }
    public boolean isPragas() { return pragas; }
}
