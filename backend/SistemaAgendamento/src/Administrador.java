// Classe Administrador herda de Usuario
public class Administrador extends Usuario {

    public Administrador(String username, String senha) {
        super(username, senha);
    }

    // Administrador tem acesso total
    @Override
    public boolean isAdmin() {
        return true;
    }
}
