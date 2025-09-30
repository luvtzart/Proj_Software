public class Relatorio{
    private RegistroPlantacao registro;

    public Relatorio(RegistroPlantacao registro) {
        this.registro = registro;
    }

    public void gerarResumo() {
        System.out.println("=====[Relatório da Missão]=====");
        System.out.println("[Area] " + registro.getMissao().getArea().getId() + ":" + registro.getMissao().getArea().getTamanho());
        System.out.println("[Drone] " + registro.getMissao().getDrone().getId());
        System.out.println("[Temperatura] " + registro.getTemperatura());
        System.out.println("[Umidade] " + registro.getUmidade());
        System.out.println("[Pragas] " + (registro.isPragas() ? "True" : "False"));
                System.out.println("===============================");

    }
}
