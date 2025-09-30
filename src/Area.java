public class Area{
    private int tamanho;
    private String id;
    private String localizacao;
    private String tipo;

    public Area(int tamanho, String id, String localizacao, String tipo) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("Tamanho da área deve ser maior que zero.");
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID da área não pode ser nulo ou vazio.");
        }
        this.tamanho = tamanho;
        this.id = id;
        this.localizacao = localizacao;
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getId() {
        return id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getTipo() {
        return tipo;
    }
}
