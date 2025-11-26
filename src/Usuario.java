import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
    private String login;
    private String senhaHash;


    public Usuario(String login, String senha) {
        this.login = login;
        this.senhaHash = gerarHash(senha);
    }

    public String getLogin() {
        return login;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    private String gerarHash(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(senha.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da senha", e);
        }
    }

    public boolean validarSenha(String senhaDigitada) {
        return gerarHash(senhaDigitada).equals(this.senhaHash);
    }
}
