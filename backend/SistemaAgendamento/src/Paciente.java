// Classe que representa um paciente
public class Paciente {

    private String nome;
    private String cpf;

    // Construtor
    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Atualização de dados (UPDATE)
    public void alterarNome(String novoNome) {
        this.nome = novoNome;
    }

    @Override
    public String toString() {
        return "Paciente: " + nome + " | CPF: " + cpf;
    }
}
