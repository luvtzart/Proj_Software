public class RegistroPlantacao{
    private String imagens;
    private Agendamento missao;
    private double temperatura;
    private double umidade;
    private boolean pragas;

    public RegistroPlantacao(String imagens, Agendamento missao, double temperatura, double umidade, boolean pragas) {
        this.imagens = imagens;
        this.missao = missao;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pragas = pragas;
    }

    public String getImagens() {
        return imagens;
    }
    public Agendamento getMissao() {
        return missao;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public double getUmidade() {
        return umidade;
    }
    public boolean isPragas() {
        return pragas;
    }
    

}
