public class RegistroPlantacao {
    private String imagens;
    private Agendamento missao;
    private double temperatura;
    private double umidade;
    private boolean pragas;

    public RegistroPlantacao(String imagens, Agendamento missao, Drone drone) {
        this.imagens = imagens;
        this.missao = missao;
        this.temperatura =getTemperatura();
        this.umidade = getUmidade();
        this.pragas = pragas;
    }

    public String getImagens() { return imagens; }
    public Agendamento getMissao() { return missao; }
    public double getTemperatura() { return temperatura; }
    public double getUmidade() { return umidade; }
    public boolean isPragas() { return pragas; }
}
