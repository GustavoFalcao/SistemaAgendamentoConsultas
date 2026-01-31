// Classe base para todos os usuários do sistema
public class Usuario {

    protected String username;
    protected String senha;

    // Construtor
    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    // Método de autenticação
    public boolean autenticar(String u, String s) {
        return username.equals(u) && senha.equals(s);
    }

    // Retorna o nome do usuário
    public String getUsername() {
        return username;
    }

    // Define se o usuário é administrador (polimorfismo)
    public boolean isAdmin() {
        return false;
    }
}
